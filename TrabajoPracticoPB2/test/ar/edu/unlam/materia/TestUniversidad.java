package ar.edu.unlam.materia;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;

public class TestUniversidad {

	@Test
	public void queSePuedaAgregarUnaMateria() {
		String nombreMateria = "PB2";
		Integer idMateria = 123;
		Materia materia = new Materia (nombreMateria, idMateria);
		Universidad unlam = new Universidad();
		
		Boolean materiaAgregada = unlam.agregarMateria(materia);
		
		assertTrue(materiaAgregada);
		
	}
	
	@Test
	public void queNoSePuedaAgregarDosMateriasConElMismoId() {
		Universidad unlam = new Universidad();
		
		String nombreMateria = "PB2";
		Integer idMateria = 123;
		Materia materia = new Materia (nombreMateria, idMateria);
		unlam.agregarMateria(materia);
		
		String nombreMateria2 = "PB1";
		Materia materia2 = new Materia (nombreMateria2, idMateria);
		
		Boolean materiaAgregada = unlam.agregarMateria(materia2);
		assertFalse(materiaAgregada);
	}

	@Test
	public void queSePuedaAgregarUnAlumno() {
		String nombreAlumno = "Martin", apellidoAlumno = "Zaccardo";
		Integer dni = 123;
		Alumno alumno = new Alumno(nombreAlumno, apellidoAlumno, dni);
		Universidad unlam = new Universidad();
		
		Boolean alumnoAgregado = unlam.agregarAlumno(alumno);
		
		assertTrue(alumnoAgregado);
		
	}
	
	@Test
	public void queNoSePuedanAgregarDosAlumnosConElMismoDni() {
		Universidad unlam = new Universidad();
		String nombreAlumno = "Martin", apellidoAlumno = "Zaccardo";
		Integer dni = 123;
		Alumno alumno = new Alumno(nombreAlumno, apellidoAlumno, dni);
		
		unlam.agregarAlumno(alumno);
		
		String nombreAlumno2 = "Rodrigo", apellidoAlumno2 = "Flores";
		Alumno alumno2 = new Alumno (nombreAlumno2, apellidoAlumno2, dni);
		
		Boolean alumnoAgregado = unlam.agregarAlumno(alumno2);
		
		assertFalse(alumnoAgregado);
		
	}
	
	@Test
	public void queSePuedaAgregarUnCicloLectivo() {
		Universidad unlam = new Universidad();
		
		Integer id = 123;
		LocalDate fechaDeInicio = LocalDate.parse("2023-03-01");
		LocalDate fechaDeFinalizacion = LocalDate.parse("2023-07-01");
		LocalDate fechaDeInscripcion = LocalDate.parse("2023-02-01");
		CicloLectivo actual = new CicloLectivo (id, fechaDeInicio, fechaDeFinalizacion, fechaDeInscripcion);
		
		Boolean cicloLectivoAgregado = unlam.agregarCicloLectivo(actual);
		
		assertTrue(cicloLectivoAgregado);
		
	}
	
	@Test
	public void queNoSePuedanAgregarDosCiclosLectivosConMismoId() {
		Universidad unlam = new Universidad();
		
		Integer id = 123;
		LocalDate fechaDeInicio = LocalDate.parse("2023-03-01");
		LocalDate fechaDeFinalizacion = LocalDate.parse("2023-07-01");
		LocalDate fechaDeInscripcion = LocalDate.parse("2023-02-01");
		CicloLectivo actual = new CicloLectivo (id, fechaDeInicio, fechaDeFinalizacion, fechaDeInscripcion);
		
		unlam.agregarCicloLectivo(actual);
		
		LocalDate fechaDeInicio2 = LocalDate.parse("2023-07-01");
		LocalDate fechaDeFinalizacion2 = LocalDate.parse("2023-12-01");
		LocalDate fechaDeInscripcion2 = LocalDate.parse("2023-06-01");		
		CicloLectivo actual2 = new CicloLectivo (id, fechaDeInicio2, fechaDeFinalizacion2, fechaDeInscripcion2);
		
		Boolean cicloLectivoAgregado = unlam.agregarCicloLectivo(actual2);
		
		assertFalse(cicloLectivoAgregado);
		
	}
	
