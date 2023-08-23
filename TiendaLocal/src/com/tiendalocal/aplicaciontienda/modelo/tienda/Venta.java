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

    public Venta(double precioTotal) {
        this.precioTotal = precioTotal;
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
        System.out.println("Se agrego una cantidad de prodcutos no valida. \bRecuerda no se pueden agregar mas de " + CANTIDAD_MAXIMA_DE_PRODUCTOS + "productos iguales");
        return false;
    }

    public boolean validarCantidadDeProductosEnElCarrito(){
        if (carrito.size() <= 3){
            return true;
        }
        System.out.println("Se llego al limite de productos en el carrito. \bRecuerda el limite de productos es: " + CANTIDAD_MAXIMA_DE_PRODUCTOS_EN_CARRITO);
        return false;
    }

    public boolean validarStock(int cantidad){

    }

    public void agregarProductoAlCarrito(Producto producto, int cantidad){
        if (!validarCantidad(cantidad)){
            return;
        }

        if (!validarCantidadDeProductosEnElCarrito()){
            return;
        }

        if (!producto.isDisponible()){
            System.out.println("El producto:\b" + "id: " + producto.getId() + ", Nobre: "+ producto.getNombre() + " no se encuentra disponible");
            return;
        }

        //Producto Disponible
        if (producto.isDisponible()){
            //Validar Stock
            if (cantidad <= producto.getStock()){
                //TODO revisar
                if (carrito.size() <= 3 ){
                    carrito.put(producto, cantidad);
                    double importe = cantidad * producto.getPrecio();
                    precioTotal += importe;
                }
                else {
                    System.out.println("Su carrito esta lleno!");
                }

            } else {
                System.out.println("El producto:\b" + "id: " + producto.getId() + ", Nobre: "+ producto.getNombre() + " tiene stock disponible menor al solicitado");
                carrito.put(producto, producto.getStock());
            }

        } else {
            System.out.println("El producto:\b" + "id: " + producto.getId() + ", Nobre: "+ producto.getNombre() + " no se encuentra disponible");
        }

    }

    public void imprimirDetalle(){

    }
}


