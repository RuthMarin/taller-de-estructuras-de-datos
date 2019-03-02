public class ColaCaracter {
    private NodoCaracter cabeza, fin;
    private int numElem;

    ColaCaracter() {
        cabeza = null;
        fin = null;
        numElem = 0;
    }


    public void encolar(char valor) {    // Coloca el elemento v al final de la cola
        NodoCaracter nuevo;
        nuevo = new NodoCaracter(valor, null);
        if (cabeza != null)
            fin.setSiguiente(nuevo);
        else
            cabeza = nuevo;
        fin = nuevo;
        numElem++;
    }

    public char desencolar() {    //Devuelve el elemento del cabeza de la cola y lo elimina. Si la cola está vacía, devuelve como resultado un espacio en blanco y un mensaje de error
        NodoCaracter nodoCaracter;
        char resul = ' ';

        if (cabeza == null)
            System.out.println("Error, la cola está vacía");
        else {
            nodoCaracter = cabeza;
            cabeza = nodoCaracter.getSiguiente();
            resul = nodoCaracter.getDato();
            if (cabeza == null)
                fin = null;

            numElem--;
        }
        return resul;
    }

    public boolean colaVacia() {   // Comprueba si la cola está vacía

        return cabeza == null;
    }


    public char primero() {  //Devuelve el elemento del cabeza de la cola Si la cola está vacía, devuelve como resultado -999 y un mensaje de error

        char resul = ' ';

        if (!this.colaVacia()) {
            resul = cabeza.getDato();
        } else
            System.out.println("Error, la cola está vacía");
        return resul;
    }

    public void escribirCola() {     // Muestra por pantalla el contenido de la cola
        NodoCaracter aux;
        System.out.println("Contenido de la cola: ");
        aux = cabeza;
        while (aux != null) {
            System.out.print(aux.getDato() + "  ");
            aux = aux.getSiguiente();
        }
        System.out.println("");
    }

    public int numElemCola() {       // Devuelve el número de elementos de la cola

        return numElem;
    }

    void  dejarN(int n){
        if(n < this.numElem && n != 0){
            NodoCaracter aux = cabeza;
            for(int i= 1; i < n; i++){
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(null);
            this.fin = aux;
        }
        else if (n == 0)
            this.cabeza = null;
    }
}

