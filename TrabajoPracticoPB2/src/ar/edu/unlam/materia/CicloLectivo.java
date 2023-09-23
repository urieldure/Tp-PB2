package ar.edu.unlam.materia;

import java.time.LocalDate;

public class CicloLectivo {
	
	private Integer id;
	private LocalDate fechaDeInicio;
	private LocalDate fechaDeFinalizacion;
	private LocalDate fechaDeInscripcion;
	
	public CicloLectivo(Integer id, LocalDate fechaDeInicio, LocalDate fechaDeFinalizacion, LocalDate fechaDeInscripcion) {
		this.id = id;
		this.fechaDeInicio = fechaDeInicio;
		this.fechaDeFinalizacion = fechaDeFinalizacion;
		this.fechaDeInscripcion = fechaDeInscripcion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getFechaDeInicio() {
		return fechaDeInicio;
	}

	public void setFechaDeInicio(LocalDate fechaDeInicio) {
		this.fechaDeInicio = fechaDeInicio;
	}

	public LocalDate getFechaDeFinalizacion() {
		return fechaDeFinalizacion;
	}

	public void setFechaDeFinalizacion(LocalDate fechaDeFinalizacion) {
		this.fechaDeFinalizacion = fechaDeFinalizacion;
	}

	public LocalDate getFechaDeInscripcion() {
		return fechaDeInscripcion;
	}

	public void setFechaDeInscripcion(LocalDate fechaDeInscripcion) {
		this.fechaDeInscripcion = fechaDeInscripcion;
	}
	
	

	

}
