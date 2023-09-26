package ar.edu.unlam.materia;

import java.util.ArrayList;

public class Universidad {

	private ArrayList<Alumno> alumnos;
	private ArrayList<Materia> materias;
	private ArrayList<CicloLectivo> ciclosLectivos;
	private ArrayList<Comision> comisiones;
	private ArrayList<Profesor> profesores;

	public Universidad() {
		materias = new ArrayList<>();
		alumnos = new ArrayList<>();
		ciclosLectivos = new ArrayList<>();
		comisiones = new ArrayList<>();
		profesores = new ArrayList<>();
	}

	public Boolean agregarMateria(Materia materia) {
		if (buscarMateria(materia.getId()) == null) {
			return materias.add(materia);
		}
		return false;
	}

	public Materia buscarMateria(Integer id) {
		for (int i = 0; i < this.materias.size(); i++) {
			if (this.materias.get(i).getId().equals(id)) {
				return this.materias.get(i);
			}
		}
		return null;
	}

	public Boolean agregarAlumno(Alumno alumno) {
		if (buscarAlumno(alumno.getDni()) == null) {
			return alumnos.add(alumno);
		}
		return false;
	}

	public Alumno buscarAlumno(Integer dni) {
		for (int i = 0; i < alumnos.size(); i++) {
			if (this.alumnos.get(i).getDni().equals(dni)) {
				return this.alumnos.get(i);
			}
		}
		return null;
	}

	public Boolean agregarCicloLectivo(CicloLectivo actual) {
		if (buscarCicloLectivo(actual.getId()) == null) {
			return ciclosLectivos.add(actual);
		}
		return false;
	}

	public Boolean ciclosSuperpuestos(CicloLectivo primero, CicloLectivo segundo) {

		if (segundo.getFechaDeInicio().isAfter(primero.getFechaDeInicio())
				&& segundo.getFechaDeInicio().isBefore(primero.getFechaDeFinalizacion())) {
			return true;
		}

		return false;
	}

	public CicloLectivo buscarCicloLectivo(Integer id) {

		for (int i = 0; i < ciclosLectivos.size(); i++) {
			if (this.ciclosLectivos.get(i).getId().equals(id)) {
				return this.ciclosLectivos.get(i);
			}
		}
		return null;
	}

	public Boolean agregarComision(Comision comision) {
	    for (Comision com : comisiones) {
	        if (com.getMateria().equals(comision.getMateria()) &&
	            com.getCicloLectivo().equals(comision.getCicloLectivo()) &&
	            com.getTurno().equals(comision.getTurno())) {
	            return false; // Si ya existe una comisión con la misma materia, ciclo lectivo y turno, devolvemos false
	        }
	    }
	    return comisiones.add(comision); // Si no existe, agregamos la comisión
	}

	public Comision buscarComision(Integer idComision) {
	    for (Comision comision : comisiones) {
	        if (comision.getId().equals(idComision)) {
	            return comision;
	        }
	    }
	    return null;
	}


	public Boolean agregarProfesor(Profesor profe) {
		if (buscarProfesor(profe.getDni()) == null) {

			return profesores.add(profe);
		}

		return false;
	}

	public Profesor buscarProfesor(Integer dni) {
		for (int i = 0; i < profesores.size(); i++) {
			if (this.profesores.get(i).getDni().equals(dni)) {
				return this.profesores.get(i);
			}
		}
		return null;
	}

	public Boolean agregarCorrelativa(Integer idMateria, Integer idCorrelativa) {
		Materia materia = buscarMateria(idMateria);
		Materia correlativa = buscarMateria(idCorrelativa);

		if (materia != null && correlativa != null) {
			return materia.asignarCorrelativa(correlativa);
		}

		return false;

	}
    public Boolean eliminarCorrelativa(Integer idMateria, Integer idCorrelativa) {
        Materia materia = buscarMateria(idMateria);
        Materia correlativa = buscarMateria(idCorrelativa);

        if (materia != null && correlativa != null && materia.getCorrelativas().contains(correlativa)) {
            return materia.getCorrelativas().remove(correlativa);
        }
        return false;
    }

    public Boolean inscribirAlumnoAComision(Integer dni, Integer idComision) {
        Alumno alumno = buscarAlumno(dni);
        Comision comision = buscarComision(idComision);

        if (alumno != null && comision != null && !comision.getAlumnos().contains(alumno)) {
            return comision.getAlumnos().add(alumno);
        }
        return false;
    }

    public Boolean asignarProfesorAComision(Integer dni, Integer idComision) {
        Profesor profesor = buscarProfesor(dni);
        Comision comision = buscarComision(idComision);

        if (profesor != null && comision != null && !comision.getProfesores().contains(profesor)) {
            return comision.getProfesores().add(profesor);
        }
        return false;
    }
    
    public Boolean registrarNota(Integer idComision, Integer dni, Double nota) {
        Comision comision = buscarComision(idComision);
        Alumno alumno = buscarAlumno(dni);

        if (comision != null && alumno != null && comision.getAlumnos().contains(alumno)) {
            Examen examen = new Examen(alumno, nota);
            return comision.getExamenes().add(examen);
        }
        return false;
    }


    public ArrayList<Materia> obtenerMateriasAprobadasParaUnAlumno(Integer dni) {
        Alumno alumno = buscarAlumno(dni);
        ArrayList<Materia> materiasAprobadas = new ArrayList<>();

        if (alumno != null) {
            for (Comision comision : comisiones) {
                if (comision.getAlumnos().contains(alumno)) {
                    if (comision.alumnoAprobo(alumno)) { // Verificamos si el alumno aprobó la materia en esta comisión
                        materiasAprobadas.add(comision.getMateria());
                    }
                }
            }
        }
        return materiasAprobadas;
    }



    public Double obtenerNota(Integer dni, Integer idMateria) {
        Alumno alumno = buscarAlumno(dni);
        Materia materia = buscarMateria(idMateria);

        if (alumno != null && materia != null) {
            for (Comision comision : comisiones) {
                if (comision.getAlumnos().contains(alumno) && comision.getMateria().equals(materia)) {
                    return comision.obtenerNota(alumno); // Obtenemos la nota del alumno en esta comisión
                }
            }
        }
        return null;
    }

    
    public ArrayList<Materia> obtenerMateriasFaltantesParaUnAlumno(Integer dni) {
        Alumno alumno = buscarAlumno(dni);
        ArrayList<Materia> materiasFaltantes = new ArrayList<>(materias); // Inicialmente, asumimos que el alumno no ha cursado ninguna materia

        if (alumno != null) {
            for (Comision comision : comisiones) {
                if (comision.getAlumnos().contains(alumno)) {
                    if (comision.alumnoAprobo(alumno)) { // Verificamos si el alumno aprobó la materia en esta comisión
                        materiasFaltantes.remove(comision.getMateria());
                    }
                }
            }
        }
        return materiasFaltantes;
    }


    public Double calcularPromedio(Integer dni) {
        Alumno alumno = buscarAlumno(dni);
        Double sumaNotas = 0.0;
        Integer cantidadNotas = 0;

        if (alumno != null) {
            for (Comision comision : comisiones) {
                if (comision.getAlumnos().contains(alumno)) {
                    for (Examen examen : comision.getExamenes()) {
                        if (examen.getAlumno().equals(alumno)) {
                            sumaNotas += examen.getNota();
                            cantidadNotas++;
                        }
                    }
                }
            }
        }
        return cantidadNotas > 0 ? sumaNotas / cantidadNotas : null; // Si el alumno tiene notas, calculamos el promedio. Si no, devolvemos null.
    }
}
