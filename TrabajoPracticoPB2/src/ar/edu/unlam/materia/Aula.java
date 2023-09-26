package ar.edu.unlam.materia;

import java.util.ArrayList;

public class Aula {
	
	private Integer id;
	private Integer capacidadMaxima;
	private ArrayList<Alumno> alumnosEnAula;
	
	public Aula(Integer id, Integer capacidadMaxima) {
		this.id = id;
		this.capacidadMaxima = capacidadMaxima;
        this.alumnosEnAula = new ArrayList<>();
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
    }

    public ArrayList<Alumno> getAlumnosEnAula() {
        return alumnosEnAula; 
    }

    public void setAlumnosEnAula(ArrayList<Alumno> alumnosEnAula) {
        this.alumnosEnAula = alumnosEnAula; 
    }

    public Integer getCapacidadRestante() {
        return capacidadMaxima - this.alumnosEnAula.size();
    }

    public void setCapacidadMaxima(Integer capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima; 
    }
    
    public void agregarAlumno(Alumno alumno) {
        if (this.alumnosEnAula.size() < this.capacidadMaxima) {
            this.alumnosEnAula.add(alumno);
        } else {
            System.out.println("El aula está llena. No se puede agregar al alumno: " + alumno);
        }
    }

}
