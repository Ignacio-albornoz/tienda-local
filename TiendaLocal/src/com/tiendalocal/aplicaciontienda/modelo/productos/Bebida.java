package com.tiendalocal.aplicaciontienda.modelo.productos;

import com.tiendalocal.aplicaciontienda.modelo.productos.interfaces.Comestible;

import java.time.LocalDate;

public class Bebida extends Producto implements Comestible {
    boolean contieneAlcohol;
    double graduacionAlcoholica;
    boolean importado;
    boolean comestible;

    LocalDate fechaVencimento;
    short calorias;

    //TODO Si contieneAlcohol = false, automaticamente graduacionAlcoholica = 0
    public Bebida(String id, String nombre, String descripcion, int stock, double precio, double costo, boolean disponible, boolean contieneAlcohol, double graduacionAlcoholica, boolean importado, boolean comestible, LocalDate fechaVencimento, short calorias) {
        super(id, nombre, descripcion, stock, precio, costo, disponible);
        this.contieneAlcohol = contieneAlcohol;
        this.graduacionAlcoholica = graduacionAlcoholica;
        this.importado = importado;
        this.comestible = comestible;
        if (comestible){
            this.fechaVencimento = fechaVencimento;
            this.calorias = calorias;
        } else {
            this.fechaVencimento = null;
            this.calorias = 0;
        }
    }

    //Constructor que define comestible = true por defecto y no necesita recibir dicho valor por parametro
    public Bebida(String id, String nombre, String descripcion, int stock, double precio, double costo, boolean disponible, boolean contieneAlcohol, double graduacionAlcoholica, boolean importado, LocalDate fechaVencimento, short calorias) {
        super(id, nombre, descripcion, stock, precio, costo, disponible);
        this.contieneAlcohol = contieneAlcohol;
        this.graduacionAlcoholica = graduacionAlcoholica;
        this.importado = importado;
        this.comestible = true;
        this.fechaVencimento = fechaVencimento;
        this.calorias = calorias;
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

    public boolean isComestible() {
        return comestible;
    }

    public void setComestible(boolean comestible) {
        this.comestible = comestible;
    }

    //TODO manejar null
    @Override
    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        if(this.isComestible()){
            this.fechaVencimento = fechaVencimiento;
        }  else {
            System.out.println("No es posible asignar fecha de vencimiento a un producto NO comestible!");
        }
    }

    @Override
    public LocalDate getFechaVencimiento() {
        return fechaVencimento;
    }

    @Override
    public void setCalorias(short calorias) {
        if(this.comestible){
            this.calorias = calorias;
        } else {
            System.out.println("No es posible asignar calorias a un producto NO comestible!");
        }
    }

    @Override
    public short getCalorias() {
        return calorias;
    }
}
