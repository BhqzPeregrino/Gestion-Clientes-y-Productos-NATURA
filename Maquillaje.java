import java.util.Scanner;

public class Maquillaje extends Producto {
    private int cantidad;

    public Maquillaje(int idProducto, String nombre, int precio, int cantidad) {
        super(idProducto, "Maquillaje", nombre, precio, cantidad);
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

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public static void agregarMaquillaje() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del maquillaje: ");
        String nombre = scanner.next();

        //validaciones
        while (nombreMaquillajeExistente(nombre)) {
            System.out.println("El nombre ingresado ya está en uso. Por favor, ingrese otro nombre.");
            System.out.print("Ingrese el nombre del maquillaje: ");
            nombre = scanner.next();
        }

        System.out.print("Ingrese el ID del maquillaje: ");
        int id = scanner.nextInt();

        //validaciones
        while (idMaquillajeExistente(id)) {
            System.out.println("El ID ingresado ya esta en uso. Por favor, ingrese otro ID.");
            System.out.print("Ingrese el ID del maquillaje: ");
            id = scanner.nextInt();
        }

        System.out.print("Ingrese la cantidad de maquillaje: ");
        int cantidad = scanner.nextInt();

        System.out.print("Ingrese el precio del maquillaje: ");
        int precio = scanner.nextInt();

        Maquillaje maquillajeNuevo = new Maquillaje(id, nombre, precio, cantidad);
        productos.add(maquillajeNuevo);

        System.out.println("\nMaquillaje agregado correctamente.");
    }

    private static boolean nombreMaquillajeExistente(String nombre) {
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            if (producto.getTipoProducto().equalsIgnoreCase("Maquillaje") && producto.getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }

    private static boolean idMaquillajeExistente(int id) {
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            if (producto.getTipoProducto().equalsIgnoreCase("Maquillaje") && producto.getIdProducto() == id) {
                return true;
            }
        }
        return false;
    }

    public static void eliminarMaquillaje() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del maquillaje a eliminar: ");
        int id = scanner.nextInt();
        Maquillaje maquillajeEliminado = null;
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            if (producto instanceof Maquillaje && producto.getIdProducto() == id) {
                maquillajeEliminado = (Maquillaje) producto;
                break;
            }
        }
        if (maquillajeEliminado != null) {
            productos.remove(maquillajeEliminado);
            System.out.println("\nMaquillaje eliminado correctamente.");
        } else {
            System.out.println("\nMaquillaje no encontrado.");
        }
    }

    public static void verMaquillajes() {
        System.out.println("\nLista de maquillajes:");
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            if (producto instanceof Maquillaje) {
                Maquillaje maquillaje = (Maquillaje) producto;
                System.out.println("ID: " + maquillaje.getIdProducto() + " - Nombre: " + maquillaje.getNombre()
                        + " - Cantidad: " + maquillaje.getCantidad());
            }
        }
    }

}
