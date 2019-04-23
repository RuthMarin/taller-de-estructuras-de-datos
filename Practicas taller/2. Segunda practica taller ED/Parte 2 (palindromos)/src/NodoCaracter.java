public class NodoCaracter {

    private char dato;
    private NodoCaracter siguiente;

    public NodoCaracter(char dato, NodoCaracter sig) {
        this.dato = dato;
        this.siguiente = sig;
    }

    public NodoCaracter getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCaracter siguiente) {
        this.siguiente = siguiente;
    }

    public char getDato() {
        return dato;
    }

    public void setDato(char dato) {
        this.dato = dato;
    }
}
