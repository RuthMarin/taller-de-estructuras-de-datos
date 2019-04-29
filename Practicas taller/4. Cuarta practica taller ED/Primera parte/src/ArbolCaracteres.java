import javax.print.DocFlavor;
import java.util.*;

public class ArbolCaracteres {
    private NodoArbol raiz;

    public ArbolCaracteres() {
        raiz = null;
    }

    public ArbolCaracteres(char clave) {
        raiz = new NodoArbol(clave);
    }

    // Escribe las claves del árbol binario de raiz a en preorden.
    private void preOrden(NodoArbol nodo) {
        if (nodo != null) {
            System.out.print (nodo.getClave() + " "); // Nodo
            preOrden(nodo.getIz()); // Izquierda
            preOrden(nodo.getDe()); // Derecha
        }
    }
    public void preOrden() {
        System.out.print ("Preorden: ");
        preOrden(raiz);
        System.out.println();
    }

    // Escribe las claves del árbol binario de raiz a en postorden.
    private void postOrden(NodoArbol nodo) {
        if (nodo != null) {
            postOrden(nodo.getIz()); // Izquierda
            postOrden(nodo.getDe()); // Derecha
            System.out.print(nodo.getClave() + " "); // Nodo
        }
    }
    public void postOrden() {
        System.out.print ("Post orden: ");
        postOrden(raiz);
        System.out.println();
    }

    // Escribe las claves del árbol binario de raiz a en orden central.
    private void ordenCentral(NodoArbol nodo) {
        if (nodo != null) {
            ordenCentral(nodo.getIz()); // Izquierda
            System.out.print(nodo.getClave() + " "); // Nodo
            ordenCentral(nodo.getDe()); // Derecha
        }
    }
    public void ordenCentral() {
        System.out.print ("Orden central: ");
        ordenCentral(raiz);
        System.out.println();
    }

     public NodoArbol getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol nodo) {
        raiz = nodo;
    }

    public void juntar(char clave, ArbolCaracteres a1, ArbolCaracteres a2) {
        if (a1.raiz == a2.raiz && a1.raiz != null)
            System.out.println("no se pueden mezclar, a1 y a2 son iguales");
        else {
            // Crear el nodo nuevo
            raiz = new NodoArbol(clave, a1.raiz, a2.raiz);
            // Borrar los árboles a1 y a2
            if (this != a1)
                a1.raiz = null;
            if (this != a2)
                a2.raiz = null;
        }
    }

    private StringBuilder postordenStringAux(NodoArbol nodo, StringBuilder cadena){

        if (nodo != null) {
            postordenStringAux(nodo.getIz(), cadena); // Izquierda
            postordenStringAux(nodo.getDe(), cadena); // Derecha
            cadena.append(nodo.getClave()); // Nodo
        }
        return cadena;
    }

    public StringBuilder postOrdenString(){
        StringBuilder str = new StringBuilder();
        return postordenStringAux(raiz, str);
    }

    //Otra forma de hacer el metodo PostOrdenString (me gusta mas la forma con el stringbuilder)
    /*
    public String postOrdenes(){
        String s = "";
        s += postOrdenes(raiz);
        return s;
    }
    private String postOrdenes(NodoArbol nodo){
        String s ="";
        if(nodo.getIz()!=null){
            s += postOrdenes(nodo.getIz());
        }
        if (nodo.getDe()!=null){
            s += postOrdenes(nodo.getDe());
        }
        s += nodo.getClave();
        return s;
    }
     */

    private float calcularValor (NodoArbol nodo){
        MetodosAE operacion = new MetodosAE();
        float resultado = 0;
        if(operacion.esDigito(nodo.getClave()))
            return operacion.pasarAEntero(nodo.getClave());
        if(operacion.esOperador(nodo.getClave())){
            switch (nodo.getClave()){
                case '+':
                    resultado = (calcularValor(nodo.getIz()) + calcularValor( nodo.getDe()));
                    break;
                case'-':
                    resultado = (calcularValor(nodo.getIz()) - calcularValor( nodo.getDe()));
                    break;
                case'*':
                    resultado = (calcularValor(nodo.getIz()) * calcularValor(nodo.getDe()));
                    break;
                case '/':
                    resultado = (calcularValor(nodo.getIz()) / calcularValor(nodo.getDe()));
                    break;
                default: break;
            }
        }

        return resultado;
    }

    public float calcularValor(){ return calcularValor(raiz); }
}
