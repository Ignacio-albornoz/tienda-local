package com.tiendalocal.aplicaciontienda.modelo.tienda;

import com.tiendalocal.aplicaciontienda.modelo.productos.*;
import com.tiendalocal.aplicaciontienda.modelo.tienda.enums.TipoProducto;
import com.tiendalocal.aplicaciontienda.modelo.tienda.interfaces.ComprarProducto;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Tienda implements ComprarProducto {
    String nombre;
    int maxStock;
    double saldo;
    TipoProducto tipoProducto;
    HashMap<String, TipoProducto> productos;

    public Tienda(String nombre, int maxStock, double saldo) {
        this.nombre = nombre;
        this.maxStock = maxStock;
        this.saldo = saldo;
        this.productos = new HashMap<String, TipoProducto>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMaxStock() {
        return maxStock;
    }

    public void setMaxStock(int maxStock) {
        this.maxStock = maxStock;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void todosLosProductos(ListaProductos listaProductos){
        Stream<String> productoStream = productos.keySet().stream();

        productoStream.forEach(producto -> {
            Producto p = listaProductos.obtenerProductoPorId(producto);
            System.out.println("Nombre: " + p.getNombre() + "ID: " + p.getId());
        });


    }


    public void agregarProducto(String id, ListaProductos listaProductos){
        Producto producto = listaProductos.obtenerProductoPorId(id);

        if (producto instanceof ProductoEnvasado){
            productos.put(id, tipoProducto.ENVASADO);
            return;
        }

        if (producto instanceof Bebida){
            productos.put(id, tipoProducto.BEBIDA);
            return;
        }

        if (producto instanceof ProductoLimpieza){
            productos.put(id, tipoProducto.LIMPIEZA);
        }
    }

    public Stream<String> obtenerIdsDeProductosPorTipo(TipoProducto tipo) {
        //Creamos un stream de ids que contengan el mismo tipo de producto
        Stream<String> ids = productos.entrySet().stream()
                .filter(e -> e.getValue() == tipo)
                .map(Map.Entry::getKey);
        // Mostramos cada clave en la consola usando forEach
        ids.forEach(System.out::println);

        return ids;
    }

    public void obtenerListaDeObjetosEnProductos(TipoProducto tipo, ListaProductos listaProductos) {
        Stream<String> keys = productos.entrySet().stream()
                .filter(e -> e.getValue() == tipo)
                .map(Map.Entry::getKey);
        System.out.println("------------Lista de Productos en Tienda de tipo: " + tipo + " ---------\n");
        //Mostramos los productos disponibles en Tienda con mayor detalle
        keys.forEach((id) -> {
            Producto p = listaProductos.obtenerProductoPorId(id);
            if (p != null){
                System.out.println(p.getNombre() + " " + p.getId());
            }
        });
    }


    public void sumarSaldoPorVenta(double saldoTotalDeVenta){
        saldo += saldoTotalDeVenta;
    }

    public int getStockTotal(ListaProductos listaProductos){

        AtomicInteger stock = new AtomicInteger();
        productos.forEach((id, tipo) -> {
            Integer productoStock = listaProductos.obtenerStock(id);
            if (productoStock != null){
                stock.addAndGet(productoStock);
            } else {
                return;
            }
        });

        return stock.get();
    }


    @Override
    public void comprarProducto(String id, int cantidad, double precio, ListaProductos listaProductos) {
        double importe;
        boolean saldoValido = true;
        boolean stockValido = true;

        System.out.println("\n--------Compra--------\n");

        int stockTotal = getStockTotal(listaProductos);

        System.out.println(
                stockTotal
        );

        importe = calcularImporte(cantidad, precio);
        //Valida saldo suficiente para realizar compra
        if (!verificarSaldo(precio, cantidad, importe)){
            System.out.println("Saldo insuficiente, El producto no podrá ser agregado a la tienda");
            saldoValido = false;
        }
        //Valida se haya alcanzado el stock maximo
        if (!verificarStockMaximo(stockTotal, cantidad)){
            System.out.println("Stock Maximo alcanzado");
            stockValido = false;
        }

        if (!stockValido || !saldoValido){
            System.out.println("\n--------Compra Cancelada--------\n");
            return;
        }

        //Luego de validar, saldo y stock se busca el Producto por id
        Producto producto = listaProductos.obtenerProductoPorId(id);


        //Se evalua si el producto existe
        if (producto == null) {
            System.out.println("No se encontro el producto con id: " + id);
            System.out.println("\n--------Compra Exitosa--------\n");
        } else {
            //Se modifican los atributos stock y precio
            System.out.println("Se encontro el producto, se realizara la actualizacion");
            producto.setStock(producto.getStock() + cantidad);
            producto.setCosto(precio);
            //Se actualiza el saldo
            restarImporte(saldo, importe);
            System.out.println("\n--------Compra Exitosa--------\n");
        }

    }

    @Override
    public double calcularImporte(int cantidad, double precio) {
        double importe = precio * cantidad;
        return importe;
    }

    @Override
    public boolean verificarSaldo(double precio, int cantidad, double importe) {

        if (saldo < importe) {
            return false;
        }
        return true;
    }

    @Override
    public boolean verificarStockMaximo(int stockTotal, int cantidadComprada) {
        System.out.println("Stock Maximo de Tienda: " + maxStock);
        System.out.println("Stock actual: " + stockTotal);
        System.out.println("Cantidad comprada: " + cantidadComprada);
        if (stockTotal + cantidadComprada > maxStock){
            return false;
        }
        return true;
    }

    @Override
    public void restarImporte(double saldo, double importe) {
        this.saldo = saldo - importe;
    }
}
