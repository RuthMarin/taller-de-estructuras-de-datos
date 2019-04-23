/**
 * Created by bp0428 on 30/01/2019.
 */

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        int valor;
        Scanner lectura = new Scanner(System.in);
        System.out.print("Introduzca un valor entero: ");
        valor = lectura.nextInt();
        if (valor < 1) {
            System.out.println("El número ha de ser positivo");
        } else {
            System.out.println("El factorial de " + valor + " es " + factorial(valor));
        }
    }

    public static long factorial(int numero) {
        long resultado;
        if (numero <= 1) {
            resultado = 1;
        }
        else {
            resultado = numero * factorial(numero - 1);
        }
        return resultado;
    }
}
