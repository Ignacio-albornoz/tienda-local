package com.tiendalocal.aplicaciontienda.menuInteractivo;

import com.tiendalocal.aplicaciontienda.modelo.productos.ListaProductos;
import com.tiendalocal.aplicaciontienda.modelo.tienda.Tienda;

import java.sql.SQLOutput;
import java.util.Scanner;

public class MenuCompra {
    // Método main que ejecuta el programa
    public static void main(String[] args, Tienda tienda, ListaProductos listaProductos) {
        // Crear un array de String con las opciones del menúCompra
        String[] opciones = {
                "Comprar producto",
                "Mostrar saldo",
                "Mostrar inventario",
                "Volver al menú anterior"
        };

        // Crear un array de String con los tipos de productos
        String[] tipos = {
                "ProductoEnvasado",
                "Bebida",
                "ProductoLimpieza"
        };

        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner sc = new Scanner(System.in);

        // Crear una variable booleana para controlar el bucle del menúCompra
        boolean volver = false;

        // Crear una variable entera para guardar la opción elegida por el usuario
        int opcion;

        // Crear una variable double para guardar el saldo en la caja
        double saldo = 1000; // Puedes cambiar este valor inicial

        // Crear una variable int para guardar el máximo de stock habilitado
        int maxStock = 100; // Puedes cambiar este valor

        // Crear un ArrayList de Producto para guardar los productos del inventario

        // Mostrar el nombre del programa
        System.out.println("Bienvenido al programa de compra de productos.");
        System.out.println("\n");

        // Crear un bucle while que se ejecute hasta que el usuario elija volver al menú anterior
        while (!volver) {
            // Llamar al método que imprime las opciones del menúCompra
            imprimirMenu(opciones);

            // Leer la opción del usuario con el Scanner
            System.out.print("Por favor, ingrese una opción: ");
            opcion = sc.nextInt();

            // Usar un switch para ejecutar una acción según la opción elegida
            switch (opcion) {
                case 1:
                    // Agregar producto
                    System.out.print("Ingrese el id: ");
                    String id = sc.next();
                    System.out.print("Ingrese cantidad: ");
                    int cantidad = sc.nextInt();
                    System.out.print("Ingrese el costo: ");
                    double precio = sc.nextDouble();
                    // Llamar al método agregarProductos de la clase GestorProductos, pasando los argumentos necesarios
                    tienda.comprarProducto(id, cantidad, precio, listaProductos);


                    System.out.println("\n");

                    break;
                case 2:
                    // Mostrar saldo

                    // Mostrar el saldo en la caja con dos decimales
                    System.out.printf("El saldo en la caja es: %.2f\n", tienda.getSaldo());
                    System.out.println("\n");

                    break;
                case 3:
                    // Mostrar inventario

                    // Mostrar los productos del inventario usando un bucle for-each y el método toString de cada producto
                    System.out.println("Estos son los productos del inventario:");
                    tienda.todosLosProductos(listaProductos);
                    System.out.println("\n");

                    break;
                case 4:
                    // Volver al menú anterior

                    System.out.println("Volviendo al menú anterior.");
                    volver = true; // Poner la variable booleana a true para salir del bucle
                    System.out.println("\n");

                    break;

                default:
                    // Manejar las opciones inválidas
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                    System.out.println("\n");
            }
        }
    }

    // Método que imprime las opciones del menúCompra en la consola usando un bucle for
    public static void imprimirMenu(String[] opciones) {
        System.out.println("\nEstas son las opciones disponibles:");
        for (int i = 0; i < opciones.length; i++) {
            System.out.println((i + 1) + ". " + opciones[i]);
        }
    }
}
