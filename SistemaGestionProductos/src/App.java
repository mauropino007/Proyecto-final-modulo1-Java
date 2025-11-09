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
        System.out.print("Ingrese su opción:  ");
        System.out.println("\n");
        

    }

    public static int leerEntero(Scanner sc){

        while (true) {  

            if (sc.hasNextInt()) {

                int numero = sc.nextInt();
                sc.nextLine(); // limpiar buffer
                return numero; // retorno válido

            } else {

                System.out.println("número no inválido. Por favor ingrese un número entero.");
                sc.nextLine(); // limpiar entrada incorrecta

            }
        }
    }

    public static double leerDecimales(Scanner sc){

        while (true) {  

            if (sc.hasNextInt()) {

                double numero =  sc.nextDouble();
                sc.nextLine(); // limpiar buffer
                return numero; // retorno válido

            } else {

                System.out.println("número no inválido. Por favor ingrese un número entero.");
                sc.nextLine(); // limpiar entrada incorrecta

            }
        }
    }
 
    public static void  registroProducto(Scanner sc){

        System.out.println("\n--- Registro de Nuevo Producto ---\n");

        // Pedir nombre del producto
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = sc.nextLine().trim();

        if (!validarProducto(nombre)) {
            System.out.println("Error: El nombre no puede estar vacío.");
            return; 
        }

        System.out.print("Ingrese el precio unitario del producto: ");
        double precio = leerDecimales(sc);

        if (!validarPrecio(precio)) {
            System.out.println("El precio debe ser mayor que 0. Intente nuevamente.");
            return;
        }

        System.out.print("Ingrese la cantidad en inventario del producto: ");
        int cantidad = leerEntero(sc);

        if (!validarCantidad(cantidad)) {
            System.out.println("La cantidad no puede ser negativa. Intente nuevamente.");
            return;
        }

        // Guardar datos
        nombreProducto = nombre;
        precioUnitario = precio;
        cantidadInventario = cantidad;

        System.out.println("Producto registrado exitosamente");

    }
 
    public static boolean validarPrecio(double precio) {

        return precio > 0;

    }

    public static boolean validarCantidad(int cantidad) {

        return cantidad >= 0;

    }

    public static boolean validarProducto(String nombre) {

        return nombre != null && !nombre.trim().isEmpty();

    }

    public static void mostrarInformacionProducto() {

        if (nombreProducto.equals("N/A")) {

            System.out.println("No hay datos de producto registrados actualmente.");

        } else {

            System.out.println("\n--- Información del Producto ---\n");
            System.out.println("Nombre: " + nombreProducto);
            System.out.printf("Precio Unitario: $%,.2f%n", precioUnitario);
            System.out.println("Cantidad en Inventario: " + cantidadInventario);

        }
    }

    public static double mostrarValorTotalInventario() {

        if (nombreProducto.equals("N/A")) {
            System.out.println("No hay datos de producto registrados. Registre un producto primero.");
            return 0.0;
        }

        double valorTotal = precioUnitario * cantidadInventario;
        System.out.printf("Valor total del inventario: $%,.2f%n", valorTotal);
        return valorTotal;
    }

    public static void mostrarResumenCompletoProducto() {

        if (nombreProducto.equals("N/A")) {
            System.out.println("No hay datos de producto registrados actualmente.");
            return;
        }

        double valorTotal = precioUnitario * cantidadInventario;
        String estadoStock = "";

        if (cantidadInventario < 5) {
            estadoStock = "Stock bajo";
        } else if (cantidadInventario >= 5 && cantidadInventario <= 20) {
            estadoStock = "Stock suficiente";
        } else if (cantidadInventario > 20) {
            estadoStock = "Stock alto";
        }

        System.out.println("\n--- Resumen del Producto ---\n");
        System.out.println("Nombre: " + nombreProducto);
        System.out.printf("Precio Unitario: $%,.2f%n", precioUnitario);
        System.out.println("Cantidad en Inventario: " + cantidadInventario);
        System.out.printf("Valor Total en Inventario: $%,.2f%n", valorTotal);
        System.out.println("Estado del Stock: " + estadoStock);
    } 

    public static void limpiarDatosProducto() {

        nombreProducto = "N/A";
        precioUnitario = 0.0;
        cantidadInventario = 0;
        System.out.println("Los datos del producto actual han sido borrados exitosamente.");

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
                    mostrarResumenCompletoProducto();
                    break;
                case 5:
                    limpiarDatosProducto();
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
