package ar.edu.unlam.materia;

public class Aula {
	
	private Integer id;
	private Integer capacidadMaxima;
	
	public Aula(Integer id, Integer capacidadMaxima) {
		this.id = id;
		this.capacidadMaxima = capacidadMaxima;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCapacidadMaxima() {
		return capacidadMaxima;
	}

	public void setCapacidadMaxima(Integer capacidadMaxima) {
		this.capacidadMaxima = capacidadMaxima;
	}
	
	
	
	

}
