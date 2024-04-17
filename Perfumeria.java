import java.util.Scanner;

public class Perfumeria extends Producto {
    private int cantidad;

    public Perfumeria(int idProducto, String nombre, int precio, int cantidad) {
        super(idProducto, "Perfumeria", nombre, precio, cantidad);
        this.cantidad = cantidad;
    }

    @Override
    public int getCantidad() {
        return cantidad;
    }

    @Override
    public void vender(int cantidad) {
        this.cantidad -= cantidad;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getPrecio() {
        return precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public static void agregarPerfumeria() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre de la perfumería: ");
        String nombre = scanner.next();


        while (nombrePerfumeriaExistente(nombre)) {
            System.out.println("El nombre ingresado ya está en uso. Por favor, ingrese otro nombre.");
            System.out.print("Ingrese el nombre de la perfumería: ");
            nombre = scanner.next();
        }

        System.out.print("Ingrese el ID de la perfumería: ");
        int id = scanner.nextInt();


        while (idPerfumeriaExistente(id)) {
            System.out.println("El ID ingresado ya está en uso. Por favor, ingrese otro ID.");
            System.out.print("Ingrese el ID de la perfumería: ");
            id = scanner.nextInt();
        }

        System.out.print("Ingrese la cantidad de perfumería: ");
        int cantidad = scanner.nextInt();

        System.out.print("Ingrese el precio de la perfumería: ");
        int precio = scanner.nextInt();

        Perfumeria perfumeriaNueva = new Perfumeria(id, nombre, precio, cantidad);
        productos.add(perfumeriaNueva);

        System.out.println("\nPerfumería agregada correctamente.");
    }

    private static boolean nombrePerfumeriaExistente(String nombre) {
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            if (producto.getTipoProducto().equalsIgnoreCase("Perfumeria") && producto.getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }
    
    private static boolean idPerfumeriaExistente(int id) {
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            if (producto.getTipoProducto().equalsIgnoreCase("Perfumeria") && producto.getIdProducto() == id) {
                return true;
            }
        }
        return false;
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
