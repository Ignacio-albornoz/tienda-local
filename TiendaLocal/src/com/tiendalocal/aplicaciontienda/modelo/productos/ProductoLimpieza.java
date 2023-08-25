package com.tiendalocal.aplicaciontienda.modelo.productos;

import com.tiendalocal.aplicaciontienda.modelo.productos.enums.TipoAplicacion;
import com.tiendalocal.aplicaciontienda.modelo.productos.interfaces.Descuento;
import com.tiendalocal.aplicaciontienda.modelo.productos.interfaces.Ganancia;

public class ProductoLimpieza extends Producto implements Descuento, Ganancia {
    final int DESCUENTO_MAXIMO = 25;
    TipoAplicacion tipoAplicacion;
    boolean descuentoAplicado;
    int porcentajeDescuento;
    double precioConDescuento;

    public ProductoLimpieza(String id, String nombre, String descripcion, int stock, double precio, double costo, boolean disponible, TipoAplicacion tipoAplicacion) {
        super(id, nombre, descripcion, stock, precio, costo);
        this.tipoAplicacion = tipoAplicacion;
    }

    public TipoAplicacion getTipoAplicacion() {
        return tipoAplicacion;
    }

    public void setTipoAplicacion(TipoAplicacion tipoAplicacion) {
        this.tipoAplicacion = tipoAplicacion;
    }

    //Metodos de Interfaz Descuento

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
    public int getPorcentajeDescuento() {
        return porcentajeDescuento;
    }
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
    public void setPrecioConDescuento() {

        if (!this.descuentoAplicado){
            System.out.println("No hay descuento aplicado");
        }
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
        }
        if (this.porcentajeDescuento <= 0){
            System.out.println("Porcentaje de descuento no valido");
        }
        return precioConDescuento;
    }

    @Override
    public double calcularGanancia(double precioCompra, double precioVenta) {

        System.out.println("-----------Calculando ganancia de: " + this.getNombre() + "-----------\n");

        //Se calcula el porcentaje de ganancia usando la formula:
        double porcentaje = (precioVenta - precioCompra) * 100 / precioCompra;

        //Se verifica si el producto es de tipo ROPA o MULTIUSO
        if (this.getTipoAplicacion().equals("ROPA") || this.getTipoAplicacion().equals("MULTIUSO")) {
            //Se verifica si el porcentaje de ganancia supera el 25%
            if (porcentaje > 25) {

                System.out.println("El porcentaje de ganancia de un producto de limpieza no puede superar el 25%");

                System.out.println("El producto no estara disponible para la venta!");

                System.out.println("Porcentaje ganancia: %" + porcentaje + "\n");

                this.setDisponible(false);
                return -1;
            } else {
                //Se devuelve el porcentaje de ganancia calculado
                return porcentaje;
            }
        } else {
            //Se verifica si el porcentaje de ganancia esta entre el 10% y el 25%
            if (porcentaje >= 10 && porcentaje <= 25) {
                //Se devuelve el porcentaje de ganancia calculado
                return porcentaje;
            } else {
                System.out.println("El porcentaje de ganancia de un producto de limpieza debe estar entre el 10% y el 25%");

                System.out.println("El producto no estara disponible para la venta!");

                System.out.println("Porcentaje ganancia: %" + porcentaje + "\n");

                this.setDisponible(false);
                return -1;
            }
        }
    }
}
