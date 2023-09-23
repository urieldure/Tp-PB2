package ar.edu.unlam.pb2.transporte;

public class Paquete {

	private Double alto;
	private Double ancho;
	private Double profundo;
	private Double peso;

	public Paquete(Double alto, Double ancho, Double profundo, Double peso) {
		this.alto = alto;
		this.ancho = ancho;
		this.profundo = profundo;
		this.peso=peso;
	}

	public Double getVolumen() {
		return this.alto * this.ancho * this.profundo;
	}

	public Double getPeso() {
		return peso;
	}

}
