import java.util.ArrayList;
import java.util.Scanner;

public class Producto {
    protected int idProducto;
    protected String tipoProducto;
    protected String nombre;

    public Producto(int idProducto, String tipoProducto, String nombre) {
        this.idProducto = idProducto;
        this.tipoProducto = tipoProducto;
        this.nombre = nombre;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static ArrayList<Producto> productos = new ArrayList<>();

    public static void agregarProducto() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el tipo de producto (Maquillaje, Joyeria, Perfumeria): ");
        String tipo = scanner.next();

        if (tipo.equalsIgnoreCase("Maquillaje")) {
            Maquillaje.agregarMaquillaje();
        } else if (tipo.equalsIgnoreCase("Joyeria")) {
            Joyeria.agregarJoyeria();
        } else if (tipo.equalsIgnoreCase("Perfumeria")) {
            Perfumeria.agregarPerfumeria();
        } else {
            System.out.println("Tipo de producto no válido.");
        }
    }

    public static void eliminarProducto() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del producto a eliminar: ");
        int id = scanner.nextInt();
        Producto productoEliminado = null;
        for (Producto producto : productos) {
            if (producto.getIdProducto() == id) {
                productoEliminado = producto;
                break;
            }
        }
        if (productoEliminado != null) {
            productos.remove(productoEliminado);
            System.out.println("\nProducto eliminado correctamente.");
        } else {
            System.out.println("\nProducto no encontrado.");
        }
    }

    public static void verProductos() {
        System.out.println("\nLista de productos:");
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            if (producto instanceof Joyeria) {
                Joyeria joyeria = (Joyeria) producto;
                System.out.println("ID: " + joyeria.getIdProducto() + " - Nombre: " + joyeria.getNombre() + " - Tipo: " + joyeria.getTipoProducto() + " - Cantidad: " + joyeria.getCantidad());
            } else if (producto instanceof Perfumeria) {
                Perfumeria perfumeria = (Perfumeria) producto;
                System.out.println("ID: " + perfumeria.getIdProducto() + " - Nombre: " + perfumeria.getNombre() + " - Tipo: " + perfumeria.getTipoProducto() + " - Cantidad: " + perfumeria.getCantidad());
            } else if (producto instanceof Maquillaje) {
                Maquillaje maquillaje = (Maquillaje) producto;
                System.out.println("ID: " + maquillaje.getIdProducto() + " - Nombre: " + maquillaje.getNombre() + " - Tipo: " + maquillaje.getTipoProducto() + " - Cantidad: " + maquillaje.getCantidad());
            }
        }
    }
}