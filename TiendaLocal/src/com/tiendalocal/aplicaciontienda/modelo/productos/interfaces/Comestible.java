package com.tiendalocal.aplicaciontienda.modelo.productos.interfaces;

import java.time.LocalDate;

public interface Comestible {
    public void setFechaVencimiento(LocalDate fechaVencimiento);
    public LocalDate getFechaVencimiento();
    public void setCalorias(short calorias);
    public short getCalorias();
}
