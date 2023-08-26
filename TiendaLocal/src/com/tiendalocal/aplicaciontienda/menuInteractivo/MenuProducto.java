package com.tiendalocal.aplicaciontienda.menuInteractivo;
import com.tiendalocal.aplicaciontienda.modelo.productos.ListaProductos;
import com.tiendalocal.aplicaciontienda.modelo.productos.Producto;


import java.util.List;
import java.util.Scanner;

public class MenuProducto {
    // Método main que ejecuta el programa
    public static void main(String[] args, ListaProductos listaProductos) {
        // Crear un array de String con las opciones del menú
        String[] opciones = {
                "Agregar un producto al inventario",
                "Buscar un producto por su identificador",
                "Mostrar todos los productos del inventario",
                "Eliminar un producto del inventario",
                "Aplicar descuento",
                "listarProductosConUtilidadesInferiores",
                "obtenerComestiblesConMenorDescuento",
                "imprimirListaDeProductosConGananciaIncorrecta",
                "Volver"
        };

        // Crear un array de String con los tipos de productos
        String[] tipos = {
                "ProductoEnvasado",
                "Bebida",
                "ProductoLimpieza"
        };

        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner sc = new Scanner(System.in);

        // Crear una variable booleana para controlar el bucle del menú
        boolean salir = false;

        // Crear una variable entera para guardar la opción elegida por el usuario
        int opcion;
        // Saludar al usuario y mostrar el nombre del programa
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("Hola, bienvenido al programa de gestión de productos.");

        // Crear un bucle while que se ejecute hasta que el usuario elija salir
        while (!salir) {

            System.out.println("\n");
            // Llamar al método que imprime las opciones del menú
            MenuGestorProductos.imprimirMenu(opciones);

            // Leer la opción del usuario con el Scanner
            System.out.print("Por favor, ingrese una opción: ");
            int opcion1 = sc.nextInt();


            // Usar un switch para ejecutar una acción según la opción elegida
            switch (opcion1) {
                case 1:
                    // Leer la opción del usuario con el Scanner
                    MenuGestorProductos.imprimirMenu(tipos);
                    MenuGestorProductos.agregarProductos(sc, opcion1, listaProductos);

                case 2:
                    System.out.print("Ingrese el ID del producto que desea buscar: ");
                    String idParaObtenerProducto = sc.next();
                    listaProductos.obtenerProductoPorId(idParaObtenerProducto);
                    System.out.println("\n");
                    break;

                case 3:
                    System.out.print("La lista de productos es la siguiente: ");
                    System.out.println("\n");
                    listaProductos.todosLosProductos();
                    System.out.println("\n");
                    break;

                case 4:
                    System.out.print("Ingrese el ID del producto que desea borrar: ");
                    String idParaBorrarProducto = sc.next();
                    listaProductos.borrarProducto(idParaBorrarProducto);
                    System.out.println("\n");
                    System.out.println("El producto fue borrado");
                    System.out.println("\n");
                    break;
                case 5:
                    //Aplicar descuento
                    System.out.print("Ingrese el ID del producto que desea buscar: ");
                    String idProducto = sc.next();
                    Producto p = listaProductos.obtenerProductoPorId(idProducto);
                    if(p == null){
                        break;
                    }
                    System.out.println("Cuanto % de descuento quiere aplicar?");
                    int descuento = sc.nextInt();
                    p.aplicarDescuento(descuento);

                    break;
                case 6:
                    System.out.println("Ingrese el porcentaje de utilidades que desea consultar");
                    System.out.println("------------------------");
                    int porcentaje = sc.nextInt();

                    List<Producto> listaUtilidadesBajas = listaProductos.listarProductosConUtilidadesInferiores(porcentaje);

                    listaUtilidadesBajas.stream().forEach(producto -> {
                        System.out.println("ID: " + producto.getId());
                        System.out.println("Descripcion: " + producto.getDescripcion());
                        System.out.println("Cantidad en stock: " + producto.getStock());
                        System.out.println("Porcentaje de ganancia: " + producto.porcentajeGanancia(producto.getCosto(), producto.getPrecio())+"%");
                        System.out.println("------------------------");
                    });
                    System.out.println("\n");
                    break;

                case 7:
                    System.out.println("Ingrese el porcentaje de descuento que desea consultar");
                    int porcentajeDescuento = sc.nextInt();
                    listaProductos.obtenerComestibleConMenorDescuento(porcentajeDescuento);
                    System.out.println("\n");
                    break;
                case 8:

                    listaProductos.imprimirListaDeProductosConGananciaIncorrecta();
                    break;
                case 9:

                    // Salir del programa
                    System.out.println("Gracias por usar el programa. Hasta pronto.");
                    System.out.println("\n");
                    salir = true; // Poner la variable booleana a true para salir del bucle
                    break;

                default:
                    // Manejar las opciones inválidas
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                    System.out.println("\n");
            }
        }
    }


}
