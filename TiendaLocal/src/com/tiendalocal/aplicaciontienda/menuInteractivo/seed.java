package com.tiendalocal.aplicaciontienda.menuInteractivo;

import com.tiendalocal.aplicaciontienda.modelo.productos.*;
import com.tiendalocal.aplicaciontienda.modelo.productos.enums.TipoAplicacion;
import com.tiendalocal.aplicaciontienda.modelo.productos.enums.TipoEnvase;
import com.tiendalocal.aplicaciontienda.modelo.tienda.Tienda;
import com.tiendalocal.aplicaciontienda.modelo.tienda.Venta;
import com.tiendalocal.aplicaciontienda.modelo.tienda.enums.TipoProducto;

import java.time.LocalDate;
import java.util.List;

public class seed {
    public static void main(String[] args, Tienda tienda, Venta venta1, ListaProductos listaProductos, boolean seEjecuto) {

        if (seEjecuto){
            System.out.println("\n");
            System.out.println("Ya se ejecuto!");
            System.out.println("\n");
            return;
        }
        System.out.println("Aplicacion para tienda local en proceso!");

        LocalDate vencimiento = LocalDate.of(2023, 11, 11);
        LocalDate vencimiento1 = LocalDate.of(2024, 9, 21);
        LocalDate vencimiento2 = LocalDate.of(2023, 1, 15);
        LocalDate vencimiento3 = LocalDate.of(2025, 12, 24);
        LocalDate vencimiento4 = LocalDate.of(2024, 05, 31);


        ProductoEnvasado prdEnvasado2 = new ProductoEnvasado("AB001", "Vela aromatica en envase de vidrio comestible", "vela aromatica en envase poco seguro, convencional y muy rica", 12, 43.99, 39.99, TipoEnvase.PLASTICO ,false, true, vencimiento2 , (short) 1287);

        Bebida cerveza = new Bebida("AC111", "Cerveza Patagonia", "cerveza realizada en algun lugar", 2, 399.50, 201.21, true, 5.7,true, false, vencimiento1, (short) 450);

        Bebida cervezaSinAlcohol = new Bebida("AC112", "Cerveza Patagonia Sin Alcohol", "no recomendada para consumo", 2, 399.50, 201.21, true, 5.7,false,  false, vencimiento, (short) 450);


        // Creamos 10 productos con diferentes tipos y atributos
        ProductoEnvasado galletitas = new ProductoEnvasado("AB222", "Galletitas Oreo", "contiene gluten y lactosa", 3, 99.90, 50.00, TipoEnvase.PLASTICO, false, true, vencimiento3, (short) 300);
        Bebida jugoNaranja = new Bebida("AC123", "Jugo de Naranja Cepita", "fuente de vitamina C", 1, 59.90, 20.00, false, 0, true, true, vencimiento4, (short) 200);
        ProductoLimpieza detergente = new ProductoLimpieza("AZ111", "Detergente Magistral", "limpia y desinfecta", 2, 149.90, 100.00, TipoAplicacion.COCINA);
        ProductoEnvasado arroz = new ProductoEnvasado("AB211", "Arroz Gallo Oro", "sin TACC", 3, 79.90, 40.00, TipoEnvase.PLASTICO, false, true, vencimiento, (short) 1000);
        Bebida leche = new Bebida("AC212", "Leche La Serenísima", "contiene calcio y proteínas", 1, 89.90, 30.00, true, 1.0, false, true, vencimiento, (short) 250);
        ProductoLimpieza jabon = new ProductoLimpieza("AZ232", "Jabón Dove", "cuida tu piel", 2, 69.90, 35.00, TipoAplicacion.MULTIUSO);
        ProductoEnvasado fideos = new ProductoEnvasado("AB121", "Fideos Matarazzo", "contiene gluten", 3 ,99.90 ,45.00 , TipoEnvase.LATA ,false , true ,vencimiento ,(short)500);
        Bebida aguaMineral = new Bebida("AC444", "Agua Mineral Villavicencio", "sin gas y sin sodio",1 ,49.90 ,15.00 ,false ,2.0 ,false ,false ,vencimiento ,(short)2000);
        ProductoLimpieza lavandina = new ProductoLimpieza("AZ311", "Lavandina Ayudín", "elimina el 99% de los gérmenes",2 ,119.90 ,60.00 ,TipoAplicacion.MULTIUSO);
        ProductoEnvasado yerba = new ProductoEnvasado("AB333", "Yerba Taragui", "sabor intenso y duradero",3 ,199.90 ,80.00 , TipoEnvase.PLASTICO ,false ,true ,vencimiento3 ,(short)300);


        listaProductos.agregarProducto(galletitas);
        listaProductos.agregarProducto(jugoNaranja);
        listaProductos.agregarProducto(detergente);
        listaProductos.agregarProducto(arroz);
        listaProductos.agregarProducto(leche);
        listaProductos.agregarProducto(jabon);
        listaProductos.agregarProducto(fideos);
        listaProductos.agregarProducto(aguaMineral);
        listaProductos.agregarProducto(lavandina);
        listaProductos.agregarProducto(yerba);
        listaProductos.agregarProducto(cerveza);
        listaProductos.agregarProducto(cervezaSinAlcohol);
        listaProductos.agregarProducto(prdEnvasado2);


        tienda.agregarProducto("AB112", listaProductos);
        tienda.agregarProducto("AB111", listaProductos);
        tienda.agregarProducto("AC111", listaProductos);
        tienda.agregarProducto("AC112", listaProductos);
        tienda.agregarProducto("AB222", listaProductos);
        tienda.agregarProducto("AC123", listaProductos);
        tienda.agregarProducto("AZ111", listaProductos);
        tienda.agregarProducto("AB211", listaProductos);
        tienda.agregarProducto("AC212", listaProductos);
        tienda.agregarProducto("AZ232", listaProductos);
        tienda.agregarProducto("AB121", listaProductos);
        tienda.agregarProducto("AC444", listaProductos);
        tienda.agregarProducto("AZ311", listaProductos);
        tienda.agregarProducto("AB333", listaProductos);
        System.out.println("-------------APLICANDO DESCUENTOS------------------------\n");

        Producto aguaMineral2 = listaProductos.obtenerProductoPorId("AC444");

        aguaMineral2.aplicarDescuento(15);

        System.out.println(aguaMineral);

        aguaMineral2.aplicarDescuento(100);

        System.out.println(aguaMineral);

        aguaMineral.aplicarDescuento(40);

        System.out.println(aguaMineral);


        System.out.println("-------------LIsta de productos con Ganancias Incorrectas------------------------\n");

        System.out.println("");
        System.out.println("");

        System.out.println("IDS bebibas en tienda: ");
        tienda.obtenerIdsDeProductosPorTipo(TipoProducto.BEBIDA);
        System.out.println("");
        tienda.obtenerListaDeObjetosEnProductos(TipoProducto.BEBIDA, listaProductos);
        Producto p = listaProductos.obtenerProductoPorId("AC111");

        System.out.println("costo ANTES comprar: " + p.getCosto());
        System.out.println("stock ANTES comprar: " + p.getStock() + "\n");

        System.out.println("-------------");
        System.out.println("Pruebas de compras");
        //Saldo Insuficiente
        tienda.comprarProducto("AB112", 130,205.50, listaProductos);
        System.out.println("\n");
        //Stock maximo alcanzado
        tienda.comprarProducto("AB112", 130,1.50, listaProductos);
        System.out.println("\n");
        //Compra valida
        tienda.comprarProducto("AB112", 8,205.50, listaProductos);

        System.out.println("costo DESPUES comprar: " + p.getCosto());
        System.out.println("stock DESPUES comprar: " + p.getStock());
        System.out.println("\n");
        /* -------------- Despues de Comprar -------------*/
        /*
        System.out.println("-------------- Despues de Comprar -------------");
        //Stock
        System.out.println("Stock actualizado: " + tiendita.getStockTotal());
        //Saldo Caja
        System.out.println("Saldo actualizado: " + tiendita.getSaldo());
        //Stock del producto actualizado
        System.out.println("Stock del producto: " + p.getStock());
        //Precio del Producto actualizado
        System.out.println("Costo del producto: " + p.getCosto());

<<<<<<< HEAD
        /* ------------------ Prueba de ventas -------------- */
        System.out.println("\n----------- Prueba de venta ------------\n");

        venta1.agregarProductoAlCarrito(cervezaSinAlcohol, 10);
        venta1.agregarProductoAlCarrito(cerveza, 10);
        venta1.agregarProductoAlCarrito(prdEnvasado2, 10);
        venta1.agregarProductoAlCarrito(arroz, 11);
        venta1.agregarProductoAlCarrito(prdEnvasado2, 12);

        System.out.println("\n----------- Finalizando Compra ------------\n");
        venta1.finalizarCompra(tienda,listaProductos);

        System.out.println("\n----------- Detalle Post Compra ------------\n");
        venta1.imprimirDetalle(listaProductos);



/*
        System.out.println(prdEnvasado2.getFechaVencimiento());

        prdEnvasado.setCalorias((short) 12);
        System.out.println(prdEnvasado.getFechaVencimiento());
        System.out.println(prdEnvasado2.getCalorias());
        System.out.println(cerveza.getNombre() + " " + cerveza.getCalorias());
        System.out.println(cervezaSinAlcohol.getNombre() + " " + cervezaSinAlcohol.getGraduacionAlcoholica());

        cervezaSinAlcohol.setPorcentajeDescuento(15);
        cervezaSinAlcohol.setPrecioConDescuento();
        System.out.println(cervezaSinAlcohol.getPrecioConDescuento());

        cervezaSinAlcohol.setEstadoDelDescuento(true);
        cervezaSinAlcohol.setPrecioConDescuento();
        System.out.println(cervezaSinAlcohol.getPrecioConDescuento());
*/



    }

}
