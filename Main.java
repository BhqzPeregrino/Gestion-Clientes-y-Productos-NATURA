import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestionConsultores gestionConsultores = new GestionConsultores();
        int opcion;

        do {
            System.out.println("   Bienvenido Jefe Natura! :) ");
            System.out.println("-----------------------------");
            System.out.println("*Gestión de consultores Natura*");
            System.out.println("1. Agregar consultor");
            System.out.println("2. Buscar consultor");
            System.out.println("3. Eliminar consultor");
            System.out.println("4. Modificar consultor");
            System.out.println("5. Listar consultores");
            System.out.println("-----------------------------");
            System.out.println("*Gestión de productos Natura*");
            System.out.println("6. Agregar producto");
            System.out.println("7. Eliminar producto");
            System.out.println("8. Ver productos");
            System.out.println("-----------------------------");
            System.out.println("*Gestión de ventas Natura*");
            System.out.println("9. Registrar ventas");
            System.out.println("10. Consultar ganancias");
            System.out.println("11. Salir");
            System.out.print("Ingrese una opción: ");

            try {
                opcion = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese solo números.");
                scanner.next();
                opcion = 0;
            }

            switch (opcion) {
                case 1:
                    gestionConsultores.agregarConsultor();
                    break;
                case 2:
                    gestionConsultores.buscarConsultor();
                    break;
                case 3:
                    gestionConsultores.eliminarConsultor();
                    break;
                case 4:
                    gestionConsultores.modificarConsultor();
                    break;
                case 5:
                    gestionConsultores.listarConsultores();
                    break;
                case 6:
                    Producto.agregarProducto();
                    break;
                case 7:
                    Producto.eliminarProducto();
                    break;
                case 8:
                    Producto.verProductos();
                    break;
                case 9:
                    Producto.registrarVenta();
                    break;
                case 10:
                    Producto.consultarGanancias();
                    break;
                case 11:
                    System.out.println("\nSaliendo del programa :))");
                    break;
                default:
                    System.out.println("\nOpción no válida.");
            }
        } while (opcion != 11);
        scanner.close();
    }
}