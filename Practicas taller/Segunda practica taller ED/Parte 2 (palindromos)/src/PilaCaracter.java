public class PilaCaracter {

    private NodoCaracter cimaPila;
    private int numElementos;

    public PilaCaracter() {
        cimaPila = null;
        numElementos = 0;
    }

    public boolean pilaVacia() {

        return cimaPila == null;
    }

    public void apilar(char dato) {
        if (this.pilaVacia())
            cimaPila = new NodoCaracter(dato, null);
        else {
            NodoCaracter nuevo = new NodoCaracter(dato, cimaPila);
            cimaPila = nuevo;
        }
        numElementos++;
    }

    public char desapilar() {
        char valor;
        if (this.pilaVacia()) {
            System.out.println("Error, la pila está vacía");
            valor = ' ';
        } else {
            valor = cimaPila.getDato();
            cimaPila = cimaPila.getSiguiente();
            numElementos--;
        }
        return valor;
    }

    public char cima() {
        char valor;
        if (this.pilaVacia()) {
            System.out.println("Error, la pila está vacía");
            valor = ' ';
        } else {
            valor = cimaPila.getDato();
        }
        return valor;
    }

    public int numElemPila() {
        return numElementos;
    }

    public void escribirPila() {
        NodoCaracter aux = cimaPila;
        System.out.println("\ncontenido de la pila");

        while (aux != null) {
            System.out.println(aux.getDato());
            aux = aux.getSiguiente();
        }
    }

    public boolean comprobarOrden(){
        NodoCaracter aux = this.cimaPila;
        NodoCaracter siguiente = aux.getSiguiente(); //Con esto estamos suponiendo que la pila no esta vacia y que tiene al menos dos elementos
        boolean flag = true;
        while(siguiente != null && flag){
            if(aux.getDato() > siguiente.getDato()) {
                flag = false;
            }
            aux = aux.getSiguiente();
            siguiente = aux.getSiguiente();
        }
        return flag;
    }

    public int sumaElementos(){

        if(this.pilaVacia()){
            System.out.println("\nNo se puede hacer la suma, la lista esta vacia");
            return 0;
        }
         else {
            NodoCaracter aux = this.cimaPila;
            int suma = 0;
            while (aux != null) {
                suma += aux.getDato();
                aux = aux.getSiguiente();
            }
            return suma;
        }
    }

    public  void unirPila(PilaCaracter p){

        char[] elementos = new char[p.numElemPila()];
        int numElem = p.numElemPila();
        for(int i = 0; i < numElem; i++){
            elementos[i] = p.desapilar();
        }
        for(int i = numElem-1; i >= 0 ; i--){
            this.apilar(elementos[i]);
        }
    }
}