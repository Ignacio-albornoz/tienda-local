package com.tiendalocal.aplicaciontienda.modelo.tienda;

import com.tiendalocal.aplicaciontienda.modelo.productos.ListaProductos;
import com.tiendalocal.aplicaciontienda.modelo.productos.Producto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Venta {
    final int CANTIDAD_MAXIMA_DE_PRODUCTOS = 10;
    final int CANTIDAD_MAXIMA_DE_PRODUCTOS_EN_CARRITO = 3;
    HashMap<String, Integer> carrito = new HashMap<>();
    double precioTotal;

    public Venta() {
        this.precioTotal = 0;
        this.carrito = new HashMap<String, Integer>();
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public boolean validarCantidad(int cantidad){
        if (cantidad > 0 && cantidad <= CANTIDAD_MAXIMA_DE_PRODUCTOS){
            return true;
        }
        System.out.println("Se agrego una cantidad de productos no valida. Recuerda agregar menos de " + CANTIDAD_MAXIMA_DE_PRODUCTOS + " productos iguales");
        return false;
    }

    public boolean validarCantidadDeProductosEnElCarrito(){
        if (carrito.size() <= 2){
            return true;
        }
        System.out.println("Se llego al limite de productos en el carrito. \n¡Recuerda el limite de productos es: " + CANTIDAD_MAXIMA_DE_PRODUCTOS_EN_CARRITO + "!");
        return false;
    }

    public double calcularImporte(int cantidad, double precioDelProducto){
        return cantidad * precioDelProducto;
    }

    public void agregarProductoAlCarrito(Producto producto, int cantidad){
        System.out.println("\n");
        System.out.println("Nueva venta:");
        System.out.println("--------------------------------------------");
        System.out.println("\n");

        double importe;
        double precioPromocional = 0;
        boolean cantidadDeProductosCorrecta = true;
        boolean cantidadDeProductosEnElCarritoCorrecta = true;

        if (producto.getStock() <= 0){
            return;
        }

        //Se verifica el producto este disponible
        if (!producto.isDisponible()){
            System.out.println("El producto: " + producto.getNombre() + " no se encuentra disponible!");
            return;
        }

        //Se verifica la cantidad obtenida por parametros, sea valida
        if (!validarCantidad(cantidad)){
            cantidadDeProductosCorrecta = false;
        }

        //Se verifica la cantidad de productos en el carro se valida
        if (!validarCantidadDeProductosEnElCarrito()){
            cantidadDeProductosEnElCarritoCorrecta = false;
        }


        if (!cantidadDeProductosCorrecta || !cantidadDeProductosEnElCarritoCorrecta){
            return;
        }

        if (producto.getEstadoDelDescuento() & producto.getPrecioConDescuento() > 0){

            precioPromocional = producto.getPrecioConDescuento();

        }

        //Se verifica si la cantidad es menor, mayor o igual al stock del producto
        if (cantidad <= producto.getStock()){


            //Se calcula el importe
            if (precioPromocional > 0){
                importe = calcularImporte(cantidad, producto.getPrecioConDescuento());
            } else {
                importe = calcularImporte(cantidad, producto.getPrecio());
            }


            //Se agrega el producto al carrito
            carrito.put(producto.getId(), cantidad);

            //Se suma el importe al precio total
            precioTotal += importe;

            System.out.println("El producto " + producto.getNombre() + " se agrego al carrito!");
        } else {
            //Se agrega la cantidad de stock disponible
            carrito.put(producto.getId(), producto.getStock());

            //Se calcula el importe
            if (precioPromocional > 0){
                importe = calcularImporte(cantidad, producto.getPrecioConDescuento());
            } else {
                importe = calcularImporte(cantidad, producto.getPrecio());
            }
            //Se suma el importe al precio total
            precioTotal += importe;

            System.out.println("El producto " + producto.getNombre()  + ", ID: "+ producto.getId() + "\nTiene stock disponible menor al solicitado");
            System.out.println("Se agregaron: " + producto.getStock() + " unidades de " + producto.getNombre());
            System.out.println("\n");
            System.out.println("--------------------------------------------");
        }

    }


    public void finalizarCompra(Tienda tienda, ListaProductos listaProductos){
        //Se imprime el detalle antes de finalizar la compra
        imprimirDetalle(listaProductos);
        //Se suma la venta total al saldo
        tienda.sumarSaldoPorVenta(precioTotal);


        //Se buscan los productos que deben ser actualizados
        carrito.forEach((id, cantidad) -> {
            listaProductos.restarStock(id, cantidad);
        });

        //Se vacia el carrito
        limpiarCarrito();
        //Precio total igual 0
        precioTotal = 0;
    }

    public void limpiarCarrito(){
        carrito.clear();
    }

    public void imprimirDetalle(ListaProductos listaProductos){
        if (carrito.size() == 0){
            System.out.println("--------------------------------------------");
            System.out.println("Su carrito esta vacio!");
            System.out.println("\n");
            return;
        }

        carrito.forEach((id, cantidad) -> {
            Producto producto = listaProductos.obtenerProductoPorId(id);
            if (producto.getEstadoDelDescuento()){
                System.out.println("--------------------------------------------");
                System.out.println("El articulo se encuentra en descuento");
                System.out.println(producto.getId() + " " + producto.getNombre() + " " + cantidad + " x $" + producto.getPrecio() + " = $" + ( cantidad * producto.getPrecioConDescuento()));
                System.out.println("\n");
            }else {
                System.out.println("\n");
                System.out.println(producto.getId() + " " + producto.getNombre() + " " + cantidad + " x $" + producto.getPrecio() + " = $" + ( cantidad * producto.getPrecio()));
                System.out.println("--------------------------------------------");
            }
        });
        System.out.println("TOTAL VENTA: $" + precioTotal);
        System.out.println("--------------------------------------------");

    }
}


