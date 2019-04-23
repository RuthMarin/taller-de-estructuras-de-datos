public class Principal {
    public static void main(String[] args){
        ArbolCaracteres arbol;
        MetodosAE metodos = new MetodosAE() ;
        StringBuilder str;

        arbol = metodos.notacInfija("((5+2)*(8-3))/4");
        str = arbol.postOrdenString();
        System.out.println(str);
        float numero = arbol.CalcularValor();
        System.out.println(numero);
    }
}
