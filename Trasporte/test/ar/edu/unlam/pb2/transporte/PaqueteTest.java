package ar.edu.unlam.pb2.transporte;

import static org.junit.Assert.*;

import org.junit.Test;

public class PaqueteTest {

	@Test
	public void queElVolumenDeUnPaqueteDe1_0x1_0x1_0Da1_0() {
		// Preparación
		Paquete paquete = new Paquete(1.0, 1.0, 1.0,1.0);
		Double valumenEsperado = 1.0;
		// Ejecución
		Double volumenObtenido = paquete.getVolumen();
		// Contrastación o validación
		assertEquals(valumenEsperado, volumenObtenido);
	}

	@Test
	public void queElVolumenDeUnPaqueteDe0_5x0_5x0_5Da0_125() {
		Paquete paquete = new Paquete(0.5, 0.5, 0.5,1.0);
		Double valumenEsperado = 0.125;
		Double volumenObtenido = paquete.getVolumen();
		assertEquals(valumenEsperado, volumenObtenido);
	}
}
