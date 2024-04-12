import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestionConsultores gestionConsultores = new GestionConsultores();
        int opcion;

        do {
            System.out.println("Bienvenido a la gestion de consultores Natura");
            System.out.println("1. Agregar consultor");
            System.out.println("2. Buscar consultor");
            System.out.println("3. Eliminar consultor");
            System.out.println("4. Modificar consultor");
            System.out.println("5. Listar consultores");
            System.out.println("----------------");
            System.out.println("Gestion de productos Natura: ");
            System.out.println("6. Ver productos");
            System.out.println("7. Agregar producto");
            System.out.println("8. Eliminar producto");
            System.out.println("9. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

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
                    Producto.verProductos();
                    break;
                case 7:
                    Producto.agregarProducto();
                    break;
                case 8:
                    Producto.eliminarProducto();
                    break;
                case 9:
                    System.out.println("\nSaliendo del programa...");
                    break;
                default:
                    System.out.println("\nOpción no válida.");
            }
        } while (opcion != 9);

        scanner.close();
    }
}