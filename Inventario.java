import java.util.ArrayList;

public class Inventario {
    protected ArrayList<Producto> productos;

    public Inventario() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
    }

    public ArrayList<Producto> getProductos() {
        return this.productos;
    }
}