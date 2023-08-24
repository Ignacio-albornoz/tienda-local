package com.tiendalocal.aplicaciontienda.modelo.tienda;

import com.tiendalocal.aplicaciontienda.modelo.productos.Producto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Venta {
    final int CANTIDAD_MAXIMA_DE_PRODUCTOS = 10;
    final int CANTIDAD_MAXIMA_DE_PRODUCTOS_EN_CARRITO = 3;
    HashMap<Producto, Integer> carrito = new HashMap<>();
    double precioTotal;

    public Venta() {
        this.precioTotal = 0;
        this.carrito = new HashMap<Producto, Integer>();
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public boolean validarCantidad(int cantidad){
        if (cantidad > 0 && cantidad <= CANTIDAD_MAXIMA_DE_PRODUCTOS){
            return true;
        }
        System.out.println("Se agrego una cantidad de productos no valida. Recuerda agregar menos de " + CANTIDAD_MAXIMA_DE_PRODUCTOS + " productos iguales");
        return false;
    }

    public boolean validarCantidadDeProductosEnElCarrito(){
        if (carrito.size() <= 2){
            return true;
        }
        System.out.println("Se llego al limite de productos en el carrito. \n¡Recuerda el limite de productos es: " + CANTIDAD_MAXIMA_DE_PRODUCTOS_EN_CARRITO + "!");
        return false;
    }

    public double calcularImporte(int cantidad, double precioDelProducto){
        return cantidad * precioDelProducto;
    }

    public void agregarProductoAlCarrito(Producto producto, int cantidad){
        System.out.println("\n");
        System.out.println("Nueva venta:");
        double importe;
        boolean cantidadDeProductosCorrecta = true;
        boolean cantidadDeProductosEnElCarritoCorrecta = true;
        boolean productoDisponible = true;

        //Se verifica el producto este disponible
        if (!producto.isDisponible()){
            System.out.println("El producto: " + producto.getNombre() + " no se encuentra disponible!");
            return;
        }

        //Se verifica la cantidad obtenida por parametros, sea valida
        if (!validarCantidad(cantidad)){
            cantidadDeProductosCorrecta = false;
        }

        //Se verifica la cantidad de productos en el carro se valida
        if (!validarCantidadDeProductosEnElCarrito()){
            cantidadDeProductosEnElCarritoCorrecta = false;
        }


        if (!cantidadDeProductosCorrecta || !cantidadDeProductosEnElCarritoCorrecta){
            return;
        }

        //Se verifica si la cantidad es menor, mayor o igual al stock del producto
        if (cantidad <= producto.getStock()){
            //Se calcula el importe
            importe = calcularImporte(cantidad, producto.getPrecio());

            //Se agrega el producto al carrito
            carrito.put(producto, cantidad);

            //Se suma el importe al precio total
            precioTotal += importe;

            System.out.println("El producto " + producto.getNombre() + " se agrego al carrito!");
        } else {
            //Se agrega la cantidad de stock disponible
            carrito.put(producto, producto.getStock());

            //Se calcula el importe
            importe = calcularImporte(producto.getStock(), producto.getPrecio());

            //Se suma el importe al precio total
            precioTotal += importe;

            System.out.println("El producto " + producto.getNombre()  + ", ID: "+ producto.getId() + "\nTiene stock disponible menor al solicitado");
            System.out.println("Se agregaron: " + producto.getStock() + " unidades de " + producto.getNombre());
        }

    }

    public void imprimirDetalle(){

    }
}


