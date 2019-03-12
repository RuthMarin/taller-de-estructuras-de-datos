import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.sql.SQLOutput;

public class Aplicacion {

    public static void main(String[] args) {

        Paciente Alberto = new Paciente("Alberto", "Frecuentes mareos"), Ana = new Paciente("Ana", "Infección resistente"), Eva = new Paciente("Eva", "Problemas digestivos"), Ernesto = new Paciente("Ernesto", "Problemas cardiovasculares");
        ListaOrdinal listaPacientes = new ListaOrdinal();

        listaPacientes.insertar(Alberto);
        listaPacientes.insertar(Ana);
        listaPacientes.insertar(Eva);
        listaPacientes.insertar(Ernesto);

        Ana.darAlta();
        Eva.darAlta();

        Iterador iter = listaPacientes.obtenerIterador();

        System.out.println("\t\t\t\t-- Pacientes del Hospital --");

        while(iter.hasNext()){
            Paciente aux = iter.next();
            aux.verPaciente();
        }

    }
}