package ar.edu.unlam.pb2.transporte;

import static org.junit.Assert.*;

import org.junit.Test;

public class AutoTest {

	@Test
	public void queSePuedaCargarPaquetePequenio() {
		Auto auto = new Auto();
		Paquete p1 = new Paquete(0.1, 0.1, 0.1, 1.0);
		assertTrue(auto.cargarPaquete(p1, "Hurlingham"));
	}
	
	@Test
	public void queSePuedaCargarDosPaquetePequenios() {
		Auto auto = new Auto();
		Paquete p1 = new Paquete(0.1, 0.1, 0.1, 1.0);
		Paquete p2 = new Paquete(0.1, 0.1, 0.1, 1.0);
		assertTrue(auto.cargarPaquete(p1, "Hurlingham"));
		assertTrue(auto.cargarPaquete(p2, "Hurlingham"));
	}
		
	@Test
	public void queNoSePuedaCargarMasDeTresDestinosDistintos() {
		Auto auto = new Auto();
		Paquete p1 = new Paquete(0.1, 0.1, 0.1, 1.0);
		Paquete p2 = new Paquete(0.1, 0.1, 0.1, 1.0);
		Paquete p3 = new Paquete(0.1, 0.1, 0.1, 1.0);
		Paquete p4 = new Paquete(0.1, 0.1, 0.1, 1.0);
		Paquete p5 = new Paquete(0.1, 0.1, 0.1, 1.0);
		assertTrue(auto.cargarPaquete(p1, "Hurlingham"));
		assertTrue(auto.cargarPaquete(p2, "3 de Febrero"));
		assertTrue(auto.cargarPaquete(p3, "San Martín"));
		assertFalse(auto.cargarPaquete(p4, "El Palomar"));
		assertTrue(auto.cargarPaquete(p5, "San Martín"));
	}
	
	@Test
	public void queNoSePuedaCargarVolumenExcedido() {
		Auto auto = new Auto();
		Paquete p1 = new Paquete(1.0, 1.0, 2.1, 1.0);
		assertFalse(auto.cargarPaquete(p1, "Hurlingham"));		
	}
	
	@Test
	public void queNoSePuedaCargarVolumenExcedidoEnVariosPaquetes() {
		Auto auto = new Auto();
		Paquete p1 = new Paquete(1.0, 1.0, 2.0, 1.0);
		Paquete p2 = new Paquete(0.01, 0.01, 0.01, 1.0);
		assertTrue(auto.cargarPaquete(p1, "Hurlingham"));
		assertFalse(auto.cargarPaquete(p2, "Hurlingham"));		
	}
	
	@Test
	public void queNoSePuedaCargarConPesoExcedidoEnUnPaquete() {
		Auto auto = new Auto();
		Paquete p1 = new Paquete(0.5, 0.5, 0.5, 500.1);
		assertFalse(auto.cargarPaquete(p1, "Hurlingham"));		
	}
	
	@Test
	public void queNoSePuedaCargarConPesoExcedidoEnVariosPaquetes() {
		Auto auto = new Auto();
		Paquete p1 = new Paquete(0.5, 0.5, 0.5, 500.0);
		Paquete p2 = new Paquete(0.5, 0.5, 0.5, 0.01);
		assertTrue(auto.cargarPaquete(p1, "Hurlingham"));	
		assertFalse(auto.cargarPaquete(p2, "Hurlingham"));		
	}
}
