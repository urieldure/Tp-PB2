package ar.edu.unlam.materia;

import java.util.ArrayList;

public class Materia {
	
	private String nombre;
	private Integer id;
	private ArrayList<Materia> correlativas;
	
	public Materia(String nombre, Integer id) {
		this.nombre = nombre;
		this.id = id;
		this.correlativas = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ArrayList<Materia> getCorrelativas() {
		return correlativas;
	}

	public void setCorrelativas(ArrayList<Materia> correlativas) {
		this.correlativas = correlativas;
	}

	public boolean asignarCorrelativa(Materia correlativa) {
        if (!this.correlativas.contains(correlativa)) { // Verificamos que la correlativa no esté ya asignada a la materia
            this.correlativas.add(correlativa);
            return true; // Devolvemos true si la correlativa se asignó con éxito
        }
        return false; // Si la correlativa ya está asignada a la materia, devolvemos false
    }
}
