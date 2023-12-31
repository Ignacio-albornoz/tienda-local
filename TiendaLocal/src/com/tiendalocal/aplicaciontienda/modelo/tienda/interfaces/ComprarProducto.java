package com.tiendalocal.aplicaciontienda.modelo.tienda.interfaces;

import com.tiendalocal.aplicaciontienda.modelo.productos.ListaProductos;

//TODO revisar nombres de metodos
public interface ComprarProducto {
    public void comprarProducto(String id, int cantidad, double precio, ListaProductos listaProductos);
    public double calcularImporte(int cantidad, double precio);
    public boolean verificarSaldo(double precio, int cantidad, double importe);
    public boolean verificarStockMaximo(int stockTotal, int cantidadComprada);
    public void restarImporte(double saldo, double importe);
}
