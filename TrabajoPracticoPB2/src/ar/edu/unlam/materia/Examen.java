package ar.edu.unlam.materia;

public class Examen {
    private Alumno alumno;
    private Double nota;

    public Examen(Alumno alumno, Double nota) {
        this.alumno = alumno;
        this.nota = nota;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }
}


