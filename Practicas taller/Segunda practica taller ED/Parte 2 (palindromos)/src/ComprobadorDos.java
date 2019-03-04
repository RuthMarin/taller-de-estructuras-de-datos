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

        PilaCaracter PilaAux1 = new PilaCaracter(), PilaAux2 = new PilaCaracter();
        ColaCaracter ColaAux = new ColaCaracter();
        boolean flag = true;

        for(int i = 0; i<this.frase.length();i++){ //Añadimos todos los caracteres de la frase a la pila auxiliar y a la cola
            if(frase.charAt(i) != ' '){
                pila.apilar(frase.charAt(i));
                cola.encolar(frase.charAt(i));
            }
        }
        PilaAux1 = pila;
        int numero = pila.numElemPila();
        for(int i = 0; i < numero; i++){ //Desapilamos la pila auxiliar en la pila principal para que tanto la cola como la pila esten ordenadas en el mismo sentido
            PilaAux2.apilar(PilaAux1.desapilar());
        }

        while(pila.numElemPila() > 0 && flag) {

            if (PilaAux2.cima() != ColaAux.primero())
                flag = false;
            else {
                PilaAux2.desapilar();
                ColaAux.desencolar();
            }
        }
        if (flag)
            System.out.println("\nLa frase ("+this.frase+") es un palindromo");
        else
            System.out.println("\nLa frase ("+this.frase+") no es un palindromo");
    }

}
