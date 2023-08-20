package com.tiendalocal.aplicaciontienda.modelo.productos;

import com.tiendalocal.aplicaciontienda.modelo.productos.interfaces.Comestible;

import java.time.LocalDate;

public class Bebida extends Producto implements Comestible {
    boolean contieneAlcohol;
    double graduacionAlcoholica;
    boolean importado;
    boolean comestible;

    // Atributos específicos de los productos comestibles
    LocalDate fechaVencimento;
    short calorias;

    //TODO analizar verificacion, si contieneAlcohol = true && graduacionAlcoholica <= 0, significa contieneAlcohol = false?
    public Bebida(String id, String nombre, String descripcion, int stock, double precio, double costo, boolean disponible, boolean contieneAlcohol, double graduacionAlcoholica, boolean importado, boolean comestible, LocalDate fechaVencimento, short calorias) {
        super(id, nombre, descripcion, stock, precio, costo, disponible);
        this.contieneAlcohol = contieneAlcohol;
        //Si contieneAlcohol = true, se le asigna la graduacion
        if (contieneAlcohol){
            this.graduacionAlcoholica = graduacionAlcoholica;
        }else{
            this.graduacionAlcoholica = 0;
        }
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

    //Se valida contieneAlcohol = true, antes de cargar graduacionAlcoholica
    public void setGraduacionAlcoholica(double graduacionAlcoholica) {
        if (contieneAlcohol && graduacionAlcoholica > 0){
            this.graduacionAlcoholica = graduacionAlcoholica;
        } else {
            //Si contieneAlcohol = false || graduacionAlcoholica <= 0. se asigna 0
            this.graduacionAlcoholica = 0;
        }
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

    //Metodos sobrescritos de la interfaz Comestible
    //TODO manejar null
    @Override
    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        //Validamos que el producto sea comestible
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
        //Validamos que el producto sea comestible
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
