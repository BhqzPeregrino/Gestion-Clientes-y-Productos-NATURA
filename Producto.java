import java.util.ArrayList;
import java.util.Scanner;

public abstract class Producto {
    static int gananciasTotales = 0;
    protected int idProducto;
    protected String tipoProducto;
    protected String nombre;
    protected int precio;
    protected int cantidad;

    public Producto(int idProducto, String tipoProducto, String nombre, int precio, int cantidad) {
        this.idProducto = idProducto;
        this.tipoProducto = tipoProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public abstract void vender(int cantidad);

    public static ArrayList<Producto> productos = new ArrayList<>();

    public static void agregarProducto() {
        Scanner scanner = new Scanner(System.in);
        String tipo;

        do {
            try {
                System.out.print("Ingrese el tipo de producto (Maquillaje, Joyeria, Perfumeria): ");
                tipo = scanner.next();
                
                if (!tipo.matches("[a-zA-Z]+")) {
                    throw new IllegalArgumentException("Por favor, ingrese solo letras.");
                }

                if (tipo.equalsIgnoreCase("Maquillaje")) {
                    Maquillaje.agregarMaquillaje();
                } else if (tipo.equalsIgnoreCase("Joyeria")) {
                    Joyeria.agregarJoyeria();
                } else if (tipo.equalsIgnoreCase("Perfumeria")) {
                    Perfumeria.agregarPerfumeria();
                } else {
                    System.out.println("Tipo de producto no válido.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                tipo = "";
            }
        } while (!tipo.equalsIgnoreCase("Maquillaje") && !tipo.equalsIgnoreCase("Joyeria")
                && !tipo.equalsIgnoreCase("Perfumeria"));
    }

    public static void eliminarProducto() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del producto a eliminar: ");
        int id = scanner.nextInt();
        Producto productoEliminado = null;
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            if (producto.getIdProducto() == id) {
                productoEliminado = producto;
                productos.remove(i);
                break;
            }
        }
        if (productoEliminado != null) {
            System.out.println("\nProducto eliminado correctamente.");
        } else {
            System.out.println("\nProducto no encontrado.");
        }
    }

    public static void verProductos() {
        System.out.println("\nLista de productos VIGENTES:");
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            if (producto instanceof Joyeria) {
                Joyeria joyeria = (Joyeria) producto;
                System.out.println("ID: " + joyeria.getIdProducto() + " - Nombre: " + joyeria.getNombre() + " - Tipo: "
                        + joyeria.getTipoProducto() + " - Cantidad: " + joyeria.getCantidad() + " - Precio: "
                        + joyeria.getPrecio());
            } else if (producto instanceof Perfumeria) {
                Perfumeria perfumeria = (Perfumeria) producto;
                System.out.println("ID: " + perfumeria.getIdProducto() + " - Nombre: " + perfumeria.getNombre()
                        + " - Tipo: " + perfumeria.getTipoProducto() + " - Cantidad: " + perfumeria.getCantidad()
                        + " - Precio: " + perfumeria.getPrecio());
            } else if (producto instanceof Maquillaje) {
                Maquillaje maquillaje = (Maquillaje) producto;
                System.out.println("ID: " + maquillaje.getIdProducto() + " - Nombre: " + maquillaje.getNombre()
                        + " - Tipo: " + maquillaje.getTipoProducto() + " - Cantidad: " + maquillaje.getCantidad()
                        + " - Precio: " + maquillaje.getPrecio());
            }
        }
    }

    public static void registrarVenta() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el tipo de producto (Joyeria, Maquillaje, Perfumeria): ");
        String tipoProducto = scanner.nextLine();
        System.out.print("Ingrese el ID del producto: ");
        int idProducto = scanner.nextInt();
    
        Producto productoEncontrado = null;
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            if (producto.getTipoProducto().equalsIgnoreCase(tipoProducto) && producto.getIdProducto() == idProducto) {
                productoEncontrado = producto;
                break;
            }
        }
    
        if (productoEncontrado != null) {
            System.out.print("Ingrese la cantidad a vender: ");
            int cantidad = scanner.nextInt();
            if (cantidad <= productoEncontrado.getCantidad()) {
                productoEncontrado.vender(cantidad);
                gananciasTotales += productoEncontrado.getPrecio() * cantidad;
                System.out.println("Venta realizada correctamente.");
            } else {
                System.out.println("No hay suficiente cantidad disponible para la venta.");
            }
        } else {
            System.out.println("No se encontró el producto con el tipo y ID especificados.");
        }
    }

    public static void consultarGanancias() {
        System.out.println("Ganancias totales: $" + gananciasTotales);
    }
}