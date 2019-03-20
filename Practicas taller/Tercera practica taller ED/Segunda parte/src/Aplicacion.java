
public class Aplicacion {

    public static void main(String[] args) {
        Cola colaPacientes = new Cola();
        Paciente Alberto = new Paciente("Alberto", "Frecuentes Mareos"), Ana = new Paciente("Ana", "Infeccion persistente"), Eva = new Paciente("Eva", "Problemas digestivos");

        colaPacientes.encolar(Alberto);
        colaPacientes.encolar(Ana);
        colaPacientes.encolar(Eva);

        colaPacientes.verCola();

        while(!colaPacientes.colaVacia())
            colaPacientes.desencolar();

        colaPacientes.verCola();

        System.out.println("\n--Pruebas Cola prioridades --\n");

        ColaPrioridades colaPrioridades = new ColaPrioridades();

        colaPrioridades.encolar(4, Alberto);
        colaPrioridades.encolar(2, Ana);
        colaPrioridades.encolar(4, Eva);
        colaPrioridades.verColaPrioridades();

        Paciente pacienteDesencolado = colaPrioridades.desencolar();
        System.out.print("\n");
        pacienteDesencolado.verPaciente();
        colaPrioridades.verColaPrioridades();

        Paciente Ernesto = new Paciente("Ernesto", "Problemas cardiovasculares");
        colaPrioridades.encolar(1, Ernesto);
        colaPrioridades.verColaPrioridades();
    }

}

