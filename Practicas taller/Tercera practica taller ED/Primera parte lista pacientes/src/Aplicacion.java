import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.sql.SQLOutput;

public class Aplicacion {

   public static void verAltas(ListaOrdinal pacientes){
       Iterador iter = pacientes.obtenerIterador();

       System.out.println("\n\t\t\t\t--Pacientes dados de alta--");
       while(iter.hasNext()){
           Paciente aux = iter.next();
           if(aux.estaAlta())
               aux.verPaciente();
       }
   }

    public static void verPacientes(ListaOrdinal lista){
        Iterador iter = lista.obtenerIterador();
        Paciente aux;

        System.out.println("\n\t\t\t\t-- Pacientes del Hospital --");

        while(iter.hasNext()){
            aux = iter.next();
            aux.verPaciente();
        }
    }

   public static ListaOrdinal pacientesSintoma(ListaOrdinal lista, String sintoma){
       ListaOrdinal listaAux = new ListaOrdinal();
       Iterador iter = lista.obtenerIterador();
       Paciente paciente;

       while(iter.hasNext()){
           paciente = iter.next();

       }


       return listaAux;
   }

    public static void main(String[] args) {

        Paciente Alberto = new Paciente("Alberto", "Frecuentes mareos"), Ana = new Paciente("Ana", "Infección resistente"), Eva = new Paciente("Eva", "Problemas digestivos"), Ernesto = new Paciente("Ernesto", "Problemas cardiovasculares");
        ListaOrdinal listaPacientes = new ListaOrdinal();

        listaPacientes.insertar(Alberto);
        listaPacientes.insertar(Ana);
        listaPacientes.insertar(Eva);
        listaPacientes.insertar(Ernesto);

        Ana.darAlta();
        Eva.darAlta();

        verPacientes(listaPacientes);

        verAltas(listaPacientes);

        listaPacientes.borrarAltas();

        verPacientes(listaPacientes);


    }
}