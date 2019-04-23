public class ColaPrioridades {
    private NodoPrioridad inicio;

    public ColaPrioridades() {
        inicio = null;
    }

    public boolean estaVacia() {
        return inicio == null;
    }

    /** Inserta el paciente en la cola que le corresponde según su prioridad.
     * Si no hay ningún paciente con la misma prioridad, crea una cola nueva en la que mete al paciente.
     */
    public void encolar(int prioridad, Paciente paciente) {
        if(this.estaVacia()){
            Cola colaAux = new Cola();
            colaAux.encolar(paciente);
            this.inicio = new NodoPrioridad(prioridad, colaAux, null);
        }
        else{
            if(inicio.getClave() == prioridad){ //Aqui comprobamos si el primer nodo es la cola de pacientes que buscamos
                inicio.getDato().encolar(paciente);
            }
            else{ //En caso de que el primer nodo no sea la cola que buscamos
                NodoPrioridad actual = inicio.getSiguiente();
                NodoPrioridad anterior = inicio;
                Boolean flag = false;

                while((actual != null) && (actual.getClave() < prioridad)){

                    if(actual.getClave() == prioridad){ //Si encontramos la cola de pacientes de la misma prioridad añadimos al paciente
                        actual.getDato().encolar(paciente);
                        flag = true; //Aqui marcamos que hemos encontrado una cola de la misma prioridad que nuestro paciente
                    }
                    else{
                        anterior = actual;
                        actual = actual.getSiguiente();
                    }
                }
                if(!flag){ //En caso de que no haya encontrado una cola de pacientes de la misma prioridad
                    Cola colaPacientes = new Cola();
                    colaPacientes.encolar(paciente);
                    NodoPrioridad aux = new NodoPrioridad(prioridad,colaPacientes , actual);
                    anterior.setSiguiente(aux);
                }
            }
        }
    }

    /** Busca la clave en la lista. Si la encuentra devuelve el alumno asociado a dicha clave,
     * y si no la encuentra devuelve NULL.
     */
    public Paciente desencolar() {
        if(inicio == null){
            return  null;
        }
        else{
           Paciente paciente = inicio.getDato().desencolar();

           if(inicio.getDato().colaVacia()) //Si la cola de pacientes de la primera lista de pacientes se queda vacia la eliminamos
               inicio = inicio.getSiguiente();

           return  paciente;
        }
    }

    /** Visualizar todos los pacientes del hospital, ordenados por prioridad
     */
    public void verColaPrioridades() {
        System.out.println("\n\t\t\t\t-- Lista de pacientes --");
        if(this.estaVacia()){
            System.out.println("La lista de pacientes esta vacia");
        }
        else{
            NodoPrioridad aux = inicio;

            while(aux != null){

                System.out.println("Pacientes de prioridad " + aux.getClave() + " :");
                aux.getDato().verCola();
                aux = aux.getSiguiente();
            }
           // System.out.println("\n\t\t\t----------------------------------");
        }
    }
}


