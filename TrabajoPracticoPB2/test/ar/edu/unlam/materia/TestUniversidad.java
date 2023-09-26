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

        // Aquí inscribes al alumno en la comisión
        unlam.inscribirAlumnoAComision(dni, id);
        
        Examen examen = new Examen(alumno, 10.0);
        
        Boolean notaRegistrada = unlam.registrarNota(id, dni, examen.getNota());
        
        assertTrue(notaRegistrada);
    }

    
    @Test
    public void queSePuedanObtenerLasMateriasFaltantesParaUnAlumno() {
        Universidad unlam = new Universidad();
        
        // Aquí deberías agregar algunas materias, alumnos y comisiones a la universidad
        Integer dni = 123;
        Alumno alumno = new Alumno("Martin", "Zaccardo", dni);
        unlam.agregarAlumno(alumno);

        Materia pb1 = new Materia("PB1", 456);
        unlam.agregarMateria(pb1);

        // Aquí deberías inscribir al alumno en algunas comisiones y registrar algunas notas para el alumno

        ArrayList<Materia> materiasFaltantes = unlam.obtenerMateriasFaltantesParaUnAlumno(dni);

        // Aquí deberías verificar que la lista de materias faltantes es correcta
        assertTrue(materiasFaltantes.contains(pb1));
    }

    @Test
    public void queSePuedaCalcularElPromedioDeUnAlumno() {
        Universidad unlam = new Universidad();
        
        // Aquí deberías agregar algunas materias, alumnos y comisiones a la universidad
        Integer dni = 123;
        Alumno alumno = new Alumno("Martin", "Zaccardo", dni);
        unlam.agregarAlumno(alumno);

        Materia pb1 = new Materia("PB1", 456);
        unlam.agregarMateria(pb1);

        // Creas una instancia de CicloLectivo y la asignas a la variable actual
        CicloLectivo actual = new CicloLectivo(56, LocalDate.parse("2023-03-01"), LocalDate.parse("2023-07-01"), LocalDate.parse("2023-02-01"));
        unlam.agregarCicloLectivo(actual);

        Comision comision = new Comision(123, actual, pb1, Turno.MAÑANA);
        unlam.agregarComision(comision);

        // También deberías registrar algunas notas para el alumno
        Examen examen = new Examen(alumno, 10.0);
        comision.getExamenes().add(examen);

        Double promedio = unlam.calcularPromedio(dni);

        // Aquí deberías verificar que el promedio calculado es correcto
        assertEquals(10.0, promedio, 0.01);
    }

    @Test
    public void queSePuedaObtenerLosExamenesDeUnaComision() {
        // Aquí deberías agregar una comisión a la universidad y registrar algunos exámenes en esa comisión

        ArrayList<Examen> examenes = Comision.getExamenes();

        // Aquí deberías verificar que la lista de exámenes obtenida es correcta
    }

    @Test
    public void queSePuedaAsignarLosExamenesAUnaComision() {
        // Aquí deberías agregar una comisión a la universidad

        ArrayList<Examen> examenes = new ArrayList<>(); // Creas una lista de exámenes

        Comision.setExamenes(examenes); // Asignas la lista de exámenes a la comisión

        // Aquí deberías verificar que la lista de exámenes de la comisión es la que acabas de asignar
    }

    @Test
    public void queSePuedaObtenerLaNotaDeUnAlumnoEnUnaComision() {
        // Aquí deberías agregar una comisión a la universidad, inscribir a un alumno en esa comisión y registrar una nota para ese alumno
    	String nombreAlumno = "Martin", apellidoAlumno = "Zaccardo";
		Integer dni = 123;
		Alumno alumno = new Alumno(nombreAlumno, apellidoAlumno, dni);
		Universidad unlam = new Universidad();
		
		Boolean alumnoAgregado = unlam.agregarAlumno(alumno);

        Double nota = Comision.obtenerNota(alumno);

        // Aquí deberías verificar que la nota obtenida es correcta
    }

    @Test
    public void queSePuedaVerificarSiUnAlumnoAproboUnaComision() {
        // Aquí deberías agregar una comisión a la universidad, inscribir a un alumno en esa comisión y registrar una nota para ese alumno

        Boolean alumnoAprobo = Comision.alumnoAprobo(alumno);

        // Aquí deberías verificar si el alumno aprobó o no
    }

}

