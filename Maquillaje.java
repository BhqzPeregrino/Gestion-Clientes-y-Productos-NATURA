import java.util.Scanner;

public class Maquillaje extends Producto {
    protected int cantidad;

    public Maquillaje(int idProducto, String nombre) {
        super(idProducto, "Maquillaje", nombre);
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public static void agregarMaquillaje() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del maquillaje: ");
        String nombre = scanner.next();
        System.out.print("Ingrese el ID del maquillaje: ");
        int id = scanner.nextInt();
        System.out.print("Ingrese la cantidad de maquillaje: ");
        int cantidad = scanner.nextInt();
        Maquillaje maquillajeNuevo = new Maquillaje(id, nombre);
        maquillajeNuevo.setCantidad(cantidad);
        productos.add(maquillajeNuevo);
        System.out.println("\nMaquillaje agregado correctamente.");
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
            System.out.println("ID: " + maquillaje.getIdProducto() + " - Nombre: " + maquillaje.getNombre() + " - Cantidad: " + maquillaje.getCantidad());
        }
    }
}

}
