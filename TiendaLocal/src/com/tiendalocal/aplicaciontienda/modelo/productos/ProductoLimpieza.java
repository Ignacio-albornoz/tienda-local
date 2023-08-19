package com.tiendalocal.aplicaciontienda.modelo.productos;

import com.tiendalocal.aplicaciontienda.modelo.productos.enums.TipoAplicacion;

public class ProductoLimpieza extends Producto {
    TipoAplicacion tipoAplicacion;

    public ProductoLimpieza(String id, String descripcion, int stock, double precio, double costo, boolean disponible, TipoAplicacion tipoAplicacion) {
        super(id, descripcion, stock, precio, costo, disponible);
        this.tipoAplicacion = tipoAplicacion;
    }

    public TipoAplicacion getTipoAplicacion() {
        return tipoAplicacion;
    }

    public void setTipoAplicacion(TipoAplicacion tipoAplicacion) {
        this.tipoAplicacion = tipoAplicacion;
    }
}
