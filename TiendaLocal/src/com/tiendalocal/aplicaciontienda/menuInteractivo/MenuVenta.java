package com.tiendalocal.aplicaciontienda.menuInteractivo;
import com.tiendalocal.aplicaciontienda.modelo.productos.ListaProductos;
import com.tiendalocal.aplicaciontienda.modelo.productos.Producto;
import com.tiendalocal.aplicaciontienda.modelo.tienda.Tienda;
import com.tiendalocal.aplicaciontienda.modelo.tienda.Venta;

import java.util.Scanner;
import java.util.ArrayList;

// Clase que contiene el método main del MenuVenta
public class MenuVenta {
    // Método main que ejecuta el programa
    public static void main(String[] args, Tienda tienda, ListaProductos listaProductos, Venta venta1 ) {
        //Se inicializa Venta

        // Crear un array de String con las opciones del MenuVenta
        String[] opciones = {
                "Agregar producto al carrito",
                "Ver carrito",
                "Finalizar compra",
                "Precio Total",
                "Limpiar carrito",
                "Volver al menú anterior"
        };

        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner sc = new Scanner(System.in);

        // Crear una variable booleana para controlar el bucle del MenuVenta
        boolean volver = false;

        // Crear una variable entera para guardar la opción elegida por el usuario
        int opcion;

        // Crear una variable double para guardar el total de las ventas
        double total = 0;

        // Crear un ArrayList de String para guardar los detalles de cada venta
        ArrayList<String> ventas = new ArrayList<String>();

        // Mostrar el nombre del programa
        System.out.println("Bienvenido al programa de venta de productos.");

        // Crear un bucle while que se ejecute hasta que el usuario elija volver al menú anterior
        while (!volver) {
            // Llamar al método que imprime las opciones del MenuVenta
            imprimirMenu(opciones);

            // Leer la opción del usuario con el Scanner
            System.out.print("Por favor, ingrese una opción: ");
            opcion = sc.nextInt();
            System.out.print("\n");
            // Usar un switch para ejecutar una acción según la opción elegida
            switch (opcion) {
                case 1:
                    // Agregar producto
                    System.out.print("\n");
                    System.out.print("Ingrese el id: ");
                    String id = sc.next();

                    // Llamar al método agregarProductos de la clase GestorProductos, pasando los argumentos necesarios
                    Producto p = listaProductos.obtenerProductoPorId(id);
                    if (p == null){
                        break;
                    }
                    System.out.println("\n" + "Ingrese la cantidad que desea comprar");
                    int cantidad = sc.nextInt();

                    try{
                        venta1.agregarProductoAlCarrito(p, cantidad);
                    } catch(Exception e){
                        System.out.println(e);
                    }


                    break;
                case 2:
                    //Consultar carrito
                    venta1.imprimirDetalle(listaProductos);

                    break;
                case 3:
                    venta1.finalizarCompra(tienda, listaProductos);

                    break;
                case 4:
                    // Mostrar saldo

                    // Mostrar el saldo en la caja con dos decimales
                    System.out.printf("El saldo en la caja es: %.2f\n", venta1.getPrecioTotal());

                    break;
                case 5:
                    // Limpiar Carrito

                    venta1.limpiarCarrito();

                    break;
                case 6:
                    // Volver al menú anterior

                    System.out.println("Volviendo al menú anterior.");
                    volver = true; // Poner la variable booleana a true para salir del bucle

                    break;
                default:
                    // Manejar las opciones inválidas
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
            }
            }
        }


    // Método que imprime las opciones del MenuVenta en la consola usando un bucle for
    public static void imprimirMenu(String[] opciones) {
        System.out.println("\nEstas son las opciones disponibles:");
        for (int i = 0; i < opciones.length; i++) {
            System.out.println((i + 1) + ". " + opciones[i]);
        }
    }
}
