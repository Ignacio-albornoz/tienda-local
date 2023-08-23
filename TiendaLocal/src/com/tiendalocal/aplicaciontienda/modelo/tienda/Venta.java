package com.tiendalocal.aplicaciontienda.modelo.tienda;

import com.tiendalocal.aplicaciontienda.modelo.productos.Producto;

import java.util.ArrayList;

public class Venta {
    ArrayList<Producto> carrito;
    double precioTotal;

    public Venta(ArrayList<Producto> productos, double precioTotal) {
        this.carrito = productos;
        this.precioTotal = precioTotal;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public void agregarProductoAlCarrito(Producto p, int cantidad){

    }

    public void imprimirDetalle(){

    }
}