	@Test
	public void queNoSePuedanSuperponerLosRangosDeFechasEntreDosCiclosDistintos() {
		Universidad unlam = new Universidad();
		
		Integer id = 123;
		LocalDate fechaDeInicio = LocalDate.parse("2023-03-01");
		LocalDate fechaDeFinalizacion = LocalDate.parse("2023-05-01");
		LocalDate fechaDeInscripcion = LocalDate.parse("2023-02-01");
		CicloLectivo primero = new CicloLectivo (id, fechaDeInicio, fechaDeFinalizacion, fechaDeInscripcion);
		
		unlam.agregarCicloLectivo(primero);
		
		Integer id2 = 321;
		LocalDate fechaDeInicio2 = LocalDate.parse("2023-04-01");
		LocalDate fechaDeFinalizacion2 = LocalDate.parse("2023-05-01");
		LocalDate fechaDeInscripcion2 = LocalDate.parse("2023-03-01");
		CicloLectivo segundo = new CicloLectivo (id2, fechaDeInicio2, fechaDeFinalizacion2, fechaDeInscripcion2);
		
		unlam.agregarCicloLectivo(segundo);
		
		Boolean ciclosSuperpuestos = unlam.ciclosSuperpuestos(primero, segundo);
		
		assertTrue(ciclosSuperpuestos);
		
	}
	
	@Test
	public void queSePuedaAgregarUnaComision() {
		Universidad unlam = new Universidad();
		
		Integer id = 123;
		CicloLectivo actual = new CicloLectivo(56, LocalDate.parse("2023-03-01"), LocalDate.parse("2023-07-01"), LocalDate.parse("2023-02-01"));
		Materia materia = new Materia("PB2", 456); 
		Turno turno = Turno.MAÑANA;
		Comision comision = new Comision(id, actual, materia, turno);
		
		Boolean comisionAgregada = unlam.agregarComision(comision);
		
		assertTrue(comisionAgregada);
	}
	
	@Test
	public void queNoSePuedaGenerarDosOMasComisionesConLaMismaMateriaCicloYTurno() {
		Universidad unlam = new Universidad();
		
		Integer id = 123;
		CicloLectivo actual = new CicloLectivo(56, LocalDate.parse("2023-03-01"), LocalDate.parse("2023-07-01"), LocalDate.parse("2023-02-01"));
		Materia materia = new Materia("PB2", 456); 
		Turno turno = Turno.MAÑANA;
		Comision comision = new Comision(id, actual, materia, turno);
		
		unlam.agregarComision(comision);
		
		Comision comision2 = new Comision(987, actual, materia, turno);
		Boolean comisionAgregada = unlam.agregarComision(comision2);
		
		assertFalse(comisionAgregada);
	}
	
	@Test
	public void queSePuedaAgregarUnProfesor() {
		String nombreProfe = "Martin", apellidoProfe = "Zaccardo";
		Integer dni = 123;
		Profesor profe = new Profesor(nombreProfe, apellidoProfe, dni);
		Universidad unlam = new Universidad();
		
		Boolean profeAgregado = unlam.agregarProfesor(profe);
		
		assertTrue(profeAgregado);
	}
	
	@Test
	public void queNoSePuedanAgregarDosProfesoresConElMismoDni() {
		Universidad unlam = new Universidad();
		String nombreProfe = "Martin", apellidoProfe = "Zaccardo";
		Integer dni = 123;
		Profesor profe = new Profesor(nombreProfe, apellidoProfe, dni);
		
		unlam.agregarProfesor(profe);
		
		String nombreProfe2 = "Rodrigo", apellidoProfe2 = "Flores";
		Profesor profe2 = new Profesor (nombreProfe2, apellidoProfe2, dni);
		
		Boolean profeAgregado = unlam.agregarProfesor(profe2);
		
		assertFalse(profeAgregado);
		
	}
	
	@Test
	public void queSePuedaAsignarProfesoresAUnaComision() {
		Universidad unlam = new Universidad();
		
		Integer id = 123;
		CicloLectivo actual = new CicloLectivo(56, LocalDate.parse("2023-03-01"), LocalDate.parse("2023-07-01"), LocalDate.parse("2023-02-01"));
		Materia materia = new Materia("PB2", 456); 
		Turno turno = Turno.MAÑANA;
		Comision comision = new Comision(id, actual, materia, turno);
		
		unlam.agregarComision(comision);
		
		String nombreProfe = "Martin", apellidoProfe = "Zaccardo";
		Integer dni = 133;
		Profesor profe = new Profesor(nombreProfe, apellidoProfe, dni);
		
		unlam.agregarProfesor(profe);
		
		Boolean profeAsignadoAComision = comision.asignarProfesor(profe);
		
		assertTrue(profeAsignadoAComision);
	}
	
