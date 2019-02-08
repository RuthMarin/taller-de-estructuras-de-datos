public class Principal {
    public static void main(String[] args){
        alumno A1= new alumno("Felipe","Arias Gonzalez","aa1253", 3.5);
        alumno A2= new alumno("Manule", "Garcia Sacedon", "ax0074", 8.50);
        alumno A3= new alumno("Margarita", "Lopez Medina", "mj7726", 7.70);
        alumno A4 = new alumno("Estela", "Sanchez Arellan", "bc2658", 6.75);

        A4.anadirAsignatura("Analisis Matematico");
        A4.anadirAsignatura("Estructura de Datos");
        //A4.mostrarAsignaturas();

       // A1.mostrarAlumno();
       // A4.mostrarAlumno();

        GrupoAlumnos grupo1 = new GrupoAlumnos(20, "g1");
        grupo1.insertarAlumno(A1);
        grupo1.insertarAlumno(A2);
        grupo1.insertarAlumno(A3);
        grupo1.insertarAlumno(A4);
        alumno Yo = new alumno("Marcos", "Martinez Francisco", "bp0428", 9.8);
        Yo.anadirAsignatura("Estructura de datos");
        Yo.anadirAsignatura("Taller de programacion");
        grupo1.insertarAlumno(Yo);
        grupo1.mostrarGrupo();
    }
}
