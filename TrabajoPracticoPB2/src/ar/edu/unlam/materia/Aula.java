package ar.edu.unlam.materia;

import java.util.ArrayList;

public class Aula {
	
	private Integer id;
	private Integer capacidadMaxima;
	private ArrayList<Alumno> alumnosEnAula; // Para llevar un registro de los alumnos en el aula
	
	public Aula(Integer id, Integer capacidadMaxima) {
		this.id = id;
		this.capacidadMaxima = capacidadMaxima;
        this.alumnosEnAula = new ArrayList<>(); // Inicializamos la lista de alumnos en el aula
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
    }

    public ArrayList<Alumno> getAlumnosEnAula() {
        return alumnosEnAula; // Getter para la lista de alumnos en el aula
    }

    public void setAlumnosEnAula(ArrayList<Alumno> alumnosEnAula) {
        this.alumnosEnAula = alumnosEnAula; // Setter para la lista de alumnos en el aula
    }

	public Integer getCapacidadMaxima() {
        return capacidadMaxima - this.alumnosEnAula.size(); // Devolvemos la capacidad máxima menos la cantidad de alumnos actualmente en el aula
    }

    public void setCapacidadMaxima(Integer capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima; 
    }
}
