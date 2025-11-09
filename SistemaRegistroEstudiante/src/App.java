import java.util.Scanner;


public class App {

    // Atributos del estudiante
    private static String nombreEstudiante = "N/A";
    private static double nota1 = -1;
    private static double nota2 = -1;
    private static double nota3 = -1;


    // Metodos
    public static void mostrarMenuPrincipal(){

        System.out.println("\n===========================================");
        System.out.println("--- Sistema de Registro de Estudiantes ---");
        System.out.println("===========================================");
        System.out.println("1. Registrar datos de un estudiante");
        System.out.println("2. Mostrar datos del estudiante actual");
        System.out.println("3. Calcular promedio de notas");
        System.out.println("4. Mostrar resumen completo del estudiante");
        System.out.println("5. Limpiar datos del estudiante actual");
        System.out.println("0. Salir");
        System.out.print("Ingrese su opción: ");

    }

    public static int leerEntero(Scanner sc){

        int numero;
        while (true) {  
            if (sc.hasNextInt()) {
                numero = sc.nextInt();
                sc.nextLine(); // limpiar buffer
                return numero; // retorno válido
            } else {
                System.out.println("número no inválido. Por favor ingrese un número entero.");
                sc.nextLine(); // limpiar entrada incorrecta
            }
        }
    }

    public static void  registrarEstudiante(Scanner sc){

        System.out.println("\n--- Registro de Estudiante ---");

        // Pedir nombre
        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = sc.nextLine();

        if (!validarNombre(nombre)) {
            System.out.println("Error: El nombre no puede estar vacío.");
            return;
        }

        double n1 = leerNota(sc,1);
        double n2 = leerNota(sc,2);
        double n3 = leerNota(sc,3);

        nombreEstudiante = nombre;
        nota1 = n1;
        nota2 = n2;
        nota3 = n3;

        System.out.println("Estudiante registrado correctamente.");

    }

    public static boolean validarNombre(String nombre) {

        return nombre != null && !nombre.trim().isEmpty();

    }

    public static double leerNota(Scanner sc, int numeroNota){

        double nota;
        while (true) {
            System.out.print("Ingrese la nota " + numeroNota + ": ");
            String linea = sc.nextLine().replace(",", ".");

            nota = Double.parseDouble(linea);
            if (validarNota(nota)) {
                 return nota;
            } else {
                System.out.println("Error: La nota debe estar entre 0 y 100.");
            }
        }
    }

    public static boolean validarNota(double nota) {

        return nota >= 0 && nota <= 100;

    }

    public static void mostrarDatosEstudiante() {

        System.out.println("\n--- Datos del Estudiante Actual ---");
        
        if (nombreEstudiante.equals("N/A")) {
            System.out.println("No hay datos de estudiante registrados actualmente.");
        } else {
            System.out.println("\n--- Datos del Estudiante Actual ---");
            System.out.println("Nombre: " + nombreEstudiante);
            System.out.printf("Nota 1: %.2f%n", nota1);
            System.out.printf("Nota 2: %.2f%n", nota2);
            System.out.printf("Nota 3: %.2f%n", nota3);
        }
    }

    public static void calcularPromedio() {

        System.out.println("\n--- Promedio de Notas ---");
        
        if (nombreEstudiante.equals("N/A")) {
            System.out.println("Advertencia: No hay datos de estudiante registrados.");
        } else {
            double promedio = mostrarPromedio();
            System.out.printf("El promedio de %s es: %.2f%n", nombreEstudiante, promedio);
        }
    }

    public static double mostrarPromedio() {

        return (nota1 + nota2 + nota3) / 3;

    }

    public static void mostrarResumenEstudiante() {
        System.out.println("\n--- Resumen del Estudiante ---");
        
        if (nombreEstudiante.equals("N/A")) {
            System.out.println("No hay datos de estudiante registrados actualmente.");
        } else {
            double promedio = mostrarPromedio();
            String estado = (promedio >= 60) ? "Aprobado" : "Reprobado";

            System.out.println("\n--- Resumen del Estudiante ---");
            System.out.println("Nombre: " + nombreEstudiante);
            System.out.printf("Nota 1: %.2f%n", nota1);
            System.out.printf("Nota 2: %.2f%n", nota2);
            System.out.printf("Nota 3: %.2f%n", nota3);
            System.out.printf("Promedio: %.2f%n", promedio);
            System.out.println("Estado: " + estado);
        }
    }

    public static void limpiarDatos() {
        nombreEstudiante = "N/A";
        nota1 = -1;
        nota2 = -1;
        nota3 = -1;
        
        System.out.println("\nLos datos del estudiante actual han sido borrados exitosamente.");
    }

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int opcion;
  
        do {
            mostrarMenuPrincipal();
            opcion = leerEntero(sc);

            switch (opcion) {
                case 1:
                    registrarEstudiante(sc);
                    break;
                case 2:
                    mostrarDatosEstudiante();
                    break;
                case 3:
                    calcularPromedio();
                    break;
                case 4:
                    mostrarResumenEstudiante();
                    break;
                case 5:
                limpiarDatos();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 0);

        sc.close();
    }
}
