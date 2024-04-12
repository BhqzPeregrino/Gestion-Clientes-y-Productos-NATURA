import java.util.Scanner;

public class Perfumeria extends Producto {
    private int cantidad;

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Perfumeria(int idProducto, String nombre) {
        super(idProducto, "Perfumeria", nombre);
    }

    public static void agregarPerfumeria() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre de la perfumería: ");
        String nombre = scanner.next();
        System.out.print("Ingrese el ID de la perfumería: ");
        int id = scanner.nextInt();
        System.out.print("Ingrese la cantidad de perfumería: ");
        int cantidad = scanner.nextInt();
        Perfumeria perfumeriaNueva = new Perfumeria(id, nombre);
        perfumeriaNueva.setCantidad(cantidad);
        productos.add(perfumeriaNueva);
        System.out.println("\nPerfumería agregada correctamente.");
    }

    public static void eliminarPerfumeria() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID de la perfumería a eliminar: ");
        int id = scanner.nextInt();
        Perfumeria perfumeriaEliminada = null;
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            if (producto instanceof Perfumeria && producto.getIdProducto() == id) {
                perfumeriaEliminada = (Perfumeria) producto;
                break;
            }
        }
        if (perfumeriaEliminada != null) {
            productos.remove(perfumeriaEliminada);
            System.out.println("\nPerfumería eliminada correctamente.");
        } else {
            System.out.println("\nPerfumería no encontrada.");
        }
    }


    public static void verPerfumerias() {
        System.out.println("\nLista de perfumerías:");
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            if (producto instanceof Perfumeria) {
                Perfumeria perfumeria = (Perfumeria) producto;
                System.out.println("ID: " + perfumeria.getIdProducto() + " - Nombre: " + perfumeria.getNombre() + " - Cantidad: " + perfumeria.getCantidad());
            }
        }
    }
}
