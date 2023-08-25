package com.tiendalocal.aplicaciontienda.modelo.productos;

import com.tiendalocal.aplicaciontienda.modelo.productos.enums.TipoEnvase;
import com.tiendalocal.aplicaciontienda.modelo.productos.interfaces.Comestible;
import com.tiendalocal.aplicaciontienda.modelo.productos.interfaces.Descuento;
import com.tiendalocal.aplicaciontienda.modelo.productos.interfaces.Ganancia;

import java.time.LocalDate;

public class ProductoEnvasado extends Producto implements Comestible, Descuento, Ganancia {
    final int DESCUENTO_MAXIMO = 20;
    TipoEnvase tipoEnvase; //enum TipoEnvase (plastico, vidrio o lata)
    boolean importado;
    boolean comestible;

    //Atributos específicos para productos comestibles
    LocalDate fechaVencimento;
    short calorias;

    //Atributos específicos para aplicar descuento
    boolean descuentoAplicado;
    int porcentajeDescuento;
    double precioConDescuento;

    public ProductoEnvasado(String id, String nombre, String descripcion, int stock, double precio, double costo, TipoEnvase tipoEnvase, boolean importado) {
        super(id, nombre, descripcion, stock, precio, costo);
        this.tipoEnvase = tipoEnvase;
        this.importado = importado;
        this.comestible = false;
    }

    //Constructor para Productos comestibles
    public ProductoEnvasado(String id, String nombre, String descripcion, int stock, double precio, double costo, TipoEnvase tipoEnvase, boolean importado, boolean comestible, LocalDate fechaVencimento, short calorias) {
        super(id, nombre, descripcion, stock, precio, costo);
        this.tipoEnvase = tipoEnvase;
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

    public boolean isComestible() {
        return comestible;
    }

    public void setEsComestible(boolean esComestible) {
        this.comestible = esComestible;
    }


    //Metodos sobrescritos de interfaz Comestible
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

    //Metodos de Interfaz Descuento

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
        if (porcentajeDescuento > 0 & porcentajeDescuento < DESCUENTO_MAXIMO){
            System.out.println("Descuento valido");
            System.out.println("Descuento asignado: " + porcentajeDescuento + "%\n");

            this.porcentajeDescuento = porcentajeDescuento;
        } else {
            System.out.println(porcentajeDescuento + "% no es un descuento valido");
        }
    }


    @Override
    public int getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    @Override
    public void setPrecioConDescuento() {

        if (this.porcentajeDescuento <= 0){
            System.out.println("Porcentaje de descuento no valido");
        }

        this.precioConDescuento = precio - (precio * porcentajeDescuento / 100);

        System.out.println("Prueba precio con descuento: " + this.precioConDescuento);

    }

    @Override
    public double getPrecioConDescuento() {
        if (!this.descuentoAplicado){
            System.out.println("No hay descuento aplicado");
            return -1;
        }
        if (this.porcentajeDescuento <= 0){
            System.out.println("Porcentaje de descuento no valido");
            return -1;
        }
        return precioConDescuento;
    }

    @Override
    public double calcularGanancia(double precioCompra, double precioVenta) {

        System.out.println("-----------Calculando ganancia de: " + this.getNombre() + "-----------\n");

        //Se calcula el porcentaje de ganancia usando la fórmula:
        double porcentaje = (precioVenta - precioCompra) * 100 / precioCompra;

        //Si NO es comestible se devuelve el porcentaje de ganancia
        if (!comestible){
            System.out.println("Porcentaje ganancia: %" + porcentaje + "\n");
            return porcentaje;
        }

        //Se verifica si el porcentaje de ganancia supera el 20%
        if (porcentaje > 20) {
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
