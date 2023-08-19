package com.tiendalocal.aplicaciontienda;

public class ProductoLimpieza extends Producto {
    String tipoAplicacion;

    public ProductoLimpieza(String id, String descripcion, int stock, double precio, double costo, boolean disponible, String tipoAplicacion) {
        super(id, descripcion, stock, precio, costo, disponible);
        this.tipoAplicacion = tipoAplicacion;
    }
}
