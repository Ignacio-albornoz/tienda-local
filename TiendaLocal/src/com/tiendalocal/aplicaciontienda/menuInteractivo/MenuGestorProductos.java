package com.tiendalocal.aplicaciontienda.menuInteractivo;

import com.tiendalocal.aplicaciontienda.modelo.productos.Bebida;
import com.tiendalocal.aplicaciontienda.modelo.productos.Producto;
import com.tiendalocal.aplicaciontienda.modelo.productos.ProductoEnvasado;
import com.tiendalocal.aplicaciontienda.modelo.productos.ProductoLimpieza;
import com.tiendalocal.aplicaciontienda.modelo.productos.ListaProductos;
import com.tiendalocal.aplicaciontienda.modelo.productos.enums.TipoAplicacion;
import com.tiendalocal.aplicaciontienda.modelo.productos.enums.TipoEnvase;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuGestorProductos {
    // Función que agrega un producto al inventario según el tipo elegido por el usuario

    public static void imprimirMenu(String[] opciones) {
        System.out.println("\nEstas son las opciones disponibles:");
        for (int i = 0; i < opciones.length; i++) {
            System.out.println((i + 1) + ". " + opciones[i]);
        }
    }
    public static void agregarProductos(Scanner sc, int opcion, ListaProductos listaProductos) {

        // Leer la opción del usuario con el Scanner
        switch (opcion) {
            case 1:
                // ProductoEnvasado

                // Pedir al usuario los datos necesarios para el constructor de ProductoEnvasado
                System.out.print("Ingrese tres dígitos numericos del identificador: ");
                int digitos = sc.nextInt();

                // Concatenar las letras AB con los dígitos usando el operador +
                String id = "AB" + digitos;
                System.out.print("Ingrese el nombre: ");
                String nombre = sc.next();
                System.out.print("Ingrese la descripción: ");
                String descripcion = sc.next();
                System.out.print("Ingrese la cantidad: ");
                int cantidad = sc.nextInt();
                System.out.print("Ingrese el precio: ");
                double precio = sc.nextDouble();
                System.out.print("Ingrese el costo: ");
                double costo = sc.nextDouble();
                System.out.print("Ingrese si está disponible (true o false): ");
                boolean disponible = sc.nextBoolean();
                System.out.print("Ingrese el tipo de envase (plástico, vidrio o lata): ");
                String envase = sc.next();
                System.out.print("Ingrese si es importado (true o false): ");
                boolean importado = sc.nextBoolean();
                System.out.print("Ingrese si es comestible (true o false): ");
                boolean comestible = sc.nextBoolean();
                if (comestible) {
                    System.out.print("Ingrese anio de vencimiento");
                    int year = sc.nextInt();
                    System.out.print("Ingrese mes de vencimiento");
                    int mes = sc.nextInt();
                    System.out.print("Ingrese dia de vencimiento");
                    int dia = sc.nextInt();
                    LocalDate vencimiento = LocalDate.of(year, mes, dia);
                    System.out.print("Ingrese calorias del producto");
                    short calorias = sc.nextShort();
                    ProductoEnvasado pe = new ProductoEnvasado(id, nombre, descripcion, cantidad,
                            precio, costo, TipoEnvase.PLASTICO, importado, comestible, vencimiento, calorias
                    );
                }



                // Crear un objeto ProductoEnvasado con los datos ingresados por el usuario
                ProductoEnvasado pe = new ProductoEnvasado(id, nombre, descripcion, cantidad, precio, costo, TipoEnvase.PLASTICO, importado);

                // Agregar el objeto al inventario
                listaProductos.agregarProducto(pe);

                // Mostrar un mensaje de confirmación
                System.out.println("Producto envasado agregado al inventario.");

                break;
            case 2:
                // Bebida

                // Pedir al usuario los datos necesarios para el constructor de Bebida
                System.out.print("Ingrese tres dígitos numericos del identificador: ");
                int digitos2 = sc.nextInt();

                // Concatenar las letras AC con los dígitos usando el operador +
                String id2 = "AC" + digitos2;
                System.out.print("Ingrese el nombre: ");
                nombre = sc.next();
                System.out.print("Ingrese la descripción: ");
                descripcion = sc.next();
                System.out.print("Ingrese la cantidad: ");
                cantidad = sc.nextInt();
                System.out.print("Ingrese el precio: ");
                precio = sc.nextDouble();
                System.out.print("Ingrese el costo: ");
                costo = sc.nextDouble();

                System.out.println("Estos son los tipos de envase disponibles:");
                System.out.println("1. PLASTICO");
                System.out.println("2. VIDRIO");
                System.out.println("3. LATA");

                // Pedir al usuario que ingrese un número y validar que sea válido
                int numero;
                boolean valido = false;

                do {
                    System.out.print("Por favor, ingrese el número del tipo de envase: ");
                    numero = sc.nextInt();

                    // Verificar que el número esté entre 1 y 3
                    if (numero >= 1 && numero <= 3) {
                        valido = true; // Si es válido, poner la variable booleana a true para salir del bucle
                    } else {
                        System.out.println("Número inválido. Por favor, ingrese un número válido.");
                    }

                } while (!valido); // Repetir el bucle hasta que el número sea válido

                // Convertir el número en un valor del enum TipoEnvase usando el método values
                TipoEnvase te = TipoEnvase.values()[numero - 1];
                System.out.print("Ingrese si está disponible (true o false): ");
                disponible = sc.nextBoolean();
                System.out.print("Ingrese si es alcohólica (true o false): ");
                boolean contieneAlcohol = sc.nextBoolean();

                // Si es alcohólica, pedir la graduación alcohólica
                double graduacionAlcoholica = 0;
                if (contieneAlcohol) {
                    System.out.print("Ingrese la graduación alcohólica (porcentaje): ");
                    graduacionAlcoholica = sc.nextDouble();
                }

                System.out.print("Ingrese si es importada (true o false): ");
                importado = sc.nextBoolean();

                System.out.print("Ingrese si es comestible (true o false): ");
                boolean comestible2 = sc.nextBoolean();
                if (comestible2) {
                    System.out.print("Ingrese anio de vencimiento");
                    int year = sc.nextInt();
                    System.out.print("Ingrese mes de vencimiento");
                    int mes = sc.nextInt();
                    System.out.print("Ingrese dia de vencimiento");
                    int dia = sc.nextInt();
                    LocalDate vencimiento = LocalDate.of(year, mes, dia);
                    System.out.print("Ingrese calorias del producto");
                    short calorias = sc.nextShort();
                    Bebida b = new Bebida(id2, nombre, descripcion, cantidad, precio, costo, contieneAlcohol, graduacionAlcoholica, importado, comestible2,vencimiento,calorias);

                }


                //boolean contieneAlcohol, double graduacionAlcoholica, boolean importado, boolean comestible, LocalDate fechaVencimento, short calorias)

                // Crear un objeto Bebida con los datos ingresados por el usuario
                LocalDate vencimiento = LocalDate.now();
                short calorias = 0;
                Bebida b = new Bebida(id2, nombre, descripcion, cantidad, precio, costo, contieneAlcohol, graduacionAlcoholica, importado, comestible2,vencimiento,calorias);


                // Agregar el objeto al inventario
                listaProductos.agregarProducto(b);

                // Mostrar un mensaje de confirmación
                System.out.println("Bebida agregada al inventario.");

                break;
            case 3:
                // ProductoLimpieza


                // Pedir al usuario los datos necesarios para el constructor de ProductoLimpieza
                System.out.print("Ingrese tres dígitos numericos del identificador: ");
                int digitos3 = sc.nextInt();

                // Concatenar las letras AC con los dígitos usando el operador +
                String id3 = "AC" + digitos3;
                System.out.print("Ingrese la nombre: ");
                nombre = sc.next();
                System.out.print("Ingrese la descripción: ");
                descripcion = sc.next();
                System.out.print("Ingrese la cantidad: ");
                cantidad = sc.nextInt();
                System.out.print("Ingrese el precio: ");
                precio = sc.nextDouble();
                System.out.print("Ingrese el costo: ");
                costo = sc.nextDouble();
                System.out.print("Ingrese si está disponible (true o false): ");
                disponible = sc.nextBoolean();

                // Pedir al usuario el tipo de aplicación y validar que sea válido
                String aplicacion;
                boolean valido2 = false;

                // Mostrar una lista de enums con un número para cada uno
                System.out.println("Estos son los tipos de aplicación disponibles:");
                System.out.println("1. COCINA");
                System.out.println("2. PISOS");
                System.out.println("3. ROPA");
                System.out.println("4. MULTIUSO");

                // Pedir al usuario que ingrese un número y validar que sea válido
                int numero2;
                valido = false;

                do {
                    System.out.print("Por favor, ingrese el número del tipo de aplicación: ");
                    numero2 = sc.nextInt();

                    // Verificar que el número esté entre 1 y 4
                    if (numero2 >= 1 && numero2 <= 4) {
                        valido2 = true; // Si es válido, poner la variable booleana a true para salir del bucle
                    } else {
                        System.out.println("Número inválido. Por favor, ingrese un número válido.");
                    }

                } while (!valido); // Repetir el bucle hasta que el número sea válido

                // Convertir el número en un valor del enum TipoAplicacion usando el método values
                TipoAplicacion ta = TipoAplicacion.values()[numero2 - 1];

                // Crear un objeto ProductoLimpieza con los datos ingresados por el usuario
                ProductoLimpieza pl = new ProductoLimpieza(id3, descripcion, nombre, cantidad, precio, costo, ta);

                // Agregar el objeto al inventario
                listaProductos.agregarProducto(pl);

                // Mostrar un mensaje de confirmación
                System.out.println("Producto de limpieza agregado al inventario.");

                break;


        }
    }
}