    @Test
    public void queSePuedaAgregarUnaCorrelativaAUnaMateria() {
        Universidad unlam = new Universidad();
        
        String nombreCorrelativa = "PB2";
        Integer idCorrelativa = 234;
        Materia pb1 = new Materia (nombreCorrelativa, idCorrelativa);
        
        unlam.agregarMateria(pb1);
        
        String nombreMateria = "PB1";
        Integer id = 123;
        Materia pb2 = new Materia (nombreMateria, id);
        
        unlam.agregarMateria(pb2);
        
        Boolean correlativaAgregada = unlam.agregarCorrelativa(id, idCorrelativa);
        
        assertTrue(correlativaAgregada);
       
    }
    
    @Test
    public void queSePuedaEliminarUnaCorrelativa() {
        Universidad unlam = new Universidad();
        
        String nombreCorrelativa = "PB2";
        Integer idCorrelativa = 234;
        Materia pb1 = new Materia (nombreCorrelativa, idCorrelativa);
        
        unlam.agregarMateria(pb1);
        
        String nombreMateria = "PB1";
        Integer id = 123;
        Materia pb2 = new Materia (nombreMateria, id);
        
        unlam.agregarMateria(pb2);
        
        unlam.agregarCorrelativa(id, idCorrelativa);
        Boolean correlativaEliminada = unlam.eliminarCorrelativa(id, idCorrelativa);
        
        assertTrue(correlativaEliminada);
       
    }
    
    @Test
    public void queSePuedaInscribirAUnAlumnoAUnaComision() {
    	Universidad unlam = new Universidad();
    	
    	String nombreAlumno = "Martin", apellidoAlumno = "Zaccardo";
		Integer dni = 123;
		Alumno alumno = new Alumno(nombreAlumno, apellidoAlumno, dni);
		
		unlam.agregarAlumno(alumno);
		
		Integer id = 123;
		CicloLectivo actual = new CicloLectivo(56, LocalDate.parse("2023-03-01"), LocalDate.parse("2023-07-01"), LocalDate.parse("2023-02-01"));
		Materia materia = new Materia("PB2", 456); 
		Turno turno = Turno.MAÑANA;
		Comision comision = new Comision(id, actual, materia, turno);
		
		unlam.agregarComision(comision);
		
		Boolean alumnoInscriptoAComision = unlam.inscribirAlumnoAComision(dni, id);
		
		assertTrue(alumnoInscriptoAComision);
    }
    
    @Test
    public void queNoSePuedaInscribirAUnAlumnoAUnaMateriaSiNoTieneCorrelativasAprobadas() {
    	Universidad unlam = new Universidad ();
    	
    	String nombreMateria = "PB1";
        Integer codigo = 1;
        Materia pb1 = new Materia (nombreMateria, codigo);
        
        unlam.agregarMateria(pb1);
        
        String nombreMateria2 = "PB2";
        Integer codigo2 = 2;
        ArrayList<Materia> correlativas = new ArrayList<>();
        correlativas.add(pb1);
        Materia pb2 = new Materia (nombreMateria2, codigo2);
        
        pb2.asignarCorrelativa(pb1);
        unlam.agregarMateria(pb2);
        
        String nombreAlumno = "Martin";
    	String apellidoAlumno = "Zaccardo";
    	Integer dni= 12345; 
        Alumno alumno = new Alumno (nombreAlumno,apellidoAlumno, dni);
     
    	unlam.agregarAlumno(alumno);
    	
    	unlam.inscribirAlumnoAUnaMateria(dni,1);
   
    	assertFalse(unlam.inscribirAlumnoAUnaMateria(dni,2)) ;
       
    }
    
    @Test
    public void queSePuedaAsignarAUnProfesorAUnaComision() {
    	Universidad unlam = new Universidad();
    	
    	String nombreProfe = "Martin", apellidoProfe = "Zaccardo";
		Integer dni = 123;
		Profesor profe = new Profesor(nombreProfe, apellidoProfe, dni);
		
		unlam.agregarProfesor(profe);
		
		Integer id = 123;
		CicloLectivo actual = new CicloLectivo(56, LocalDate.parse("2023-03-01"), LocalDate.parse("2023-07-01"), LocalDate.parse("2023-02-01"));
		Materia materia = new Materia("PB2", 456); 
		Turno turno = Turno.MAÑANA;
		Comision comision = new Comision(id, actual, materia, turno);
		
		unlam.agregarComision(comision);
		
		Boolean profesorAsignadoAComision = unlam.asignarProfesorAComision(dni, id);
		
		assertTrue(profesorAsignadoAComision);
    }
    
