package stock;

import java.util.ArrayList;

public class Inventario {

    private final ArrayList<Producto> productos;


    public Inventario() {
        productos = new ArrayList<>();
    }

    public boolean agregarProducto(Producto producto) {

        if (producto.getId() <= 0) {
            System.out.println("El ID debe ser mayor a 0.");
            return false;
        }

        if (producto.getNombre().isBlank()) {
            System.out.println("El nombre no puede estar vacio.");
            return false;
        }

        if (producto.getPrecio() < 0) {
            System.out.println("El precio no puede ser negativo.");
            return false;
        }

        if (producto.getStock() < 0) {
            System.out.println("El stock no puede ser negativo.");
            return false;
        }

        if (buscarProducto(producto.getId()) != null) {
            System.out.println("Ya existe un producto con ese ID.");
            return false;
        }

        productos.add(producto);

        return true;
    }

    public void listarProductos() {

        if (productos.isEmpty()) {
            System.out.println("No hay productos en el inventario.");
            return;
        }

        System.out.println("\n===== PRODUCTOS =====");

        for (Producto producto : productos) {

            System.out.println("----------------------------");
            System.out.println("ID: " + producto.getId());
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Precio: $" + producto.getPrecio());
            System.out.println("Stock: " + producto.getStock());
        }

        System.out.println("----------------------------");
    }

    public Producto buscarProducto(int id) {

        for (Producto producto : productos) {

            if (producto.getId() == id) {
                return producto;
            }
        }

        return null;
    }

    public void modificarProducto(int id, String nombre, double precio) {

        Producto producto = buscarProducto(id);

        if (producto == null) {
            System.out.println("Producto no encontrado.");
            return;
        }

        if (nombre.isBlank()) {
            System.out.println("El nombre no puede estar vacio.");
            return;
        }

        if (precio < 0) {
            System.out.println("El precio no puede ser negativo.");
            return;
        }

        producto.setNombre(nombre);
        producto.setPrecio(precio);

        System.out.println("Producto modificado correctamente.");
    }

    public void eliminarProducto(int id) {

        Producto producto = buscarProducto(id);

        if (producto != null) {

            productos.remove(producto);

            System.out.println("Producto eliminado correctamente.");

        } else {

            System.out.println("Producto no encontrado.");
        }
    }

    public void aumentarStock(int id, int cantidad) {

        Producto producto = buscarProducto(id);

        if (producto == null) {
            System.out.println("Producto no encontrado.");
            return;
        }

        if (cantidad <= 0) {
            System.out.println("La cantidad debe ser mayor a 0.");
            return;
        }

        producto.setStock(producto.getStock() + cantidad);

        System.out.println("Stock aumentado correctamente.");
    }

    public void disminuirStock(int id, int cantidad) {

        Producto producto = buscarProducto(id);

        if (producto == null) {
            System.out.println("Producto no encontrado.");
            return;
        }

        if (cantidad <= 0) {
            System.out.println("La cantidad debe ser mayor a 0.");
            return;
        }

        if (cantidad > producto.getStock()) {
            System.out.println("No hay suficiente stock.");
            return;
        }

        producto.setStock(producto.getStock() - cantidad);

        System.out.println("Stock disminuido correctamente.");
    }

    public void mostrarProductosSinStock() {

        boolean hayProductosSinStock = false;

        System.out.println("\n===== PRODUCTOS SIN STOCK =====");

        for (Producto producto : productos) {

            if (producto.getStock() == 0) {

                System.out.println("----------------------------");
                System.out.println("ID: " + producto.getId());
                System.out.println("Nombre: " + producto.getNombre());
                System.out.println("Precio: $" + producto.getPrecio());

                hayProductosSinStock = true;
            }
        }

        if (!hayProductosSinStock) {
            System.out.println("No hay productos sin stock.");
        }

        System.out.println("----------------------------");
    }
}