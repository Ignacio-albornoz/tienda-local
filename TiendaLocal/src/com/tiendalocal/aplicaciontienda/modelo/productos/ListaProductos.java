package com.tiendalocal.aplicaciontienda.modelo.productos;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListaProductos {
    HashMap<String, Producto> listaProductos = new HashMap();

    public Producto obtenerProductoPorId(String id) {
        Producto producto = listaProductos.get(id);
        if (producto != null) {
            return producto;
        }
        System.out.println("El producto con id: " + id + " NO se encontro");
        return null;
    }


    public void agregarProducto(Producto producto) {
        Producto p = listaProductos.get(producto.getId());
        if (p == null) {
            listaProductos.put(producto.getId(), producto);
        } else {
            System.out.println("El producto que se intenta agregar ya existe!");
        }
    }

    public void modificiarProducto(Producto producto) {
        Producto p = obtenerProductoPorId(producto.getId());
        if (p == null) {
            System.out.println("El producto que se intenta modificar NO existe!");
        } else {
            listaProductos.replace(p.getId(), producto);
        }
    }

    public void borrarProducto(String id) {
        listaProductos.remove(id);
    }

    public void modificarPrecio(String id, double precio) {
        Producto p = obtenerProductoPorId(id);
        p.setPrecio(precio);
    }

    public void sumarStock(String id, int stock) {
        Producto p = obtenerProductoPorId(id);
        p.setStock(p.getStock() + stock);
    }

    public void restarStock(String id, int stock) {
        Producto p = obtenerProductoPorId(id);
        p.setStock(p.getStock() - stock);
    }

    public Integer obtenerStock(String id) {
        Producto producto = listaProductos.get(id);
        if (producto != null) {
            return producto.getStock();
        }
        System.out.println("El producto con id: " + id + " NO se encontro");
        return null;
    }


    public void imprimirListaDeProductosConGananciaIncorrecta(){
        Stream<Producto> streamProductos = listaProductos.values().stream();
        Stream<Producto> streamFiltrado = streamProductos.filter(p -> {
            boolean b = p.calcularGanancia(p.getCosto(), p.getPrecio()) < 0;
            return b;
        });
        streamFiltrado.forEach(k -> {
            System.out.println("Este producto necesita ser modificado para poder ser vendido\n");
            System.out.println(k.toString());
        });
    }

    public void obtenerComestibleConMenorDescuento(int porcentajeDescuento){
        Stream<Producto> streamProductos = listaProductos.values().stream();

        //Se incluyen solo los productos que tengan un descuento menor que el porcentaje dado
        Stream<Producto> streamFiltradoPorPorcentajeDescuento = streamProductos.filter(p -> p.getPorcentajeDescuento() < porcentajeDescuento);

        Stream<Producto> streamProductos2 = listaProductos.values().stream();

        //Se incluyen solo los productos que tengan un descuento menor que el porcentaje dado
        Stream<Producto> streamFiltradoPorPorcentajeDescuento2 = streamProductos2.filter(p -> p.getPorcentajeDescuento() < porcentajeDescuento);


        //Se filtra el stream por la clase Bebida y se hace un cast a Bebida
        Stream<ProductoEnvasado> streamFiltradoClaseEnvasados = streamFiltradoPorPorcentajeDescuento2.filter(producto -> producto instanceof ProductoEnvasado).map(producto -> (ProductoEnvasado) producto);

        Stream<ProductoEnvasado> streamFiltradoComestibleEnvasado = streamFiltradoClaseEnvasados.filter(envasado -> envasado.comestible);

        Stream<ProductoEnvasado> streamEnvdadosOrdenadoPrecio = streamFiltradoComestibleEnvasado.sorted(Comparator.comparingDouble(envasado -> envasado.precio));


        //Filtros para Bebidas
        Stream<Bebida> streamFiltradoClaseBebida = streamFiltradoPorPorcentajeDescuento.filter(producto -> producto instanceof Bebida).map(producto -> (Bebida) producto);

        Stream<Bebida> streamFiltradoImportado = streamFiltradoClaseBebida.filter(bebida -> !bebida.importado);

        Stream<Bebida> streamFiltradoComestibleBebida = streamFiltradoImportado.filter(bebida -> bebida.comestible == true);


        Stream<Bebida> streamBebidasOrdenadoPrecio = streamFiltradoComestibleBebida.sorted(Comparator.comparingDouble(bebida -> bebida.precio));

        System.out.println("\n-------------------Bebidas, comestibles y no importadas con menor descuento a: " + porcentajeDescuento + "% -------------------\n");

        streamBebidasOrdenadoPrecio.forEach(bebida -> {
            System.out.println("Producto " + bebida.nombre + " " + bebida.descripcion.toUpperCase() + ", $" + bebida.precio + ", comestible: " + bebida.comestible + " importado: " + bebida.importado + ", descuento: " + bebida.porcentajeDescuento + "%\n");
        });

        System.out.println("-------------------Productos Envasados, comestibles con menor descuento a: " + porcentajeDescuento + "% -------------------\n");





        streamEnvdadosOrdenadoPrecio.forEach(envasado -> {
            System.out.println("Producto " + envasado.nombre + " " + envasado.descripcion.toUpperCase() + ", $" + envasado.precio + ", comestible: " + envasado.comestible + ", descuento: " + envasado.porcentajeDescuento + "%\n");

        });
    }

    public List<Producto> listarProductosConUtilidadesInferiores(double porcentaje_utilidad) {
        //Se crea un stream de la lista o el mapa de productos
        Stream<Producto> streamProductos = listaProductos.values().stream();

        //Se filtra el stream usando el método calcularGanancia de la interfaz Precio
        //Se incluyen solo los productos que tengan una ganancia menor que el porcentaje dado
        Stream<Producto> streamFiltrado = streamProductos.filter(p -> p.calcularGanancia(p.getCosto(), p.getPrecio()) < porcentaje_utilidad);

        //Se convierte el stream filtrado en una lista y se devuelve como resultado
        return streamFiltrado.collect(Collectors.toList());
    }

}
