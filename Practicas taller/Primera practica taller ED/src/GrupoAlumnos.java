public class GrupoAlumnos {

    private  alumno[] ListaAlumnos;
    private  String nombre;
    private int Maximo, NumAlumnos;

    public GrupoAlumnos(){
        nombre = "GrupoDesconocido";
        Maximo = 10;
        NumAlumnos = 0;
        ListaAlumnos = new alumno[Maximo];
    }

    public  GrupoAlumnos(int max, String nom){
        nombre = nom;
        Maximo = max;
        NumAlumnos = 0;
        ListaAlumnos = new alumno[Maximo];
    }

    public int getNumAlumnos(){ return NumAlumnos; }

    public int getMaximo(){ return  Maximo; }

    public  String getNombre(){ return nombre; }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public alumno  alumnoPos(int  i){
        if(ListaAlumnos[i] == null)
            return  null;
        else
            return ListaAlumnos[i];
    }

    public  boolean  insertarAlumno(alumno  a){
        if(NumAlumnos < Maximo) {
            ListaAlumnos[NumAlumnos] = a;
            NumAlumnos ++;
            return true;
        }
        else
            return false;
    }

    public void mostrarGrupo(){
        System.out.println(nombre + "\n");
        for(int i=0; i<NumAlumnos;i++) ListaAlumnos[i].mostrarAlumno();
    }
}
