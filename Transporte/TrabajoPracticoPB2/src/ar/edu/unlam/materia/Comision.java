package ar.edu.unlam.materia;

import java.util.ArrayList;

public class Comision {

	private Integer id;
	private ArrayList<Alumno> alumnos;
	private ArrayList<Profesor> profesores;
	private CicloLectivo cicloLectivo;
	private Materia materia;
	private Turno turno;
	
	public Comision (Integer id, CicloLectivo cicloLectivo, Materia materia, Turno turno) {
		this.id = id;
		this.cicloLectivo = cicloLectivo;
		this.materia = materia;
		this.turno = turno;
		alumnos = new ArrayList<>();
		profesores = new ArrayList<>();
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
		if (buscarProfesor(profe.getDni()) == null) {
				return profesores.add(profe);
			}
			return false;
			
		}
	
	
	private Profesor buscarProfesor(Integer dni) {
		for (int i = 0; i < profesores.size(); i++) {
			if (this.profesores.get(i).getDni().equals(dni)) {
				return this.profesores.get(i);
			}
		}
		return null;
	}
	
	
	
}
