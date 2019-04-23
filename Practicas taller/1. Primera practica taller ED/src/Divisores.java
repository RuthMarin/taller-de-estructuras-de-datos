import java.util.Scanner;

public class Divisores {
    public static void main(String[] args) {
        int valor;
        Scanner lectura = new Scanner(System.in);
        System.out.print("Introduzca un valor entero positivo: ");
        valor = lectura.nextInt();
        if (valor < 1) {
            System.out.println("Número no válido");
        } else {
            visualizarDivisores(valor);
        }
    }

    public static void visualizarDivisores(int valor) {
        System.out.print("Los divisores son: ");
        for (int div = 1; div < valor; div++) {
            if (valor % div == 0) {
                System.out.print(div + " ");
            }
        }
    }
}
