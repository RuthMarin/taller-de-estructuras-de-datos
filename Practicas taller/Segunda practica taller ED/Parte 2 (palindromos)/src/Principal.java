public class Principal {

    public static void main(String[] args) {

        //Pruebas comprobador uno

        ComprobadorUno cp1 = new ComprobadorUno("aroma a mora"), cp2 = new ComprobadorUno("camino a casa"), cp3 = new ComprobadorUno("dabale arroz a la zorra el abad");

        cp1.esPalindromo();
        cp2.esPalindromo();
        cp3.esPalindromo();

        ComprobadorUno cp4 = new ComprobadorUno();

        cp4.leerFrase();
        cp4.esPalindromo();


        //Pruebas comprobador dos

        ComprobadorDos cp21 = new ComprobadorDos("aroma a mora"), cp22 = new ComprobadorDos("camino a casa"), cp23 = new ComprobadorDos("dabale arroz a la zorra el abad") ;

        cp21.esPalindromo();
        cp22.esPalindromo();
        cp23.esPalindromo();

        ComprobadorDos cp24 = new ComprobadorDos();

        cp24.leerFrase();
        cp24.esPalindromo();


        //Pruebas comprobador tres (clase stack)
        ComprobadorTres cp31 = new ComprobadorTres("aroma a mora"), cp32 = new ComprobadorTres("camino a casa") , cp33 = new ComprobadorTres("dabale arroz a la zorra el abad");

        cp31.esPalindromo();
        cp32.esPalindromo();
        cp33.esPalindromo();
    }
}