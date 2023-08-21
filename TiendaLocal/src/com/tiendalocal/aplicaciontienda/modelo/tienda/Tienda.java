package com.tiendalocal.aplicaciontienda.modelo.tienda;

import com.tiendalocal.aplicaciontienda.modelo.productos.Producto;
import com.tiendalocal.aplicaciontienda.modelo.tienda.interfaces.ComprarProducto;

import java.util.ArrayList;
import java.util.HashMap;

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

    public void setProductos(HashMap<String, ArrayList<Producto>> productos) {
        this.productos = productos;
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
        if (!verificarSaldo(precio, cantidad, importe)){
            System.out.println("Saldo insuficiente, El producto no podrá ser agregado a la tienda");
            return;
        }
        if (!verificarStockMaximo(stockTotal, cantidad)){
            System.out.println("Stock Maximo alcanzado");
            return;
        }

        /* AQUI DEBERIA AGREGARSE EL PRODUCTO O MODIFICARSE */

        restarImporte(saldo, importe);

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