    @Test
    public void queSePuedaAsignarUnAulaAUnaComision() {
        Universidad unlam = new Universidad();
        
        Integer id = 123;
		CicloLectivo actual = new CicloLectivo(56, LocalDate.parse("2023-03-01"), LocalDate.parse("2023-07-01"), LocalDate.parse("2023-02-01"));
		Materia materia = new Materia("PB2", 456); 
		Turno turno = Turno.MAÑANA;
		Comision comision = new Comision(id, actual, materia, turno);
		
		unlam.agregarComision(comision);
		
		Integer idAula = 789, capMax = 100;
		Aula aula = new Aula(idAula, capMax);
		
		Boolean aulaAsignada = comision.asignarAula(aula);
		
		assertTrue(aulaAsignada);
		
    }
    
    @Test
    public void queNoSePuedaAsignarUnAulaAUnaComisionPorqueYaExiste() {
        Universidad unlam = new Universidad();
        
        Integer id = 123;
		CicloLectivo actual = new CicloLectivo(56, LocalDate.parse("2023-03-01"), LocalDate.parse("2023-07-01"), LocalDate.parse("2023-02-01"));
		Materia materia = new Materia("PB2", 456); 
		Turno turno = Turno.MAÑANA;
		Comision comision = new Comision(id, actual, materia, turno);
		
		unlam.agregarComision(comision);
		
		Integer idAula = 789, capMax = 100;
		Aula aula = new Aula(idAula, capMax);
		
		comision.asignarAula(aula);
		
		Boolean aulaAsignada = comision.asignarAula(aula);
		
		assertFalse(aulaAsignada);
		
    }
    
    @Test
    public void queSePuedaRegistrarUnaNota() {
        Universidad unlam = new Universidad();
        
        String nombreAlumno = "Martin", apellidoAlumno = "Zaccardo";
        Integer dni = 123;
        Alumno alumno = new Alumno(nombreAlumno, apellidoAlumno, dni);
        
        unlam.agregarAlumno(alumno);
        
        Integer id = 123;
        CicloLectivo actual = new CicloLectivo(56, LocalDate.parse("2023-03-01"), LocalDate.parse("2023-07-01"), LocalDate.parse("2023-02-01"));
        Materia materia = new Materia("PB2", 456); 
        Turno turno = Turno.MAÑANA;
        Comision comision = new Comision(id, actual, materia, turno);
        
        unlam.agregarComision(comision);

        unlam.inscribirAlumnoAComision(dni, id);
        
        Double nota = 10.0;
        
        Boolean notaRegistrada = unlam.registrarNota(id, dni, nota);
        
        assertTrue(notaRegistrada);
    }

    
    @Test
    public void queSePuedaObtenerUnaNota() {

        Universidad unlam = new Universidad();

        String nombreAlumno = "Martin", apellidoAlumno = "Zaccardo";
        Integer dni = 123;
        Alumno alumno = new Alumno(nombreAlumno, apellidoAlumno, dni);
        unlam.agregarAlumno(alumno);

        Integer id = 123;
        CicloLectivo actual = new CicloLectivo(56, LocalDate.parse("2023-03-01"), LocalDate.parse("2023-07-01"), LocalDate.parse("2023-02-01"));
        Materia materia = new Materia("PB2", 456); 
        Turno turno = Turno.MAÑANA;
        Comision comision = new Comision(id, actual, materia, turno);
        unlam.agregarComision(comision);

        unlam.inscribirAlumnoAComision(dni, id);

        Double notaEsperada = 10.0;
        Boolean notaRegistrada = unlam.registrarNota(id, dni, notaEsperada);
        
        assertTrue(notaRegistrada);

        Double notaObtenida = comision.obtenerNota(alumno);

        assertEquals(notaEsperada, notaObtenida);
    }

    
    @Test
    public void queSePuedanObtenerLasMateriasFaltantesParaUnAlumno() {
        Universidad unlam = new Universidad();
        
        Integer dni = 123;
        Alumno alumno = new Alumno("Martin", "Zaccardo", dni);
        unlam.agregarAlumno(alumno);

        Materia pb1 = new Materia("PB1", 456);
        unlam.agregarMateria(pb1);

        ArrayList<Materia> materiasFaltantes = unlam.obtenerMateriasFaltantesParaUnAlumno(dni);

        assertTrue(materiasFaltantes.contains(pb1));
    }

    @Test
    public void queSePuedaCalcularElPromedioDeUnAlumno() {

    	Universidad unlam = new Universidad();

        Integer dni = 123;
        Alumno alumno = new Alumno("Martin", "Zaccardo", dni);
        unlam.agregarAlumno(alumno);

        Materia pb1 = new Materia("PB1", 456);
        unlam.agregarMateria(pb1);

        CicloLectivo actual = new CicloLectivo(56, LocalDate.parse("2023-03-01"), LocalDate.parse("2023-07-01"), LocalDate.parse("2023-02-01"));
        unlam.agregarCicloLectivo(actual);

        Comision comision = new Comision(123, actual, pb1, Turno.MAÑANA);
        unlam.agregarComision(comision);

        unlam.inscribirAlumnoAComision(dni, 123);

        Double notaEsperada = 10.0;
        unlam.registrarNota(123, dni, notaEsperada);

        Double promedio = unlam.calcularPromedio(dni);

        assertEquals(notaEsperada, promedio, 0.01);
    }


