
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

    }

}

