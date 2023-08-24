package com.tiendalocal.aplicaciontienda.modelo.tienda;

import com.tiendalocal.aplicaciontienda.modelo.productos.Producto;
import com.tiendalocal.aplicaciontienda.modelo.tienda.interfaces.ComprarProducto;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class Tienda implements ComprarProducto {
    String nombre;
    int maxStock;
    double saldo;
    HashMap<String, ArrayList<Producto>> productos;

    public Tienda(String nombre, int maxStock, double saldo) {
        this.nombre = nombre;
        this.maxStock = maxStock;
        this.saldo = saldo;
        this.productos = new HashMap<String, ArrayList<Producto>>();
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

    public HashMap<String, ArrayList<Producto>> getProductos() {
        return productos;
    }

    public void setProductos(String tipo, Producto producto) {
        this.productos = productos;
    }


    //TODO agregar productos y agregar listas son metodos diferentes. Ver con enums de tipos y switch
    public void agregarProducto(String tipo, Producto producto){
        ArrayList lista = productos.get(tipo);

        if(lista == null) {
            lista = new ArrayList<Producto>();
            productos.put(tipo, lista);
        }

        lista.add(producto);
    }


    public Producto buscarProducto(String tipo, String id){
        ArrayList<Producto> lista = productos.get(tipo);

        if (lista != null) {
            for (Producto p : lista) {
                if (p.getId().equals(id)) {
                    System.out.println("Id de Producto: " + p.getId());
                    System.out.println("Id Parametro: " + id);
                    System.out.println("El producto buscado: " + p.getNombre());
                    return p;
                }
            }
        }
        System.out.println("No se encontro producto, con id: " + id);
        return null;
    }

    public void sumarSaldoPorVenta(double saldoTotalDeVenta){
        saldo += saldoTotalDeVenta;
    }


    //TODO Hacer con lambda y streams
    public int getStockTotal(){
        int stock = 0;

        for (String tipo : productos.keySet()) {
            ArrayList<Producto> lista = productos.get(tipo);
            for(Producto p : lista) {
                stock += p.getStock();
            }
        }
        return stock;
    }


    @Override
    public void comprarProducto(String tipo, String id, int cantidad, double precio) {
        double importe;
        int stockTotal = getStockTotal();
        importe = calcularImporte(cantidad, precio);
        //Valida saldo suficiente para realizar compra
        if (!verificarSaldo(precio, cantidad, importe)){
            System.out.println("Saldo insuficiente, El producto no podrá ser agregado a la tienda");
            return;
        }
        //Valida se haya alcanzado el stock maximo
        if (!verificarStockMaximo(stockTotal, cantidad)){
            System.out.println("Stock Maximo alcanzado");
            return;
        }

        //Luego de validar, saldo y stock se busca el Producto por id
        Producto producto = buscarProducto(tipo, id);

        //Se evalua si el producto existe
        if (producto == null) {
            System.out.println("No se encontro el producto con id: " + id);
        } else {
            //Se modifican los atributos stock y precio
            System.out.println("Se encontro el producto, se realizara la actualizacion");
            producto.setStock(producto.getStock() + cantidad);
            producto.setCosto(precio);
            //Se actualiza el saldo
            restarImporte(saldo, importe);
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
