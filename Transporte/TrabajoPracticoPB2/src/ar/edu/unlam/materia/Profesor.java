package ar.edu.unlam.materia;

import java.time.LocalDate;

public class Profesor {
	
	private String nombre;
	private String apellido;
	private Integer dni;
	private LocalDate fechaDeNacimiento;
	private LocalDate fechaDeIngreso;
	
	public Profesor(String nombre, String apellido, Integer dni, LocalDate fechaDeNacimiento, LocalDate fechaDeIngreso) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.fechaDeIngreso = fechaDeIngreso;
	}
	
	public Profesor(String nombre, String apellido, Integer dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public LocalDate getFechaDeIngreso() {
		return fechaDeIngreso;
	}

	public void setFechaDeIngreso(LocalDate fechaDeIngreso) {
		this.fechaDeIngreso = fechaDeIngreso;
	}
	
	
	
	

}
