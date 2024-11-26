import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Entregable {
    private static HashMap<String, String> usuarios1 = new HashMap<>();
    private static ArrayList<Paciente> pacientes1 = new ArrayList<>();
    private static ArrayList<Medicamento> historialMedicamentos1 = new ArrayList<>();

    public static void main(String[] args) {
        usuarios1.put("admin", "12345");
        usuarios1.put("usuario1", "pass123");

        Scanner scanner1 = new Scanner(System.in);
        if (!iniciarSesion(scanner1)) {
            System.out.println("Credenciales incorrectas. Saliendo del sistema.");
            return;
        }

        while (true) {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Registrar paciente");
            System.out.println("2. Listar pacientes");
            System.out.println("3. Crear receta");
            System.out.println("4. Ver historial de medicamentos");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion1 = scanner1.nextInt();
            scanner1.nextLine();

            switch (opcion1) {
                case 1:
                    registrarPaciente(scanner1);
                    break;
                case 2:
                    listarPacientes();
                    break;
                case 3:
                    crearReceta(scanner1);
                    break;
                case 4:
                    verHistorialMedicamentos();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static boolean iniciarSesion(Scanner scanner1) {
        System.out.print("Ingrese su usuario: ");
        String username1 = scanner1.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String password1 = scanner1.nextLine();
        return usuarios1.containsKey(username1) && usuarios1.get(username1).equals(password1);
    }

    private static void registrarPaciente(Scanner scanner1) {
        System.out.println("\n--- Registro de Paciente ---");
        System.out.print("Ingrese el nombre del paciente: ");
        String nombre1 = scanner1.nextLine();
        System.out.print("Ingrese la edad del paciente: ");
        int edad1 = scanner1.nextInt();
        scanner1.nextLine();
        System.out.print("Ingrese la dirección del paciente: ");
        String direccion1 = scanner1.nextLine();
        Paciente paciente1 = new Paciente(nombre1, edad1, direccion1);
        pacientes1.add(paciente1);
        System.out.println("Paciente registrado exitosamente.");
    }

    private static void listarPacientes() {
        if (pacientes1.isEmpty()) {
            System.out.println("No hay pacientes registrados.");
            return;
        }
        System.out.println("\n--- Lista de Pacientes ---");
        for (Paciente paciente1 : pacientes1) {
            System.out.println(paciente1);
        }
    }

    private static void crearReceta(Scanner scanner1) {
        System.out.println("\n--- Crear Receta ---");
        System.out.print("Ingrese el nombre del paciente para la receta: ");
        String nombrePaciente1 = scanner1.nextLine();

        Paciente paciente1 = buscarPaciente(nombrePaciente1);
        if (paciente1 == null) {
            System.out.println("Paciente no encontrado.");
            return;
        }

        ArrayList<Medicamento> receta1 = new ArrayList<>();
        while (true) {
            System.out.print("Ingrese el nombre del medicamento (o 'fin' para terminar): ");
            String nombreMedicamento1 = scanner1.nextLine();
            if (nombreMedicamento1.equalsIgnoreCase("fin")) {
                break;
            }

            System.out.print("Ingrese la cantidad del medicamento: ");
            int cantidad1 = scanner1.nextInt();
            scanner1.nextLine();

            Medicamento medicamento1 = new Medicamento(nombreMedicamento1, cantidad1);
            receta1.add(medicamento1);
            historialMedicamentos1.add(medicamento1);
        }

        System.out.println("\nReceta creada para el paciente: " + paciente1.getNombre1());
        for (Medicamento medicamento1 : receta1) {
            System.out.println(medicamento1);
        }
    }

    private static Paciente buscarPaciente(String nombre1) {
        for (Paciente paciente1 : pacientes1) {
            if (paciente1.getNombre1().equalsIgnoreCase(nombre1)) {
                return paciente1;
            }
        }
        return null;
    }

    private static void verHistorialMedicamentos() {
        if (historialMedicamentos1.isEmpty()) {
            System.out.println("No hay historial de medicamentos.");
            return;
        }

        System.out.println("\n--- Historial de Medicamentos ---");
        for (Medicamento medicamento1 : historialMedicamentos1) {
            System.out.println(medicamento1);
        }
    }
}

class Paciente {
    private String nombre1;
    private int edad1;
    private String direccion1;

    public Paciente(String nombre1, int edad1, String direccion1) {
        this.nombre1 = nombre1;
        this.edad1 = edad1;
        this.direccion1 = direccion1;
    }

    public String getNombre1() {
        return nombre1;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre1 + ", Edad: " + edad1 + ", Dirección: " + direccion1;
    }
}

class Medicamento {
    private String nombre1;
    private int cantidad1;

    public Medicamento(String nombre1, int cantidad1) {
        this.nombre1 = nombre1;
        this.cantidad1 = cantidad1;
    }

    @Override
    public String toString() {
        return "Medicamento: " + nombre1 + ", Cantidad: " + cantidad1;
    }
}