package ar.edu.unlam.materia;

import java.util.ArrayList;

public class Comision {

	private Integer id;
	private ArrayList<Alumno> alumnos;
	private ArrayList<Profesor> profesores;
	private CicloLectivo cicloLectivo;
	private Materia materia;
	private Turno turno;
	private ArrayList<Examen> examenes;
	private ArrayList <Aula> aulas;
	
	public Comision (Integer id, CicloLectivo cicloLectivo, Materia materia, Turno turno) {
	    this.id = id;
	    this.cicloLectivo = cicloLectivo;
	    this.materia = materia;
	    this.turno = turno;
	    alumnos = new ArrayList<>();
	    profesores = new ArrayList<>();
	    examenes = new ArrayList<>();
	    aulas = new ArrayList<>();
	}


	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos; 
    }

    public void setAlumnos(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos; 
    }

    public ArrayList<Profesor> getProfesores() {
        return profesores; 
    }

    public void setProfesores(ArrayList<Profesor> profesores) {
        this.profesores = profesores; 
    }

    public CicloLectivo getCicloLectivo() {
        return cicloLectivo; 
    }

    public void setCicloLectivo(CicloLectivo cicloLectivo) {
        this.cicloLectivo = cicloLectivo; 
    }

    public Materia getMateria() {
        return materia; 
    }

    public void setMateria(Materia materia) {
        this.materia = materia; 
    }

    public Turno getTurno() {
        return turno; 
    }

    public void setTurno(Turno turno) {
        this.turno = turno; 
    }
    
    public Boolean asignarProfesor(Profesor profe) {
        if (!this.profesores.contains(profe)) { 
            return this.profesores.add(profe);
        }
        return false; 
    }
    
    public ArrayList<Examen> getExamenes() {
        return examenes;
    }

    public void setExamenes(ArrayList<Examen> examenes) {
        this.examenes = examenes;
    }
    
    public Double obtenerNota(Alumno alumno) {
        for (Examen examen : examenes) {
            if (examen.getAlumno().equals(alumno)) {
                return examen.getNota();
            }
        }
        return null; 
    }

    public Boolean alumnoAprobo(Alumno alumno) {
        for (Examen examen : examenes) {
            if (examen.getAlumno().equals(alumno)) {
                return examen.getNota() >= 4.0;
            }
        }
        return false; 
    }

	public Boolean asignarAula(Aula aula) {
		if (!this.aulas.contains(aula)) {
			return aulas.add(aula);
		}
		return false;
	}


}
