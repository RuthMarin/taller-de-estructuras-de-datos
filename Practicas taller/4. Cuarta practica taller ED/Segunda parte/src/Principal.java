public class Principal {
    public static void main (String [ ] args){
        Arbol arbol = new Arbol();
        Alumno Pepe = new Alumno("Pepe", "Francisco", 7.5), Maria = new Alumno("Maria", "Pineros", 4.3), Alberto = new Alumno("Alberto", "Diez", 8), Diego = new Alumno("Diego", "Gonzalez", 7);

        arbol.insertar(1, Alberto);
        arbol.insertar(2, Maria);
        arbol.insertar(3,Pepe);
        arbol.insertar(4, Diego);

        System.out.println("La media de calificaciones es: " + arbol.calificacionMedia());
    }

}
