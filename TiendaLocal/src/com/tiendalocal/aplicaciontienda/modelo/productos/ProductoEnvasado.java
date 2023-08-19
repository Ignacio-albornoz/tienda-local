package com.tiendalocal.aplicaciontienda.modelo.productos;

import com.tiendalocal.aplicaciontienda.modelo.productos.enums.TipoEnvase;

public class ProductoEnvasado extends Producto{
    TipoEnvase tipoEnvase; //enum TipoEnvase (plastico, vidrio o lata)
    boolean importado;

    public ProductoEnvasado(String id, String descripcion, int stock, double precio, double costo, boolean disponible, TipoEnvase tipoEnvase, boolean importado) {
        super(id, descripcion, stock, precio, costo, disponible);
        this.tipoEnvase = tipoEnvase;
        this.importado = importado;
    }

    public TipoEnvase getTipoEnvase() {
        return tipoEnvase;
    }

    public void setTipoEnvase(TipoEnvase tipoEnvase) {
        this.tipoEnvase = tipoEnvase;
    }

    public boolean isImportado() {
        return importado;
    }

    public void setImportado(boolean importado) {
        this.importado = importado;
    }
}
