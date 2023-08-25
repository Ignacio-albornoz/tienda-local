import com.tiendalocal.aplicaciontienda.modelo.productos.*;
import com.tiendalocal.aplicaciontienda.modelo.productos.enums.TipoAplicacion;
import com.tiendalocal.aplicaciontienda.modelo.productos.enums.TipoEnvase;
import com.tiendalocal.aplicaciontienda.modelo.tienda.Tienda;
import com.tiendalocal.aplicaciontienda.modelo.tienda.Venta;
import com.tiendalocal.aplicaciontienda.modelo.tienda.enums.TipoProducto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Aplicacion para tienda local en proceso!");

        LocalDate vencimiento = LocalDate.of(2023, 11, 11);
        LocalDate vencimiento1 = LocalDate.of(2024, 9, 21);
        LocalDate vencimiento2 = LocalDate.of(2023, 1, 15);
        LocalDate vencimiento3 = LocalDate.of(2025, 12, 24);
        LocalDate vencimiento4 = LocalDate.of(2024, 05, 31);

        ProductoEnvasado prdEnvasado = new ProductoEnvasado("AAA123", "Vela aromatica en envase de plastico", "vela aromatica en envase poco seguro y convencional", 3, 69.99, 39.99,  TipoEnvase.PLASTICO ,false);

        ProductoEnvasado prdEnvasado2 = new ProductoEnvasado("AAA124", "Vela aromatica en envase de vidrio comestible", "vela aromatica en envase poco seguro, convencional y muy rica", 12, 43.99, 39.99, TipoEnvase.PLASTICO ,false, true, vencimiento2 , (short) 1287);

        Bebida cerveza = new Bebida("KKK223", "Cerveza Patagonia", "cerveza realizada en algun lugar", 2, 399.50, 201.21, true, 5.7,true, false, vencimiento1, (short) 450);

        Bebida cervezaSinAlcohol = new Bebida("KKK222", "Cerveza Patagonia Sin Alcohol", "no recomendada para consumo", 2, 399.50, 201.21, true, 5.7,false,  false, vencimiento, (short) 450);

        // Creamos una lista de productos vacía
        ListaProductos listaProductos = new ListaProductos();