    @Test
    public void queSePuedaObtenerLosExamenesDeUnaComision() {

        Universidad unlam = new Universidad();

        Integer id = 123;
        CicloLectivo actual = new CicloLectivo(56, LocalDate.parse("2023-03-01"), LocalDate.parse("2023-07-01"), LocalDate.parse("2023-02-01"));
        Materia materia = new Materia("PB2", 456); 
        Turno turno = Turno.MAÑANA;
        Comision comision = new Comision(id, actual, materia, turno);
        unlam.agregarComision(comision);
        
        Alumno alumno = new Alumno("Martin", "Zaccardo", 123);
        Examen examen1 = new Examen(alumno, 10.0);
        Examen examen2 = new Examen(alumno, 8.0);
        comision.getExamenes().add(examen1);
        comision.getExamenes().add(examen2);

        ArrayList<Examen> examenes = comision.getExamenes();

        assertTrue(examenes.contains(examen1));
        assertTrue(examenes.contains(examen2));
    }

    @Test
    public void queSePuedaAsignarLosExamenesAUnaComision() {

        Universidad unlam = new Universidad();

        Integer id = 123;
        CicloLectivo actual = new CicloLectivo(56, LocalDate.parse("2023-03-01"), LocalDate.parse("2023-07-01"), LocalDate.parse("2023-02-01"));
        Materia materia = new Materia("PB2", 456); 
        Turno turno = Turno.MAÑANA;
        Comision comision = new Comision(id, actual, materia, turno);
        unlam.agregarComision(comision);
      
        ArrayList<Examen> examenes = new ArrayList<>();
        
        Alumno alumno = new Alumno("Martin", "Zaccardo", 123);
        Examen examen1 = new Examen(alumno, 10.0);
        Examen examen2 = new Examen(alumno, 8.0);
        
        examenes.add(examen1);
        examenes.add(examen2);

        comision.setExamenes(examenes);

        assertEquals(comision.getExamenes(), examenes);
    }

    @Test
    public void queSePuedaObtenerLaNotaDeUnAlumnoEnUnaComision() {

        Universidad unlam = new Universidad();

        String nombreAlumno = "Martin", apellidoAlumno = "Zaccardo";
        Integer dni = 123;
        Alumno alumno = new Alumno(nombreAlumno, apellidoAlumno, dni);
        unlam.agregarAlumno(alumno);

        Integer id = 123;
        CicloLectivo actual = new CicloLectivo(56, LocalDate.parse("2023-03-01"), LocalDate.parse("2023-07-01"), LocalDate.parse("2023-02-01"));
        Materia materia = new Materia("PB2", 456); 
        Turno turno = Turno.MAÑANA;
        Comision comision = new Comision(id, actual, materia, turno);
        unlam.agregarComision(comision);

        unlam.inscribirAlumnoAComision(dni, id);

        Double notaEsperada = 10.0;
        unlam.registrarNota(id, dni, notaEsperada);

        Double notaObtenida = comision.obtenerNota(alumno);

        assertEquals(notaEsperada, notaObtenida);
    }

    @Test
    public void queSePuedaVerificarSiUnAlumnoAproboUnaComision() {
      
        Universidad unlam = new Universidad();

        String nombreAlumno = "Martin", apellidoAlumno = "Zaccardo";
        Integer dni = 123;
        Alumno alumno = new Alumno(nombreAlumno, apellidoAlumno, dni);
        unlam.agregarAlumno(alumno);
       
        Integer id = 123;
        CicloLectivo actual = new CicloLectivo(56, LocalDate.parse("2023-03-01"), LocalDate.parse("2023-07-01"), LocalDate.parse("2023-02-01"));
        Materia materia = new Materia("PB2", 456); 
        Turno turno = Turno.MAÑANA;
        Comision comision = new Comision(id, actual, materia, turno);
        unlam.agregarComision(comision);
     
        unlam.inscribirAlumnoAComision(dni, id);
        
        Double notaEsperada = 4.0;
        unlam.registrarNota(id, dni, notaEsperada);
        
        Boolean alumnoAprobo = comision.alumnoAprobo(alumno);

       assertTrue(alumnoAprobo);
    }

}

