public class Principal {
    public static void main(String args[]){
        Persona juan = new Persona("Juan", "123456", "Albufera"), jose = new Persona("Jose", "231465", "Princesa"), eva = new Persona("Eva", "321654", "Gaztambide");
        Persona alicia = new Persona("Alicia", "789456", "Castellana"), ernesto = new Persona("Ernesto","654321","Arboleda"), guillermo = new Persona("Guillermo","159267","Araviles");
        Persona alberto = new Persona("Alberto", "123456", "Gaztambide"), lucas = new Persona("Lucas", "231465", "Princesa"), clara = new Persona("Clara", "789456", "Castellana"), marcos = new Persona("Marcos", "666666666", "Madrid");
        GramETSISI redSocial = new GramETSISI(15);

        redSocial.insertaVertice(juan);
        redSocial.insertaVertice(jose);
        redSocial.insertaVertice(eva);
        redSocial.insertaVertice(alicia);
        redSocial.insertaVertice(ernesto);
        redSocial.insertaVertice(guillermo);
        redSocial.insertaVertice(alberto);
        redSocial.insertaVertice(lucas);
        redSocial.insertaVertice(clara);
        redSocial.insertaVertice(marcos);


        redSocial.insertaArista(0,1);
        redSocial.insertaArista(0,4);
        redSocial.insertaArista(0,5);
        redSocial.insertaArista(1,4);
        redSocial.insertaArista(2,9);
        redSocial.insertaArista(2,7);
        redSocial.insertaArista(3,6);
        redSocial.insertaArista(4,5);
        redSocial.insertaArista(6,8);
        redSocial.insertaArista(7,9);

        redSocial.imprimirGrafo();
        redSocial.mostrarAmigos("juan");
        System.out.printf("\nExisten %d grupo/s distinto/s en el grafo\n", redSocial.contarGrupo());
        redSocial.mayorGrupo();
    }
}