public class Cola {
    private Nodo cabeza, fin;
    private int numElem;

    Cola() {
        cabeza = null;
        fin = null;
        numElem = 0;
    }

    public void encolar(Paciente v) {    // Coloca el elemento v al final de la cola
        Nodo nuevo;
        nuevo = new Nodo(v, null);
        if (cabeza != null) {
            fin.setSiguiente(nuevo);
        } else {
            cabeza = nuevo;
        }
        fin = nuevo;
        numElem++;
    }

    public Paciente desencolar() {    //Devuelve el elemento del cabeza de la cola y lo elimina Si la cola está vacía, devuelve como resultado 0 y un mensaje de error
        Nodo nodo;
        Paciente resul = null;
        if (cabeza == null) {
            System.out.println("Error, la cola está vacía");
        } else {
            nodo = cabeza;
            cabeza = nodo.getSiguiente();
            resul = nodo.getDato();
            if (cabeza == null)
                fin = null;
            numElem--;
        }
        return resul;
    }

    public boolean colaVacia() {   // Comprueba si la cola está vacía
        return cabeza == null;
    }



    public Paciente primero() {  //Devuelve el elemento del cabeza de la cola Si la cola está vacía, devuelve como resultado -999 y un mensaje de error
        Paciente resul = null;
        if (!this.colaVacia()) {
            resul = cabeza.getDato();
        } else {
            System.out.println("Error, la cola está vacía");
        }
        return resul;
    }

    public void verCola() {     // Muestra por pantalla el contenido de la cola
        Nodo aux;
        Paciente paciente;
        aux = cabeza;
        System.out.println("\n\t\t\t\t-- Contenido de la cola --");
        while (aux != null) {
            paciente = aux.getDato();
            paciente.verPaciente();
            aux = aux.getSiguiente();
        }
        if(this.colaVacia())
            System.out.print("Cola vacia");
        System.out.println("\n\t\t\t----------------------------------");
    }

    public int numElemCola() {       // Devuelve el número de elementos de la cola
        return numElem;
    }
}


