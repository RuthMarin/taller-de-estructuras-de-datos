public class Principal {
    public static void main (String [ ] args){
        Arbol arbol = new Arbol();
        Alumno Pepe = new Alumno("Pepe", "Francisco", 7.5), Maria = new Alumno("Maria", "Pineros", 7.5), Alberto = new Alumno("Alberto", "Diez", 6), Diego = new Alumno("Diego", "Gonzalez", 7);
        Alumno Pablo = new Alumno("Pablo", "Iglesias", 8.75), Franc = new Alumno("Franc", "Garcia", 1.45), Asier = new Alumno("Asier", "Lopez", 10), Joaquin = new Alumno("Joaquin", "Valverde", 5.25);

        arbol.insertar(1, Alberto);
        arbol.insertar(2, Maria);
        arbol.insertar(3,Pepe);
        arbol.insertar(4, Diego);
        arbol.insertar(5,Pablo);
        arbol.insertar(6,Franc);
        arbol.insertar(7,Asier);
        arbol.insertar(8,Joaquin);

        System.out.println("La media de calificaciones es: " + arbol.calificacionMedia());
        arbol.maxCali();

        arbol.postOrden();
        arbol.preOrden();
        arbol.ordenCentral();
    }

}
