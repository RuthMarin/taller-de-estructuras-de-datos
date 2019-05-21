public class GramETSISI {
    private int maxNodos;             // Tamaño máximo de la tabla.
    private int numVertices;          // Número de vértices.
    private boolean matrizAdy[][];    // Matriz de adyacencias del grafo.
    private Persona contactos[];


    public GramETSISI(int n) { //construye una matriz de nxn sin arcos
        maxNodos = n;
        numVertices = 0;
        matrizAdy = new boolean[n][n];
        contactos = new Persona[n];
    }

    public int getMaxNodos() {
        return maxNodos;
    }

    public int getNumVertices() {
        return numVertices;
    }

    // ------------------------------------

    // MÉTODOS PARA INSERTAR Y ELIMINAR VERTICES

    // ------------------------------------


    public void insertaVertice() {
        if (maxNodos == numVertices)
            System.out.println("Error, se supera el número de nodos máximo del grafo");
        else {
            for (int i = 0; i <= numVertices; i++) {
                //simplemento añado el valor false a las celdas
                matrizAdy[i][numVertices] = matrizAdy[numVertices][i] = false;
            }
            Persona nuevo = new Persona();
            nuevo.leerDatos();
            contactos[numVertices] = nuevo;
            numVertices++;
        }
    }

    public void insertaVertice(Persona a) {
        if (maxNodos == numVertices)
            System.out.println("Error, se supera el número de nodos máximo del grafo");
        else {
            for (int i = 0; i <= numVertices; i++) {
                matrizAdy[i][numVertices] = matrizAdy[numVertices][i] = false;
            }
            contactos[numVertices] = a;
            numVertices++;
        }
    }

    public void eliminarVertice(int v) {
        if (v < numVertices && v >= 0) {
            numVertices--;
            int i;
            for (i = 0; i < v; i++) {
                for (int j = v; j < numVertices; j++) {
                    matrizAdy[i][j] = matrizAdy[i][j + 1];
                }
            }
            for (i = v; i < numVertices; i++) {
                contactos[i] = contactos[i + 1];
                int j;
                for (j = 0; j < v; j++) {
                    matrizAdy[i][j] = matrizAdy[i + 1][j];
                }
                for (j = v; j < numVertices; j++) {
                    matrizAdy[i][j] = matrizAdy[i + 1][j + 1];
                }
            }
        } else System.out.println("Error, fuera de rango");
    }

    // ------------------------------------

    // MÉTODOS PARA INSERTAR Y ELIMINAR ARISTAS

    // ------------------------------------

    public void insertaArista(int i, int j) {
        if ((i >= numVertices) || (j >= numVertices))
            System.out.println("Error, los vertices no se encuentran en el grafo.");
        else {
            matrizAdy[i][j] = true;
            matrizAdy[j][i] = matrizAdy[i][j];
        }
    }

    public boolean existeArista(int i, int j) {
        if ((i >= numVertices) || (j >= numVertices)) {
            System.out.println("Error, los vertices no se encuentran en el grafo.");
            return false;
        }
        return matrizAdy[i][j];
    }

    // ------------------------------------

    // MÉTODOS PROPIOS DE LA PRACTICA

    // ------------------------------------

    public void imprimirGrafo() {
        System.out.println("Contenido de la matriz: ");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (matrizAdy[i][j]) System.out.print("1 ");
                else System.out.print("0 ");
            }
            System.out.println();
        }

        System.out.println("\nExisten " + this.numVertices + " contactos:");
        for (int i = 0; i < numVertices; i++)
            contactos[i].mostrarPersona();
        System.out.println("");
    }

    public void mostrarAmigos(String nombre) {
        Boolean flag = false;
        for (int i = 0; i < this.numVertices; i++) {
            if (nombre.equalsIgnoreCase(contactos[i].getNombre())) {
                flag = true;
                System.out.println('"'+nombre+'"' + " tiene los siguientes amigos:");
                for (int j = 0; j < numVertices; j++)
                    if (matrizAdy[i][j])
                        contactos[j].mostrarPersona();
            }
        }
        if (!flag)
            System.out.println("\nNo se ha encontrado la persona en la lista de usuarios");
    }

    private void contarGrupoAux( int pos, boolean visitados[]) {
        visitados[pos] = true;
        for (int i = 0; i < this.getNumVertices(); i++){
            if ((pos != i) && (!visitados[i]) && (this.existeArista(pos, i)))
                contarGrupoAux( i, visitados);
        }
    }

    public int contarGrupo() {
        boolean[] visitados = new boolean[numVertices];
        boolean[] aux = new boolean[numVertices];
        int cont = 0;
       limpiarArray(visitados);

        for (int i = 0; i < this.getNumVertices(); i++){
            boolean flag = true;
            System.arraycopy(visitados,0, aux,0, this.numVertices);
            contarGrupoAux(i,visitados);
            for(int j = 0; j < this.numVertices && flag; j++)
                if(aux[j] != visitados[j]){
                    flag = false;
                    cont ++;
                }
        }
        return cont;
    }

    private int contarTrueEnArray(boolean[] array) {
        int cont = 0;
        for (int i = 0; i < numVertices; i++)
            if (array[i])
                cont++;
        return cont;
    }

    private void limpiarArray(boolean[] array){
        for (int i = 0; i < this.getNumVertices(); i++)
            array[i] = false;
    }

   public void mayorGrupo(){
       boolean[] visitados = new boolean[numVertices];
       boolean[] aux = new boolean[numVertices];
       int maxGrupo = 0;
       limpiarArray(visitados);

       contarGrupoAux(0, visitados);
       maxGrupo = contarTrueEnArray(visitados);
       System.arraycopy(visitados, 0, aux, 0, this.numVertices);

       for(int i = 1; i < this.numVertices; i++){
           if(!aux[i]){
               limpiarArray(visitados);
               contarGrupoAux(i, visitados);
               if(contarTrueEnArray(visitados) > maxGrupo){
                   maxGrupo = contarTrueEnArray(visitados);
                   System.arraycopy(visitados, 0, aux, 0, this.numVertices);
               }
           }
       }
       System.out.println("\nEstas son las personas pertenecientes al grupo mayoritario de la red social:");
       for(int i = 0; i < numVertices; i++)
           if(aux[i])
               contactos[i].mostrarPersona();
   }
}