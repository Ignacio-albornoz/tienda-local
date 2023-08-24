package com.tiendalocal.aplicaciontienda.modelo.productos;

import java.util.HashMap;

public class ListaProductos {
    HashMap<String, Producto> listaProductos = new HashMap();

    public Producto obtenerProductoPorId(String id) {
        Producto producto = listaProductos.get(id);
        if (producto != null){
            return producto;
        }
        System.out.println("El producto con id: " + id + " NO se encontro");
        return null;
    }

    public void agregarProducto(Producto producto){
        Producto p = listaProductos.get(producto.getId());
        if (p == null){
            listaProductos.put(producto.getId(), producto);
        } else {
            System.out.println("El producto que se intenta agregar ya existe!");
        }
    }

    public void modificiarProducto(Producto producto){
        Producto p = obtenerProductoPorId(producto.getId());
        if (p == null){
            System.out.println("El producto que se intenta modificar NO existe!");
        } else {
            listaProductos.replace(p.getId(), producto);
        }
    }

    public void borrarProducto(String id){
        listaProductos.remove(id);
    }

    public void modificarPrecio(String id, double precio){
        Producto p = obtenerProductoPorId(id);
        p.setPrecio(precio);
    }

    public void sumarStock(String id, int stock){
        Producto p = obtenerProductoPorId(id);
        p.setStock(p.getStock() + stock);
    }

    public void restarStock(String id, int stock){
        Producto p = obtenerProductoPorId(id);
        p.setStock(p.getStock() - stock);
    }


}
