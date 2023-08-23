import com.tiendalocal.aplicaciontienda.modelo.productos.Bebida;
import com.tiendalocal.aplicaciontienda.modelo.productos.Producto;
import com.tiendalocal.aplicaciontienda.modelo.productos.ProductoEnvasado;
import com.tiendalocal.aplicaciontienda.modelo.productos.enums.TipoEnvase;
import com.tiendalocal.aplicaciontienda.modelo.tienda.Tienda;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Aplicacion para tienda local en proceso!");

        LocalDate vencimiento = LocalDate.of(2023, 11, 11);

        ProductoEnvasado prdEnvasado = new ProductoEnvasado("AAA123", "Vela aromatica en envase de plastico", "vela aromatica en envase poco seguro y convencional", 3, 69.99, 39.99, true, TipoEnvase.PLASTICO ,false, false);

        ProductoEnvasado prdEnvasado2 = new ProductoEnvasado("AAA124", "Vela aromatica en envase de vidrio comestible", "vela aromatica en envase poco seguro, convencional y muy rica", 12, 49.99, 39.99, true, TipoEnvase.PLASTICO ,false, true, vencimiento , (short) 1287);

        Bebida cerveza = new Bebida("KKK222", "Cerveza Patagonia", "cerveza realizada en algun lugar", 2, 399.50, 201.21, true, true, 5.7, false, true, vencimiento, (short) 450);

        Bebida cervezaSinAlcohol = new Bebida("KKK222", "Cerveza Patagonia Sin Alcohol", "no recomendada para consumo", 2, 399.50, 201.21, true, false, 5.7, false, false, vencimiento, (short) 450);

        Tienda tiendita = new Tienda("Entropia", 15, 2500.50);
        System.out.println("Se agrega y busca un producto");
        tiendita.agregarProducto("Envasado",prdEnvasado2);
        tiendita.agregarProducto("Bebida", cervezaSinAlcohol);
        Producto p = tiendita.buscarProducto("Bebida", "KKK222");

        System.out.println("-------------");
        System.out.println("Pruebas de compras");
        //Saldo Insuficiente
        tiendita.comprarProducto("Bebida", "KKK222", 130,205.50);
        System.out.println("\b");
        //Stock maximo alcanzado
        tiendita.comprarProducto("Bebida", "KKK222", 130,1.50);
        System.out.println("\b");
        //Compra valida
        tiendita.comprarProducto("Bebida", "KKK222", 4,205.50);
        System.out.println("\b");
        /* -------------- Despues de Comprar -------------*/
        System.out.println("-------------- Despues de Comprar -------------");
        //Stock
        System.out.println("Stock actualizado: " + tiendita.getStockTotal());
        //Saldo Caja
        System.out.println("Saldo actualizado: " + tiendita.getSaldo());
        //Stock del producto actualizado
        System.out.println("Stock del producto: " + p.getStock());
        //Precio del Producto actualizado
        System.out.println("Costo del producto: " + p.getCosto());


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