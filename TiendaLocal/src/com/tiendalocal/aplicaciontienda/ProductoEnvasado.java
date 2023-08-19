package com.tiendalocal.aplicaciontienda;

public class ProductoEnvasado extends Producto{
    String tipoEnvase;
    boolean importado;

    public ProductoEnvasado(String id, String descripcion, int stock, double precio, double costo, boolean disponible, String tipoEnvase, boolean importado) {
        super(id, descripcion, stock, precio, costo, disponible);
        this.tipoEnvase = tipoEnvase;
        this.importado = importado;
    }

    public String getTipoEnvase() {
        return tipoEnvase;
    }

    public void setTipoEnvase(String tipoEnvase) {
        this.tipoEnvase = tipoEnvase;
    }

    public boolean isImportado() {
        return importado;
    }

    public void setImportado(boolean importado) {
        this.importado = importado;
    }
}
