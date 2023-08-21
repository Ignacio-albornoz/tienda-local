package com.tiendalocal.aplicaciontienda.modelo.tienda;

import com.tiendalocal.aplicaciontienda.modelo.productos.Producto;

import java.util.ArrayList;
import java.util.HashMap;

public class Tienda {
    String nombre;
    int maxStock;
    double saldo;
    HashMap<String, ArrayList<Producto>> productos;

    public Tienda(String nombre, int maxStock, double saldo, HashMap<String, Producto> productos) {
        this.nombre = nombre;
        this.maxStock = maxStock;
        this.saldo = saldo;
        this.productos = new HashMap<String, ArrayList<Producto>>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMaxStock() {
        return maxStock;
    }

    public void setMaxStock(int maxStock) {
        this.maxStock = maxStock;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public HashMap<String, ArrayList<Producto>> getProductos() {
        return productos;
    }

    public void setProductos(HashMap<String, ArrayList<Producto>> productos) {
        this.productos = productos;
    }
}
