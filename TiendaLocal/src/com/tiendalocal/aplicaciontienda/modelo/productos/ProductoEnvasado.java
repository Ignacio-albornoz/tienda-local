package com.tiendalocal.aplicaciontienda.modelo.productos;

import com.tiendalocal.aplicaciontienda.modelo.productos.enums.TipoEnvase;
import com.tiendalocal.aplicaciontienda.modelo.productos.interfaces.Comestible;
import com.tiendalocal.aplicaciontienda.modelo.productos.interfaces.Descuento;

import java.time.LocalDate;

public class ProductoEnvasado extends Producto implements Comestible, Descuento {
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

    public ProductoEnvasado(String id, String nombre, String descripcion, int stock, double precio, double costo, boolean disponible, TipoEnvase tipoEnvase, boolean importado, boolean comestible) {
        super(id, nombre, descripcion, stock, precio, costo, disponible);
        this.tipoEnvase = tipoEnvase;
        this.importado = importado;
        this.comestible = comestible;
    }

    public ProductoEnvasado(String id, String nombre, String descripcion, int stock, double precio, double costo, boolean disponible, TipoEnvase tipoEnvase, boolean importado, boolean comestible, LocalDate fechaVencimento, short calorias) {
        super(id, nombre, descripcion, stock, precio, costo, disponible);
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


    //Metodos sobrescritos de la interfaz Comestible

    @Override
    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        //Validamos que el producto sea comestible
        if(this.isComestible()){
            this.fechaVencimento = fechaVencimiento;
        }  else {
            System.out.println("No es posible asignar fecha de vencimiento a un producto NO comestible!");
        }
    }

    //TODO manejar null
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

    //TODO Si estadoDelDescuento = true && porcentajeDescuento, se ejecuta setPrecioConDescuento
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
            System.out.println("Prueba precio con descuento: " + this.precioConDescuento);
        }
    }

    @Override
    public double getPrecioConDescuento() {
        return precioConDescuento;
    }
}