// Creamos 10 productos con diferentes tipos y atributos
        ProductoEnvasado galletitas = new ProductoEnvasado("AAA111", "Galletitas Oreo", "contiene gluten y lactosa", 3, 99.90, 50.00, TipoEnvase.PLASTICO, false, true, vencimiento3, (short) 300);
        Bebida jugoNaranja = new Bebida("BBB222", "Jugo de Naranja Cepita", "fuente de vitamina C", 1, 59.90, 20.00, false, 0, true, true, vencimiento4, (short) 200);
        ProductoLimpieza detergente = new ProductoLimpieza("CCC333", "Detergente Magistral", "limpia y desinfecta", 2, 149.90, 100.00, true, TipoAplicacion.COCINA);
        ProductoEnvasado arroz = new ProductoEnvasado("DDD444", "Arroz Gallo Oro", "sin TACC", 3, 79.90, 40.00, TipoEnvase.PLASTICO, false, true, vencimiento, (short) 1000);
        Bebida leche = new Bebida("EEE555", "Leche La Serenísima", "contiene calcio y proteínas", 1, 89.90, 30.00, true, 1.0, false, true, vencimiento, (short) 250);
        ProductoLimpieza jabon = new ProductoLimpieza("FFF666", "Jabón Dove", "cuida tu piel", 2, 69.90, 35.00, false, TipoAplicacion.MULTIUSO);
        ProductoEnvasado fideos = new ProductoEnvasado("GGG777", "Fideos Matarazzo", "contiene gluten", 3 ,99.90 ,45.00 , TipoEnvase.LATA ,false , true ,vencimiento ,(short)500);
        Bebida aguaMineral = new Bebida("HHH888", "Agua Mineral Villavicencio", "sin gas y sin sodio",1 ,49.90 ,15.00 ,false ,2.0 ,false ,false ,vencimiento ,(short)2000);
        ProductoLimpieza lavandina = new ProductoLimpieza("III999", "Lavandina Ayudín", "elimina el 99% de los gérmenes",2 ,119.90 ,60.00 ,true ,TipoAplicacion.MULTIUSO);
        ProductoEnvasado yerba = new ProductoEnvasado("JJJ000", "Yerba Taragui", "sabor intenso y duradero",3 ,199.90 ,80.00 , TipoEnvase.PLASTICO ,false ,true ,vencimiento3 ,(short)300);


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
        listaProductos.agregarProducto(prdEnvasado);
        System.out.println("-------------APLICANDO DESCUENTOS------------------------\n");

        Producto aguaMineral2 = listaProductos.obtenerProductoPorId("HHH888");

        aguaMineral2.aplicarDescuento(15);

        System.out.println(aguaMineral);

        aguaMineral2.aplicarDescuento(100);

        System.out.println(aguaMineral);

        aguaMineral.aplicarDescuento(40);

        System.out.println(aguaMineral);


        System.out.println("-------------LIsta de productos con Ganancias Incorrectas------------------------\n");
        listaProductos.imprimirListaDeProductosConGananciaIncorrecta();

        Tienda tiendita = new Tienda("Entropia", 50, 12500.50);
        System.out.println("");
        System.out.println("");
        tiendita.agregarProducto("AAA124", listaProductos);
        tiendita.agregarProducto("KKK222", listaProductos);
        tiendita.agregarProducto("III999", listaProductos);
        tiendita.agregarProducto("JJJ000", listaProductos);
        tiendita.agregarProducto("AAA111", listaProductos);
        tiendita.agregarProducto("BBB222", listaProductos);
        tiendita.agregarProducto("FFF666", listaProductos);
        tiendita.agregarProducto("CCC333", listaProductos);
        tiendita.agregarProducto("GGG777", listaProductos);
        tiendita.agregarProducto("DDD444", listaProductos);
        tiendita.agregarProducto("HHH888", listaProductos);
        tiendita.agregarProducto("EEE555", listaProductos);
        System.out.println("IDS bebibas en tienda: ");
        tiendita.obtenerIdsDeProductosPorTipo(TipoProducto.BEBIDA);
        System.out.println("");
        tiendita.obtenerListaDeObjetosEnProductos(TipoProducto.BEBIDA, listaProductos);
        Producto p = listaProductos.obtenerProductoPorId("KKK222");

        System.out.println("costo ANTES comprar: " + p.getCosto());
        System.out.println("stock ANTES comprar: " + p.getStock() + "\n");

        System.out.println("-------------");
        System.out.println("Pruebas de compras");
        //Saldo Insuficiente
        tiendita.comprarProducto("KKK222", 130,205.50, listaProductos);
        System.out.println("\n");
        //Stock maximo alcanzado
        tiendita.comprarProducto("KKK222", 130,1.50, listaProductos);
        System.out.println("\n");
        //Compra valida
        tiendita.comprarProducto("KKK222", 8,205.50, listaProductos);

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
        Venta venta1 = new Venta();
        venta1.agregarProductoAlCarrito(cervezaSinAlcohol, 10);
        venta1.agregarProductoAlCarrito(cerveza, 10);
        venta1.agregarProductoAlCarrito(prdEnvasado2, 10);
        venta1.agregarProductoAlCarrito(prdEnvasado, 11);
        venta1.agregarProductoAlCarrito(prdEnvasado2, 12);

        System.out.println("\n----------- Finalizando Compra ------------\n");
        venta1.finalizarCompra(tiendita,listaProductos);

        System.out.println("\n----------- Detalle Post Compra ------------\n");
        venta1.imprimirDetalle(listaProductos);

        double resu = leche.calcularImpuesto(leche.getPrecio());

        System.out.println(resu);

        listaProductos.obtenerComestibleConMenorDescuento(25);

        List<Producto> listaUtilidadesBajas = listaProductos.listarProductosConUtilidadesInferiores(25);

        listaUtilidadesBajas.stream().forEach(producto -> {
            System.out.println("ID: " + producto.getId());
            System.out.println("Descripcion: " + producto.getDescripcion());
            System.out.println("Cantidad en stock: " + producto.getStock());
            System.out.println("------------------------");
        });
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