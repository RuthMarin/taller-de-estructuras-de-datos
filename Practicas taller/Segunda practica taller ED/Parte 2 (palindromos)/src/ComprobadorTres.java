import java.util.Scanner;
import java.util.Stack;

public class ComprobadorTres {

    private String frase;
    private Stack<Character> pila1, pila2;

    public ComprobadorTres(){
        frase = null;
        pila1 = new Stack<>();
        pila2 = new Stack<>();
    }

    public ComprobadorTres(String frase){
        this.frase = frase;
        pila1 = new Stack<>();
        pila2 = new Stack<>();
    }

    public void leerFrase(){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nIntroduce una frase: ");
        frase = sc.nextLine();
    }

    public void esPalindromo(){
        int numero = 0;
        for ( int i = 0; i<this.frase.length(); i++){
            if(frase.charAt(i) != ' '){
                pila1.push(frase.charAt(i));
                numero ++;
            }
        }

        if(numero % 2 == 0){
            for(int i = 0; i < (numero/2); i++) {
                pila2.push(pila1.pop());
            }
            numero /= 2;
        }
        else{ //En caso de que haya un numero impar de caracteres despreciamos el impar del centro
            for(int i = 0; i < (numero/2); i++){
                pila2.push(pila1.pop());
            }
            pila1.pop(); //Eliminamos el caracter del centro que nos sobra para que se queden las dos pilas iguales
            numero /= 2;
        }

        boolean flag = true;

        while(numero > 0 && flag){

            if(pila1.peek() != pila2.peek())
                flag = false;
            else{
                pila1.pop();
                pila2.pop();
                numero --;
            }
        }
        if (flag)
            System.out.println("\nLa frase ("+this.frase+") es un palindromo");
        else
            System.out.println("\nLa frase ("+this.frase+") no es un palindromo");
    }
}
