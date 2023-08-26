package com.tiendalocal.aplicaciontienda.modelo.productos;

import com.tiendalocal.aplicaciontienda.modelo.productos.interfaces.Descuento;
import com.tiendalocal.aplicaciontienda.modelo.productos.interfaces.Ganancia;

//Clase abstracta Producto
public abstract class Producto implements Descuento, Ganancia {
    //Atributos comunes a todos los productos
    String id;
    String nombre;
    String descripcion;
    int stock;
    double precio;
    double costo;
    boolean disponible;
    //Atributos necesarios para aplicar Descuentos
    boolean descuentoAplicado;
    int porcentajeDescuento;
    double precioConDescuento;


    public Producto(String id, String nombre, String descripcion, int stock, double precio, double costo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.stock = stock;
        this.precio = precio;
        this.costo = costo;
        this.disponible = true;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public double porcentajeGanancia(double precioCompra, double precioVenta){
        double porcentaje = (precioVenta - precioCompra) * 100 / precioCompra;
        return porcentaje;
    }


    @Override
    public void aplicarDescuento(int porcentajeDescuento) {
    }

    @Override
    public void setEstadoDelDescuento(boolean estadoDelDescuento) {
        this.descuentoAplicado = estadoDelDescuento;
    }

    @Override
    public boolean getEstadoDelDescuento() {
        return descuentoAplicado;
    }

    @Override
    public void setPorcentajeDescuento(int porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    @Override
    public int getPorcentajeDescuento() {
        return porcentajeDescuento;
    }


    public boolean validarDescuento(int porcentajeDescuento, int descuentoMaximo) {
        if (porcentajeDescuento < 0){
            return false;
        }

        if (porcentajeDescuento <= descuentoMaximo){
            System.out.println("Descuento valido");
            System.out.println("Descuento asignado: " + porcentajeDescuento + "%\n");
            return true;
        } else {
            System.out.println(porcentajeDescuento + "% no es un descuento valido");
            return false;
        }
    }


    @Override
    public void setPrecioConDescuento() {
        this.precioConDescuento = precio - (precio * porcentajeDescuento / 100);
    }

    @Override
    public double getPrecioConDescuento() {
        return precioConDescuento;
    }

    @Override
    public boolean validarPrecioConDescuento(int porcentajeDescuento) {
        double descuentoParcial;
        if (porcentajeDescuento <= 0){
            System.out.println("Porcentaje de descuento no valido");
            return false;
        }

        descuentoParcial = (precio * porcentajeDescuento / 100);

        if (this.precio > descuentoParcial){
            System.out.println("El porcentaje de descuento es aplicable al precio! \n");
            return true;
        }

        return false;

    }

    @Override
    public void borrarDescuento(){
        this.descuentoAplicado = false;
        this.precioConDescuento = 0;
        this.porcentajeDescuento = 0;
    }


    @Override
    public String toString() {
        return "ID: " + id;
    }

}
