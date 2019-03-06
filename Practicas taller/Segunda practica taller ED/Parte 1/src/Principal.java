public class Principal {

    public static int  sumarElementos (Pila p){

        if(p.pilaVacia())
            return 0;
        else{
            Pila aux = new Pila();
            int suma = 0;
            while(!p.pilaVacia()){
                suma += p.cima();
                aux.apilar(p.desapilar());
            }
            while(!aux.pilaVacia())
                p.apilar(aux.desapilar());
            return suma;
        }
    }
    private static void unirPilas (Pila p1, Pila p2){
        Pila aux = new Pila();
        while(!p2.pilaVacia()){
            aux.apilar(p2.desapilar());
        }
        while(!aux.pilaVacia()){
            p1.apilar(aux.desapilar());
        }
    }

    private static void dejarN(int n, Cola cola){

       if(n < cola.numElemCola()) {
           int restantes = cola.numElemCola() - n;
           for (int i = 0; i < n; i++) {
               cola.encolar(cola.desencolar());
           }
           for(int i = 0; i < restantes; i++){
               cola.desencolar();
           }
       }
    }

    public static void main(String[] args) {

        //pruebas sumar pila y pila ordenada
        Pila p1 = new Pila();
        System.out.println("\n--Pruebas sumar pila y pila ordenada--");
        //pila con varios elementos
        p1.apilar(8);
        p1.apilar(1);
        p1.apilar(4);
        p1.apilar(2);
        p1.escribirPila();
        System.out.println("\nLa suma de los elementos de la pila es --> "+ p1.sumaElementos());

        //Pila con un unico elemento
        for(int i = 0; i<3 ;i++) //Asi nos quedamos solo con el 8 dentro de la pila
            p1.desapilar();
        p1.escribirPila();
        System.out.println("\nLa suma de los elementos de la pila es --> "+ p1.sumaElementos());

        //Pila vacia
        p1.desapilar();
        p1.escribirPila();
        System.out.println("\nLa suma de los elementos de la pila es --> "+ p1.sumaElementos());

        //Prueba pila ordenada
        p1.apilar(8);
        p1.apilar(1);
        p1.apilar(4);
        p1.apilar(2);
        p1.escribirPila();
        if(p1.comprobarOrden())
            System.out.println("\nTrue, la lista esta ordenada");
        else
            System.out.println("\nFalse, la lista esta desordenada");


        //Pruebas unir pila
        System.out.println("\n--Pruebas unir pilas--");

        Pila p21= new Pila();
        Pila p22= new Pila();

        p21.apilar(2);
        p21.apilar(4);
        p21.apilar(8);

        p22.apilar(40);
        p22.apilar(20);
        p22.apilar(30);
        p22.apilar(10);

        p21.escribirPila();
        p22.escribirPila();

        //caso 1
        p21.unirPila(p22);
        p21.escribirPila();
        p22.escribirPila();

        //Caso 2
        for(int i = 0; i<4 ;i++) //Asi nos quedamos con la lista p21 original para usarla en el segundo ejemplo
            p21.desapilar();
        p21.escribirPila();
        p22.apilar(40);
        p22.escribirPila();
        p21.unirPila(p22);
        p21.escribirPila();

        //Caso 3

        p21.desapilar();
        p21.escribirPila();
        p21.unirPila(p22);
        p21.escribirPila();

        //Pruebas con la funcion sumarElementos(pila)
        System.out.println("\n--Pruebas funcion sumarElementos(pila)--");

        Pila p23 = new Pila();

        p23.apilar(8);
        p23.apilar(1);
        p23.apilar(4);
        p23.apilar(2);
        p23.escribirPila();
        System.out.println("\nLa suma de la pila es: "+sumarElementos(p23));

        for (int i = 0; i < 3; i++) {
            p23.desapilar();
        }

        p23.escribirPila();
        System.out.println("\nLa suma de la pila es: "+sumarElementos(p23));

        p23.desapilar();
        System.out.println("\nLa suma de la pila es: "+sumarElementos(p23));

       //Pruebas con colas dejar N elementos
        System.out.println("\n--Pruebas dejar N elementos--");

        Cola p44 = new Cola();

        p44.encolar(20);
        p44.encolar(40);
        p44.encolar(10);
        p44.encolar(50);
        p44.escribirCola();
        p44.dejarN(2);
        p44.escribirCola();

        p44.encolar(10);
        p44.encolar(50);
        p44.dejarN(4);
        p44.escribirCola();

        p44.dejarN(9);
        p44.escribirCola();

        p44.dejarN(0);
        p44.escribirCola();

        //Prueba con funcion Dejar n elementos (funcion fuera main)
        System.out.println("\n--Pruebas funcion dejarN(dato, cola) --");
        Cola p45 = new Cola();

        p45.encolar(20);
        p45.encolar(40);
        p45.encolar(10);
        p45.encolar(50);
        p45.escribirCola();
        dejarN(2,p45);
        p45.escribirCola();

        p45.encolar(10);
        p45.encolar(50);
        dejarN(4, p45);
        p45.escribirCola();

        dejarN(9, p45);
        p45.escribirCola();

        dejarN(0, p45);
        p45.escribirCola();
    }
}
