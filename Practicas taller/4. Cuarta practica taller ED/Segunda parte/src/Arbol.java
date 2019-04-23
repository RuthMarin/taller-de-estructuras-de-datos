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
        preOrden(raiz);
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
        postOrden(raiz);
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
        ordenCentral(raiz);
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


    private Alumno maxCalifAux(NodoArbol nodo){
        Alumno alumno = nodo.getDato();
        double maxNota = alumno.getCalificacion();

        
    }

    public void maxCalif(){

    }
}