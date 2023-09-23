package ar.edu.unlam.pb2.transporte;

public class Bicicleta extends Transporte {

	private String destino;

	@Override
	protected Boolean pesoCompatible(Paquete paquete) {
		return (paquete.getPeso() <= 15.0);
	}

	protected Boolean volumenCompatible(Paquete paquete) {
		return (paquete.getVolumen() <= 0.125);
	}

	protected Boolean cantidadDePaquetesCompatible() {
		return this.paquetes.size() < 2;
	}

	protected Boolean destinoCompatible(String destino) {
		if (this.destino == null) {
			this.destino = destino;
		}
		return this.destino.equals(destino);
	}

	@Override
	protected void agregarPaquete(Paquete paquete) {
		this.paquetes.add(paquete);		
	}

}
