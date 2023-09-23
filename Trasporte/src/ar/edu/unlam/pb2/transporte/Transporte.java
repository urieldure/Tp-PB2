package ar.edu.unlam.pb2.transporte;

import java.util.ArrayList;
import java.util.List;

public abstract class Transporte {

	protected List<Paquete> paquetes = new ArrayList<Paquete>();

	public Boolean cargarPaquete(Paquete paquete, String destino) {

		if (!destinoCompatible(destino)) {
			return false;
		}

		if (!cantidadDePaquetesCompatible()) {
			return false;
		}

		if (!volumenCompatible(paquete)) {
			return false;
		}

		if (pesoCompatible(paquete)) {
			agregarPaquete(paquete);
			return true;
		}

		return false;
	}

	protected abstract void agregarPaquete(Paquete paquete);

	protected abstract Boolean pesoCompatible(Paquete paquete);
		
	protected abstract Boolean volumenCompatible(Paquete paquete);

	protected abstract Boolean cantidadDePaquetesCompatible() ;

	protected abstract Boolean destinoCompatible(String destino) ;

	public Integer getCantidadDepaquetes() {
		return this.paquetes.size();
	}

}
