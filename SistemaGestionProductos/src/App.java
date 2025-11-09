import java.util.Scanner;

public class App {

    // Variables
    private static String nombreProducto = "N/A";
    private static double precioUnitario = 0.0;
    private static int cantidadInventario = 0;

    // Metodos
    public static void mostrarMenuPrincipal(){

        System.out.println("\n===========================================");
        System.out.println("--- Sistema de Gestión de Productos ---");
        System.out.println("===========================================");
        System.out.println("1. Registrar nuevo producto");
        System.out.println("2. Mostrar información del producto actual");
        System.out.println("3. Calcular valor total del inventario");
        System.out.println("4. Mostrar resumen completo del producto");
        System.out.println("5. Limpiar datos del producto actual");
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
 
    public static void  registroProducto(Scanner sc){

        System.out.println("\n--- Registro de Nuevo Producto ---");

        // Pedir nombre del producto
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = sc.nextLine().trim();

        if (!validarProducto(nombre)) {
            System.out.println("Error: El nombre no puede estar vacío.");
            return;
        }

        System.out.print("Ingrese el precio unitario: ");
        double precio = Double.parseDouble(sc.nextLine());

        if (!validarPrecio(precio)) {
            System.out.println("El precio debe ser mayor que 0. Intente nuevamente.");
        }

        System.out.print("Ingrese el precio unitario: ");
        int cantidad = Integer.parseInt(sc.nextLine());

        if (!validarCantidad(cantidad)) {
            System.out.println("La cantidad no puede ser negativa. Intente nuevamente.");
        }

        // Guardar datos
        nombreProducto = nombre;
        precioUnitario = precio;
        cantidadInventario = cantidad;
        
        System.out.println("Producto registrado exitosamente");

    }
 
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int opcion;
        
        do {
            mostrarMenuPrincipal();
            opcion = leerEntero(sc); // Limpiar buffer
            
            switch (opcion) {
                case 1:
                    registroProducto(sc);
                    break;
                case 2:
                    mostrarInformacionProducto();
                    break;
                case 3:
                    mostrarValorTotalInventario();
                    break;
                case 4:
                    mostrarResumenCompleto();
                    break;
                case 5:
                    limpiarDatosProducto();
                    break;
                case 0:
                    System.out.println("\n¡Gracias por usar el sistema! Hasta pronto.");
                    break;
                default:
                    System.out.println("\nOpción inválida. Por favor intente nuevamente.");
            }
               
        } while (opcion != 0);
        
        sc.close();
    }
}
