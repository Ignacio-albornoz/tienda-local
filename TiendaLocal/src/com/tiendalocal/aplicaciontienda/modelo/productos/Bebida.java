package com.tiendalocal.aplicaciontienda.modelo.productos;

import com.tiendalocal.aplicaciontienda.modelo.productos.interfaces.Comestible;
import com.tiendalocal.aplicaciontienda.modelo.productos.interfaces.Ganancia;

import java.time.LocalDate;

public class Bebida extends Producto implements Comestible, Ganancia {
    final int DESCUENTO_MAXIMO = 15;
    boolean contieneAlcohol;
    double graduacionAlcoholica;
    boolean importado;
    boolean comestible;

    // Atributos específicos de los productos comestibles
    LocalDate fechaVencimento;
    short calorias;

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

    //Metodos de Interfaz Descuento
    @Override
    public void aplicarDescuento(int porcentajeDescuento) {
        if (!validarDescuento(porcentajeDescuento, DESCUENTO_MAXIMO)){
            System.out.println("Descuento para el producto: " + nombre + " ID: " + id + " no pudo ser aplicado!\n");
            return;
        }


        if(!validarPrecioConDescuento(porcentajeDescuento)){
            System.out.println("Descuento para el producto: " + nombre + " ID: " + id + " no pudo ser aplicado!\n");
            return;
        }

        //Una vez validado el porcentaja y precio seteamos los valores
        setPorcentajeDescuento(porcentajeDescuento);
        setPrecioConDescuento();
        setEstadoDelDescuento(true);

        //mostramos productos despues del cambio
        System.out.println("Producto: " + nombre + ", Precio: " + precio + ", Descuento: " + descuentoAplicado + ", Precio Promocional: " + precioConDescuento + ", Descuento del %" + porcentajeDescuento);
        System.out.println("");
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

    @Override
    public String toString() {
        return "Bebida{" +
                "contieneAlcohol=" + contieneAlcohol +
                ", graduacionAlcoholica=" + graduacionAlcoholica +
                ", importado=" + importado +
                ", comestible=" + comestible +
                ", fechaVencimento=" + fechaVencimento +
                ", calorias=" + calorias +
                ", id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", stock=" + stock +
                ", precio=" + precio +
                ", costo=" + costo +
                ", disponible=" + disponible +
                ", descuentoAplicado=" + descuentoAplicado +
                ", porcentajeDescuento=" + porcentajeDescuento +
                ", precioConDescuento=" + precioConDescuento +
                '}';
    }
}
