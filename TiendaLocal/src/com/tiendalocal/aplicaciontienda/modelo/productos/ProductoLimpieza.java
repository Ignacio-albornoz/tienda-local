package com.tiendalocal.aplicaciontienda.modelo.productos;

import com.tiendalocal.aplicaciontienda.modelo.productos.enums.TipoAplicacion;
import com.tiendalocal.aplicaciontienda.modelo.productos.interfaces.Descuento;

public class ProductoLimpieza extends Producto implements Descuento {
    TipoAplicacion tipoAplicacion;

    boolean descuentoAplicado;
    int porcentajeDescuento;
    double precioConDescuento;

    public ProductoLimpieza(String id, String nombre, String descripcion, int stock, double precio, double costo, boolean disponible, TipoAplicacion tipoAplicacion) {
        super(id, nombre, descripcion, stock, precio, costo, disponible);
        this.tipoAplicacion = tipoAplicacion;
    }

    public TipoAplicacion getTipoAplicacion() {
        return tipoAplicacion;
    }

    public void setTipoAplicacion(TipoAplicacion tipoAplicacion) {
        this.tipoAplicacion = tipoAplicacion;
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

    @Override
    public void setPrecioConDescuento() {
        if(descuentoAplicado && porcentajeDescuento > 0){
            this.precioConDescuento = precio - (precio * porcentajeDescuento / 100);
            System.out.println("Prueba precio con descuento: " + this.precioConDescuento);
        }
    }

    @Override
    public double getPrecioConDescuento() {
        return precioConDescuento;
    }
}
