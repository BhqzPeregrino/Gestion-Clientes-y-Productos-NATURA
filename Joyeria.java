import java.util.Scanner;

public class Joyeria extends Producto {
    protected int cantidad;

    public Joyeria(int idProducto, String nombre) {
        super(idProducto, "Joyeria", nombre);
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public static void agregarJoyeria() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre de la joyería: ");
        String nombre = scanner.next();
        System.out.print("Ingrese el ID de la joyería: ");
        int id = scanner.nextInt();
        System.out.print("Ingrese la cantidad de joyería: ");
        int cantidad = scanner.nextInt();
        Joyeria joyeriaNueva = new Joyeria(id, nombre);
        joyeriaNueva.setCantidad(cantidad);
        productos.add(joyeriaNueva);
        System.out.println("\nJoyería agregada correctamente.");
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
                System.out.println("ID: " + joyeria.getIdProducto() + " - Nombre: " + joyeria.getNombre() + " - Cantidad: " + joyeria.getCantidad());
            }
        }
    }    
}