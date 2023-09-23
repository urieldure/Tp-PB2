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
		id++;
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

	public Boolean asignarCorrelativa(Integer idCorrelativa) {
		Universidad unlam = new Universidad();
		if (correlativas.contains(unlam.buscarMateria(idCorrelativa))) {
			return false;
		}
		
		return correlativas.add(unlam.buscarMateria(idCorrelativa));
	}
	
}
	
	

