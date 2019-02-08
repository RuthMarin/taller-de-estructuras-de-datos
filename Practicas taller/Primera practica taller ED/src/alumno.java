public class alumno {

    final int MAX = 5;

    private String nombre, apellido, matricula;
    private double Calificacion;
    private String Asignaturas[];
    private int NumAsig;

    public alumno(){
        nombre = "";
        apellido = "";
        matricula = "";
        Calificacion = 0;
        NumAsig = 0;
        Asignaturas = new String[MAX];
    }
    public alumno(String nomb, String apell, String matric, double calific){
        nombre = nomb;
        apellido = apell;
        matricula = matric;
        Calificacion = calific;
        NumAsig = 0;
        Asignaturas = new String[MAX];
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCalificacion(double calificacion) {
        this.Calificacion = calificacion;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre(){
        return nombre;
    }

    public String getApellido(){
        return  apellido;
    }

    public String getMatricula(){
        return  matricula;
    }

    public double getCalificacion(){
        return Calificacion;
    }

    public int getNumAsig(){
        return NumAsig;
    }

    public void anadirAsignatura(String asig){
        if(NumAsig <5){
            Asignaturas[NumAsig] = asig;
            NumAsig ++;
        }
        else{
            System.out.print("No se puede añadir la asignatura, la lista esta llena");
        }
    }

    public void mostrarAsignaturas(){
        if(NumAsig == 0){
            System.out.println("El alumno no esta matriculado en ninguna asignatura");
        }
        else {
            System.out.println("El alumno esta matriculado en las siguientes asignaturas:");
            for (int i = 0; i < NumAsig; i++){
                System.out.println("-" + Asignaturas[i]);
            }
        }
        System.out.println("");
    }

    public void mostrarAlumno() {
        System.out.println(apellido + ", " + nombre);
        System.out.println("Matricula: "+ matricula);
        System.out.println("Nota: "+ Calificacion);
        mostrarAsignaturas();
        System.out.println("");

    }
}
