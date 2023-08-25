package com.tiendalocal.aplicaciontienda.modelo.productos.interfaces;

public interface Descuento {
    public void aplicarDescuento(int porcentajeDescuento);
    public void setEstadoDelDescuento(boolean estadoDelDescuento);
    public boolean getEstadoDelDescuento();
    public void setPorcentajeDescuento(int porcentajeDescuento);
    public int getPorcentajeDescuento();
    public boolean validarDescuento(int porcentajeDescuento, int maximoPorcentajeDescuento);
    public void setPrecioConDescuento();
    public double getPrecioConDescuento();
    public boolean validarPrecioConDescuento(int porcentajeDescuento);
    public void borrarDescuento();
}
