package com.tiendalocal.aplicaciontienda.modelo.productos.interfaces;

import java.time.LocalDate;

//Definimos la interfaz Comestible para productos que sean comestibles
public interface Comestible {
    //Metodos para implementar en los productos comestibles
    public void setFechaVencimiento(LocalDate fechaVencimiento);
    public LocalDate getFechaVencimiento();
    public void setCalorias(short calorias);
    public short getCalorias();
}
