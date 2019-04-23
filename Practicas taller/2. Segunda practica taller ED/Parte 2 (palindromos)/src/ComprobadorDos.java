import java.util.Scanner;

public class ComprobadorDos {

    private String frase;
    private PilaCaracter pila;
    private  ColaCaracter cola;

    public ComprobadorDos(){
        frase = null;
        pila = new PilaCaracter();
        cola = new ColaCaracter();
    }

    public ComprobadorDos(String frase){
        this.frase = frase;
        pila = new PilaCaracter();
        cola = new ColaCaracter();
    }

    public void leerFrase(){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nIntroduce una frase: ");
        this.frase = sc.nextLine();
    }

    public void  esPalindromo(){

        boolean flag = true;

        for(int i = 0; i<this.frase.length();i++){ //Añadimos todos los caracteres de la frase a la pila auxiliar y a la cola
            if(frase.charAt(i) != ' '){
                pila.apilar(frase.charAt(i));
                cola.encolar(frase.charAt(i));
            }
        }
        while(cola.numElemCola() > 0 && flag) {

            if (pila.cima() != cola.primero()) {
                flag = false;
            }
            else {
                pila.desapilar();
                cola.desencolar();
            }
        }
        if (flag)
            System.out.println("\nLa frase ("+this.frase+") es un palindromo");
        else
            System.out.println("\nLa frase ("+this.frase+") no es un palindromo");
    }

}
