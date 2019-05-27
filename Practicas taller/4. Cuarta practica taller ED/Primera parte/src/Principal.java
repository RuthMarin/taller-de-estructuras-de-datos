public class Principal {
    public static void main(String[] args){
        ArbolCaracteres arbol1,arbol2,arbol3;
        MetodosAE metodos = new MetodosAE() ;
        String str;

        arbol1 = metodos.notacInfija("((5+2)*(8-3))/4");
        str = arbol1.postOrdenString();
        System.out.println(str);
        System.out.println( arbol1.calcularValor());

        arbol2 = metodos.notacInfija("((9+2)*(7-2))/2");
        str = arbol2.postOrdenString();
        System.out.println(str);
        System.out.println(arbol2.calcularValor());

        arbol3 = metodos.notacInfija("((2*9)+((3-7)*5))/9");
        str = arbol3.postOrdenString();
        System.out.println(str);
        System.out.println(arbol3.calcularValor());

    }
}
