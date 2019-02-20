public class Principal {
    public static void main(String[] args) {
        Pila p1 = new Pila();
        Pila p2 = new Pila();

       /* //pruebas sumar pila y pila ordenada
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
        p1.sumaElementos();*/

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
    }
}
