package com.tiendalocal.aplicaciontienda.menuInteractivo;

import com.tiendalocal.aplicaciontienda.modelo.productos.ListaProductos;
import com.tiendalocal.aplicaciontienda.modelo.tienda.Tienda;
import com.tiendalocal.aplicaciontienda.modelo.tienda.Venta;

import java.util.Scanner;

public class MenuPrincipal {
    // Método main que ejecuta el programa
    public static void main(String[] args) {
        // Crear un array de String con las opciones del menú anterior
        String[] opciones = {
                "Administrar productos",
                "Comprar",
                "Vender",
                "Seed",
                "Salir"
        };


        //Se inicializa lista Producto
        ListaProductos listaProductos = new ListaProductos();

        //Se inicializa la Tienda
        Tienda tienda = new Tienda("Eureka", 55, 15478.45);
        //Se inicializa Venta
        Venta venta1 = new Venta();
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner sc = new Scanner(System.in);

        boolean seEjecuto = false;
        // Crear una variable booleana para controlar el bucle del menú anterior
        boolean salir = false;

        // Crear una variable entera para guardar la opción elegida por el usuario
        int opcion;

        // Mostrar el nombre del programa
        System.out.println("Bienvenido al programa de gestión de productos.");

        // Crear un bucle while que se ejecute hasta que el usuario elija salir
        while (!salir) {
            // Llamar al método que imprime las opciones del menú anterior
            imprimirMenu(opciones);

            // Leer la opción del usuario con el Scanner
            System.out.print("Por favor, ingrese una opción: ");
            opcion = sc.nextInt();

            // Usar un switch para ejecutar una acción según la opción elegida
            switch (opcion) {
                case 1:
                    // Administrar productos

                    // Llamar al método main de la clase Main que contiene el menú de los productos
                    MenuProducto.main(args, listaProductos );
                    System.out.println("\n");

                    break;
                case 2:
                    // Comprar
                    MenuCompra.main(args, tienda, listaProductos);
                    System.out.println("\n");
                    // Aquí va el código para comprar productos

                    break;
                case 3:
                    // Vender
                    MenuVenta.main(args,tienda,listaProductos, venta1);
                    System.out.println("\n");
                    // Aquí va el código para vender productos

                    break;
                case 4:
                    // Seed, datos pre cargados y multiples interacciones, para poder interactuar mas facil
                    seed.main(args, tienda, venta1, listaProductos, seEjecuto);
                    System.out.println("\n");
                    seEjecuto = true;
                    // Aquí va el código para vender productos

                    break;
                case 5:
                    // Salir

                    System.out.println("Gracias por usar el programa. Hasta pronto.");
                    salir = true; // Poner la variable booleana a true para salir del bucle
                    System.out.println("\n");

                    break;
                default:
                    // Manejar las opciones inválidas
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                    System.out.println("\n");
            }
        }
    }

    // Método que imprime las opciones del menú anterior en la consola usando un bucle for
    public static void imprimirMenu(String[] opciones) {
        System.out.println("\nEstas son las opciones disponibles:");
        for (int i = 0; i < opciones.length; i++) {
            System.out.println((i + 1) + ". " + opciones[i]);
        }
    }
}
