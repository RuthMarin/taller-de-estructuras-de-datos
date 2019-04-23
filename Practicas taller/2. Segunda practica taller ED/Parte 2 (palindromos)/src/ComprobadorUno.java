import java.util.Scanner;

public class ComprobadorUno {

    private String frase;
    private PilaCaracter pila1, pila2;

    public ComprobadorUno(){
        frase = null;
        pila1 = new PilaCaracter();
        pila2 = new PilaCaracter();
    }

    public ComprobadorUno(String frase){
        this.frase = frase;
        pila1 = new PilaCaracter();
        pila2 = new PilaCaracter();
    }

    public void leerFrase(){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nIntroduce una frase: ");
        frase = sc.nextLine();
    }

    public void esPalindromo(){

        for (int i = 0; i<this.frase.length();i++){
            if(frase.charAt(i) != ' '){
                pila1.apilar(frase.charAt(i));
            }
        }
        int numero = pila1.numElemPila()/2;
        if(pila1.numElemPila() % 2 == 0){
            for(int i = 0; i < numero; i++){
                pila2.apilar(pila1.desapilar());
            }
        }
        else{ //En caso de que haya un numero impar de caracteres despreciamos el impar del centro
            for(int i = 0; i< numero; i++){
                pila2.apilar(pila1.desapilar());
            }
            pila1.desapilar(); //Eliminamos el caracter del centro que nos sobra para que se queden las dos pilas iguales
        }

        boolean flag = true;
        PilaCaracter aux1 = pila1, aux2 = pila2;

        while(pila1.numElemPila() > 0 && flag){

            if(aux1.cima() != aux2.cima())
                flag = false;
            else{
                aux1.desapilar();
                aux2.desapilar();
            }
        }
        if (flag)
            System.out.println("\nLa frase ("+this.frase+") es un palindromo");
        else
            System.out.println("\nLa frase ("+this.frase+") no es un palindromo");
    }
}
