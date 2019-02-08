public class GrupoAlumnos {

    alumno ListaAlumnos[];
    String nombre;
    int Maximo, NumAlumnos;

    public GrupoAlumnos(){
        nombre = "GrupoDesconocido";
        Maximo = 10;
        ListaAlumnos = new alumno[Maximo];
    }

    public  GrupoAlumnos(int max, String nom){
        nombre = nom;
        Maximo = max;
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
        if(ListaAlumnos[Maximo-1] == null) {
            ListaAlumnos[NumAlumnos] = a;
            return true;
        }
        else
            return false;
    }

    public void mostrarGrupo(){
        System.out.println(nombre);
        for(int i=0; i<NumAlumnos;i++) ListaAlumnos[i].mostrarAlumno();
    }
}
