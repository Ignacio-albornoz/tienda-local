package com.tiendalocal.aplicaciontienda.modelo.productos;

public class Bebida extends Producto{
    boolean contieneAlcohol;
    double graduacionAlcoholica;
    boolean importado;

    //TODO Si contieneAlcohol = false, automaticamente graduacionAlcoholica = 0
    public Bebida(String id, String descripcion, int stock, double precio, double costo, boolean disponible, boolean contieneAlcohol, double graduacion, boolean importado) {
        super(id, descripcion, stock, precio, costo, disponible);
        this.contieneAlcohol = contieneAlcohol;
        this.graduacionAlcoholica = graduacion;
        this.importado = importado;
    }

    public boolean isContieneAlcohol() {
        return contieneAlcohol;
    }

    public void setContieneAlcohol(boolean contieneAlcohol) {
        this.contieneAlcohol = contieneAlcohol;
    }

    public double getGraduacionAlcoholica() {
        return graduacionAlcoholica;
    }

    //TODO Si contieneAlcohol = false, no se puede cargar graduacion
    public void setGraduacionAlcoholica(double graduacionAlcoholica) {
        this.graduacionAlcoholica = graduacionAlcoholica;
    }

    public boolean isImportado() {
        return importado;
    }

    public void setImportado(boolean importado) {
        this.importado = importado;
    }
}
