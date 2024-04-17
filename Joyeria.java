import java.util.Scanner;

public class Joyeria extends Producto {
    private int cantidad;

    public Joyeria(int idProducto, String nombre, int precio, int cantidad) {
        super(idProducto, "Joyeria", nombre, precio, cantidad);
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

    public static void agregarJoyeria() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre de la joyería: ");
        String nombre = scanner.next();


        while (nombreJoyeriaExistente(nombre)) {
            System.out.println("El nombre ingresado ya está en uso. Por favor, ingrese otro nombre.");
            System.out.print("Ingrese el nombre de la joyería: ");
            nombre = scanner.next();
        }

        System.out.print("Ingrese el ID de la joyería: ");
        int id = scanner.nextInt();


        while (idJoyeriaExistente(id)) {
            System.out.println("El ID ingresado ya está en uso. Por favor, ingrese otro ID.");
            System.out.print("Ingrese el ID de la joyería: ");
            id = scanner.nextInt();
        }

        System.out.print("Ingrese la cantidad de joyerías: ");
        int cantidad = scanner.nextInt();

        System.out.print("Ingrese el precio de la joyería: ");
        int precio = scanner.nextInt();

        Joyeria joyeriaNueva = new Joyeria(id, nombre, precio, cantidad);
        productos.add(joyeriaNueva);

        System.out.println("\nJoyería agregada correctamente.");
    }

    private static boolean nombreJoyeriaExistente(String nombre) {
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            if (producto.getTipoProducto().equalsIgnoreCase("Joyeria") && producto.getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }

    private static boolean idJoyeriaExistente(int id) {
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            if (producto.getTipoProducto().equalsIgnoreCase("Joyeria") && producto.getIdProducto() == id) {
                return true;
            }
        }
        return false;
    }

    public static void eliminarJoyeria() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID de la joyería a eliminar: ");
        int id = scanner.nextInt();
        Joyeria joyeriaEliminada = null;
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            if (producto instanceof Joyeria && producto.getIdProducto() == id) {
                joyeriaEliminada = (Joyeria) producto;
                break;
            }
        }
        if (joyeriaEliminada != null) {
            productos.remove(joyeriaEliminada);
            System.out.println("\nJoyería eliminada correctamente.");
        } else {
            System.out.println("\nJoyería no encontrada.");
        }
    }

    public static void verJoyerias() {
        System.out.println("\nLista de joyerías:");
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            if (producto instanceof Joyeria) {
                Joyeria joyeria = (Joyeria) producto;
                System.out.println("ID: " + joyeria.getIdProducto() + " - Nombre: " + joyeria.getNombre()
                        + " - Cantidad: " + joyeria.getCantidad());
            }
        }
    }
}