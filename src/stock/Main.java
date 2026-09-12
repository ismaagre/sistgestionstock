package stock;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Inventario inventario = new Inventario();

        int opcion;

        do {

            System.out.println();
            System.out.println("========================================");
            System.out.println("       SISTEMA DE GESTION DE STOCK");
            System.out.println("========================================");
            System.out.println("1. Agregar producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Buscar producto");
            System.out.println("4. Modificar producto");
            System.out.println("5. Eliminar producto");
            System.out.println("6. Aumentar stock");
            System.out.println("7. Disminuir stock");
            System.out.println("8. Productos sin stock");
            System.out.println("0. Salir");
            System.out.println("========================================");

            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:

                    System.out.print("Ingrese ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Ingrese nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Ingrese precio: ");
                    double precio = scanner.nextDouble();

                    System.out.print("Ingrese stock: ");
                    int stock = scanner.nextInt();

                    Producto producto = new Producto(
                            id,
                            nombre,
                            precio,
                            stock
                    );

                    if (inventario.agregarProducto(producto)) {
                        System.out.println("Producto agregado correctamente.");
                    }

                    break;

                case 2:

                    inventario.listarProductos();

                    break;

                case 3:

                    System.out.print("Ingrese el ID del producto: ");
                    int idBuscar = scanner.nextInt();

                    Producto productoEncontrado =
                            inventario.buscarProducto(idBuscar);

                    if (productoEncontrado != null) {

                        System.out.println("----------------------------");
                        System.out.println("ID: " + productoEncontrado.getId());
                        System.out.println("Nombre: " + productoEncontrado.getNombre());
                        System.out.println("Precio: $" + productoEncontrado.getPrecio());
                        System.out.println("Stock: " + productoEncontrado.getStock());
                        System.out.println("----------------------------");

                    } else {

                        System.out.println("Producto no encontrado.");
                    }

                    break;

                case 4:

                    System.out.print("Ingrese el ID del producto: ");
                    int idModificar = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Ingrese el nuevo nombre: ");
                    String nuevoNombre = scanner.nextLine();

                    System.out.print("Ingrese el nuevo precio: ");
                    double nuevoPrecio = scanner.nextDouble();

                    inventario.modificarProducto(
                            idModificar,
                            nuevoNombre,
                            nuevoPrecio
                    );

                    break;

                case 5:

                    System.out.print("Ingrese el ID del producto: ");
                    int idEliminar = scanner.nextInt();

                    inventario.eliminarProducto(idEliminar);

                    break;

                case 6:

                    System.out.print("Ingrese el ID del producto: ");
                    int idAumentar = scanner.nextInt();

                    System.out.print("Ingrese la cantidad a aumentar: ");
                    int cantidadAumentar = scanner.nextInt();

                    inventario.aumentarStock(
                            idAumentar,
                            cantidadAumentar
                    );

                    break;

                case 7:

                    System.out.print("Ingrese el ID del producto: ");
                    int idDisminuir = scanner.nextInt();

                    System.out.print("Ingrese la cantidad a disminuir: ");
                    int cantidadDisminuir = scanner.nextInt();

                    inventario.disminuirStock(
                            idDisminuir,
                            cantidadDisminuir
                    );

                    break;

                case 8:

                    inventario.mostrarProductosSinStock();

                    break;

                case 0:

                    System.out.println("Programa finalizado.");

                    break;

                default:

                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 0);

        scanner.close();
    }
}