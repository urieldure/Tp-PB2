package ar.edu.unlam.pb2.transporte;

import static org.junit.Assert.*;

import org.junit.Test;

public class BicicletaTest {

	@Test
	public void queSePuedaCargarPaquetePequeñoPorVolumen() {
		Bicicleta bici = new Bicicleta();
		Paquete p1 = new Paquete(0.1, 0.1, 0.1, 0.1);
		Boolean agrego = bici.cargarPaquete(p1, "Hurlingham");
		assertTrue(agrego);
	}

	@Test
	public void queNoSePuedaCargarPaqueteGrandePorVolumen() {
		Bicicleta bici = new Bicicleta();
		Paquete p1 = new Paquete(1.0, 0.5, 0.5, 0.1);
		Boolean agrego = bici.cargarPaquete(p1, "Hurlingham");
		assertFalse(agrego);
	}

	@Test
	public void queNoSePuedaCargarPaquetePequeñoPorPeso() {
		Bicicleta bici = new Bicicleta();
		Paquete p1 = new Paquete(0.1, 0.1, 0.1, 15.1);
		Boolean agrego = bici.cargarPaquete(p1, "Hurlingham");
		assertFalse(agrego);
	}

	@Test
	public void queSePuedaCargarPaquetePequeñoPorPeso() {
		Bicicleta bici = new Bicicleta();
		Paquete p1 = new Paquete(0.1, 0.1, 0.1, 15.0);
		Boolean agrego = bici.cargarPaquete(p1, "Hurlingham");
		assertTrue(agrego);
	}

	@Test
	public void queNoSePuedaSuperarElLimiteDepaquetes() {
		Bicicleta bici = new Bicicleta();
		Integer valorEsperado = 2;
		Paquete p1 = new Paquete(0.1, 0.1, 0.1, 0.1);
		Paquete p2 = new Paquete(0.1, 0.1, 0.1, 0.1);
		Paquete p3 = new Paquete(0.1, 0.1, 0.1, 0.1);

		assertTrue(bici.cargarPaquete(p1, "Hurlingham"));
		assertTrue(bici.cargarPaquete(p2, "Hurlingham"));

		Boolean agrego = bici.cargarPaquete(p3, "Hurlingham");
		assertEquals(false, agrego);
		assertEquals(valorEsperado,bici.getCantidadDepaquetes());
	}
	
	@Test
	public void queNoSePuedaCargarDestinosDistintos() {
		Bicicleta bici = new Bicicleta();

		Paquete p1 = new Paquete(0.1, 0.1, 0.1, 0.1);
		Paquete p2 = new Paquete(0.1, 0.1, 0.1, 0.1);		

		assertTrue(bici.cargarPaquete(p1, "Hurlingham"));
		assertFalse(bici.cargarPaquete(p2, "El Palomar"));		
	}

}
