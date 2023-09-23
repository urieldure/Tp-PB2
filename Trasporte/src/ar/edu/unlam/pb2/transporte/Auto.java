package ar.edu.unlam.pb2.transporte;

import java.util.ArrayList;
import java.util.List;

public class Auto extends Transporte {

	private List<String> destinos = new ArrayList<String>();
	private Double pesoTotal = 0.0;
	private Double volumenTotal = 0.0;

	protected Boolean pesoCompatible(Paquete paquete) {
		return paquete.getPeso() + this.pesoTotal <= 500;
	}

	protected Boolean volumenCompatible(Paquete paquete) {
		return paquete.getVolumen() + this.volumenTotal <= 2;
	}

	protected Boolean cantidadDePaquetesCompatible() {
		return true;
	}

	protected Boolean destinoCompatible(String destino) {
		if (this.destinos.contains(destino) || this.destinos.size() < 3 && !this.destinos.contains(destino)) {
			this.destinos.add(destino);
			return true;
		}
		return false;
	}

	@Override
	protected void agregarPaquete(Paquete paquete) {
		this.paquetes.add(paquete);
		this.pesoTotal += paquete.getPeso();
		this.volumenTotal += paquete.getVolumen();

	}

}
