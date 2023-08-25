package com.tiendalocal.aplicaciontienda.modelo.productos;

import com.tiendalocal.aplicaciontienda.modelo.productos.interfaces.Comestible;
import com.tiendalocal.aplicaciontienda.modelo.productos.interfaces.Descuento;
import com.tiendalocal.aplicaciontienda.modelo.productos.interfaces.Ganancia;

import java.time.LocalDate;

public class Bebida extends Producto implements Comestible, Descuento, Ganancia {
    boolean contieneAlcohol;
    double graduacionAlcoholica;
    boolean importado;
    boolean comestible;

    // Atributos específicos de los productos comestibles
    LocalDate fechaVencimento;
    short calorias;

    boolean descuentoAplicado;
    int porcentajeDescuento;
    double precioConDescuento;

    //TODO analizar verificacion, si contieneAlcohol = true && graduacionAlcoholica <= 0, significa contieneAlcohol = false?
    public Bebida(String id, String nombre, String descripcion, int stock, double precio, double costo, boolean contieneAlcohol, double graduacionAlcoholica, boolean importado, boolean comestible, LocalDate fechaVencimento, short calorias) {
        super(id, nombre, descripcion, stock, precio, costo);
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

    @Override
    public void aplicarDescuento(int porcentajeDescuento) {
        setPorcentajeDescuento(porcentajeDescuento);
        if (getPorcentajeDescuento() < 0 ){
            return;
        }
        setPrecioConDescuento();
        if(getPrecioConDescuento() < 0){
            return;
        }
        setEstadoDelDescuento(true);
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
        }
    }

    @Override
    public double getPrecioConDescuento() {
        return precioConDescuento;
    }

    @Override
    public double calcularGanancia(double precioCompra, double precioVenta) {

        System.out.println("-----------Calculando ganancia de: " + this.getNombre() + "-----------\n");

        //Se calcula el porcentaje de ganancia usando la fórmula:
        double porcentaje = (precioVenta - precioCompra) * 100 / precioCompra;

        //Si NO es comestible se devuelve el porcentaje de ganancia
        if (!comestible){
            System.out.println("Ganancia validad, no es comestible");
            System.out.println("Porcentaje ganancia: %" + porcentaje + "\n");
            return porcentaje;
        }

        //Se verifica si el porcentaje de ganancia supera el 20%
        if (porcentaje > 20 & comestible) {
            System.out.println("El porcentaje de ganancia de un producto comestible no puede superar el 20%");

            System.out.println("El producto no estara disponible para la venta!");

            System.out.println("Porcentaje ganancia: %" + porcentaje + "\n");
            this.setDisponible(false);
            return -1;

        } else {

            //Se devuelve el porcentaje de ganancia calculado
            System.out.println("Porcentaje ganancia: %" + porcentaje + "\n");
            return porcentaje;
        }
    }
}
