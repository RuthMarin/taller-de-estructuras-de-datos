public class Arbol {
    private NodoArbol raiz;

    public Arbol() {
        raiz = null;
    }

    // Escribe las claves del árbol binario de raiz a en preorden.
    private void preOrden(NodoArbol nodo) {
        if (nodo != null) {
            System.out.print (nodo.getClave() + " "); // Nodo
            nodo.getDato().mostrarAlumno();
            preOrden(nodo.getIz()); // Izquierda
            preOrden(nodo.getDe()); // Derecha
        }
    }
    public void preOrden() {
        System.out.println("Recorrido preOrden:");
        preOrden(raiz);
        System.out.println("");
    }

    // Escribe las claves del árbol binario de raiz a en postorden.
    private void postOrden(NodoArbol nodo) {
        if (nodo != null) {
            postOrden(nodo.getIz()); // Izquierda
            postOrden(nodo.getDe()); // Derecha
            System.out.print(nodo.getClave() + " "); // Nodo
            nodo.getDato().mostrarAlumno();
        }
    }
    public void postOrden() {
        System.out.println("Recorrido postOrden:");
        postOrden(raiz);
        System.out.println("");
    }

    // Escribe las claves del árbol binario de raiz a en orden central.
    private void ordenCentral(NodoArbol nodo) {
        if (nodo != null) {
            ordenCentral(nodo.getIz()); // Izquierda
            System.out.print(nodo.getClave() + " "); // Nodo
            nodo.getDato().mostrarAlumno();
            ordenCentral(nodo.getDe()); // Derecha
        }
    }
    public void ordenCentral() {
        System.out.println("Recorrido ordenCentral:");
        ordenCentral(raiz);
        System.out.println("");
    }

    public void listarAmplitud() {
        NodoArbol p = raiz;
        Cola c = new Cola();
        if (p != null)
            c.encolar(p);
        while (!c.colaVacia()) {
            p = c.desencolar();
            System.out.print(p.getClave() + " ");
            if (p.getIz() != null)
                c.encolar(p.getIz());
            if (p.getDe() != null)
                c.encolar(p.getDe());
        }
    }
 
    public NodoArbol getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol nodo) {
        raiz = nodo;
    }

    private NodoArbol insertar(NodoArbol nodo, int clave, Alumno dato) {
        if (nodo != null)
            if (nodo.getClave() < clave)
                nodo.setDe(insertar(nodo.getDe(), clave, dato));
            else if (nodo.getClave() > clave)
                nodo.setIz(insertar(nodo.getIz(), clave, dato));
            else
                System.out.println("la clave ya existe");
        else nodo = new NodoArbol(clave, dato);
        return nodo;
    }

    public void insertar(int clave, Alumno dato) {
        raiz = insertar(raiz, clave, dato);
    }

    private void calificacionMedia(NodoArbol nodo, Cola cola){

        if (nodo != null){
            calificacionMedia(nodo.getIz(),cola); // Izquierda
            calificacionMedia(nodo.getDe(),cola); // Derecha
            cola.encolar(nodo);
        }
    }

    public float calificacionMedia() {
        Cola aux = new Cola();// cola;
        calificacionMedia(raiz, aux);
        float sumaArti = 0;
        int numOb = 0;
        while(!aux.colaVacia()){
            sumaArti  += aux.desencolar().getDato().getCalificacion();
            numOb ++;
        }

        return sumaArti / numOb;
    }

    private Alumno maxCaliAux(NodoArbol nodo){
        Alumno actual, aux;
        if (nodo == null){
            return null;
        }
        else{
            actual = maxCaliAux(nodo.getIz());
            if ( actual == null || nodo.getDato().getCalificacion() > actual.getCalificacion()){
                actual = nodo.getDato();
            }
            aux = maxCaliAux(nodo.getDe());
            if (aux != null && nodo.getDato().getCalificacion() < aux.getCalificacion()){
                actual = aux;
            }
            return actual;
        }
    }

    public void maxCali(){
        Alumno alumno = maxCaliAux(this.raiz);
        if(alumno != null){
            System.out.print("\nLa mejor calificacion es de: ");
            alumno.mostrarAlumno();
            System.out.println("");
        }
        else{
            System.out.print("\nNo hay ninguna maxima calificacion");
        }
    }

}