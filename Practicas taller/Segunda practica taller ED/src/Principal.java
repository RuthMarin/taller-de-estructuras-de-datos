public class Principal {
    public static int  sumarElementos (Pila p){

        if(p.pilaVacia())
            return 0;
        else{
            Pila aux=p;
            return aux.sumaElementos();
        }
    }
    private static void unirPilas (Pila p1, Pila p2){

    }

    public static void dejarN(int n, Cola cola){
        if(n < cola.numElemCola() && n!=0){
           Cola aux = new Cola();
           for(int i = 0; i < n; i++){
               aux.encolar(cola.desencolar());
           }
           cola = aux;
        }
    }

    public static void main(String[] args) {
        /*Pila p1 = new Pila();
        Pila p2 = new Pila();

        //pruebas sumar pila y pila ordenada
        p1.apilar(8);
        p1.apilar(1);
        p1.apilar(4);
        p1.apilar(2);
        p1.escribirPila();

        System.out.println("\nLa suma de los elementos de la pila es --> "+ p1.sumaElementos());

        if(p1.comprobarOrden())
            System.out.println("\nTrue, la lista esta ordenada");
        else
            System.out.println("\nFalse, la lista esta desordenada");

        for(int i = 0; i<3 ;i++) //Asi nos quedamos solo con el 8 dentro de la pila
            p1.desapilar();
        p1.escribirPila();
        System.out.println("\nLa suma de los elementos de la pila es --> "+ p1.sumaElementos());
        p1.desapilar();
        p1.sumaElementos();

        //Pruebas unir pila

        Pila p11= new Pila();
        Pila p22= new Pila();

        p11.apilar(2);
        p11.apilar(4);
        p11.apilar(8);

        p22.apilar(40);
        p22.apilar(30);
        p22.apilar(20);
        p22.apilar(10);

        p11.escribirPila();
        p22.escribirPila();

        //caso 1
        p11.unirPila(p22);
        p11.escribirPila();
        p22.escribirPila();

        //Caso 2
        for(int i = 0; i<4 ;i++) //Asi nos quedamos con la lista 1 original para usarla en el segundo ejemplo
            p11.desapilar();
        p11.escribirPila();
        p22.apilar(40);
        p22.escribirPila();
        p11.unirPila(p22);
        p11.escribirPila();

        //Caso 3

        p11.desapilar();
        p11.escribirPila();
        p11.unirPila(p22);
        p11.escribirPila();

        //Pruebas con la funcion sumarElementos(pila)

        Pila p33 = new Pila();

        p33.apilar(8);
        p33.apilar(1);
        p33.apilar(4);
        p33.apilar(2);
        System.out.println("\nLa suma de la pila es: "+sumarElementos(p33));

        for (int i = 0; i<3; i++)
            p33.desapilar();
        System.out.println("\nLa suma de la pila es: "+sumarElementos(p33));

        p33.desapilar();
        System.out.println("\nLa suma de la pila es: "+sumarElementos(p33));*/

        //Pruebas con colas dejar N elementos
        Cola p44 = new Cola();

        p44.encolar(20);
        p44.encolar(40);
        p44.encolar(10);
        p44.encolar(50);
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
<<<<<<< HEAD

        //Prueba con funcion Dejar n elementos (funcion fuera main)
        Cola p55 = new Cola();

        p55.encolar(20);
        p55.encolar(40);
        p55.encolar(10);
        p55.encolar(50);
        dejarN(2,p55);
        p55.escribirCola();
=======
>>>>>>> 770a4592894124b05411f13d6d72f163f9e159f2
    }
}
