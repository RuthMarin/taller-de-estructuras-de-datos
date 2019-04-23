import java.util.Stack;

public class MetodosAE {

    public boolean esOperador(char c) {
                return ((c == '+') || (c == '-') || ('*' == c) || (c == '/'));
    }

    public boolean esDigito(char c) {
                return Character.isDigit(c);
    }

    public int pasarAEntero(char c) {
                return (c - 48);
    }

    public ArbolCaracteres notacInfija(String s) {
        //Al string s hay que anadirle un paréntesis de apertura y otro de cierre
        //Para que la expresién esté "fully parenthesized"

        s = "(" + s + ")";
        int l = s.length();

        Stack<ArbolCaracteres> pila = new Stack<ArbolCaracteres>();
        for (int i = 0; i < l; i++) {
            Character c = s.charAt(i);
            if (esDigito(c) || esOperador(c)) {
                //creo un arbol y lo apilo
                ArbolCaracteres a = new ArbolCaracteres(c);
                pila.push(a);
            } else if (c == ')') {
                ArbolCaracteres de = pila.pop();
                ArbolCaracteres root = pila.pop();
                ArbolCaracteres iz = pila.pop();
                char clave = root.getRaiz().getClave();
                root.juntar(clave, iz, de);
                pila.push(root);
            }
        }
        return pila.pop();
    }
}
