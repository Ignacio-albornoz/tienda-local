package com.tiendalocal.aplicaciontienda.modelo.productos;

import com.tiendalocal.aplicaciontienda.modelo.productos.enums.TipoAplicacion;
import com.tiendalocal.aplicaciontienda.modelo.productos.interfaces.Descuento;
import com.tiendalocal.aplicaciontienda.modelo.productos.interfaces.Ganancia;

public class ProductoLimpieza extends Producto implements Descuento, Ganancia {
    final int DESCUENTO_MAXIMO = 25;
    TipoAplicacion tipoAplicacion;

    public ProductoLimpieza(String id, String nombre, String descripcion, int stock, double precio, double costo, TipoAplicacion tipoAplicacion) {
        super(id, nombre, descripcion, stock, precio, costo);
        this.tipoAplicacion = tipoAplicacion;
    }

    public TipoAplicacion getTipoAplicacion() {
        return tipoAplicacion;
    }

    public void setTipoAplicacion(TipoAplicacion tipoAplicacion) {
        this.tipoAplicacion = tipoAplicacion;
    }

    public int getDESCUENTO_MAXIMO() {
        return DESCUENTO_MAXIMO;
    }

    @Override
    public void aplicarDescuento(int porcentajeD) {
        if (!validarDescuento(porcentajeD, DESCUENTO_MAXIMO)){
            System.out.println("Descuento para el producto: " + nombre + " ID: " + id + " no pudo ser aplicado!\n");
            return;
        }


        if(!validarPrecioConDescuento(porcentajeD)){
            System.out.println("Descuento para el producto: " + nombre + " ID: " + id + " no pudo ser aplicado!\n");
            return;
        }

        //Una vez validado el porcentaja y precio seteamos los valores
        setPorcentajeDescuento(porcentajeD);
        setPrecioConDescuento();
        setEstadoDelDescuento(true);

        //mostramos productos despues del cambio
        System.out.println("Producto: " + nombre + ", Precio: " + precio + ", Descuento: " + descuentoAplicado + ", Precio Promocional: " + precioConDescuento + ", Descuento del %" + porcentajeDescuento);
        System.out.println("");
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

    @Override
    public String toString() {
        return "ProductoLimpieza" +
                ", id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", stock=" + stock +
                ", precio=" + precio;
    }
}
