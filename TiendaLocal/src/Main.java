import com.tiendalocal.aplicaciontienda.modelo.productos.Bebida;
import com.tiendalocal.aplicaciontienda.modelo.productos.ProductoEnvasado;
import com.tiendalocal.aplicaciontienda.modelo.productos.enums.TipoEnvase;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Aplicacion para tienda local en proceso!");

        LocalDate vencimiento = LocalDate.of(2023, 11, 11);

        ProductoEnvasado prdEnvasado = new ProductoEnvasado("AAA123", "Vela aromatica en envase de plastico", "vela aromatica en envase poco seguro y convencional", 3, 69.99, 39.99, true, TipoEnvase.PLASTICO ,false, false);

        ProductoEnvasado prdEnvasado2 = new ProductoEnvasado("AAA124", "Vela aromatica en envase de vidrio comestible", "vela aromatica en envase poco seguro, convencional y muy rica", 1, 49.99, 39.99, true, TipoEnvase.PLASTICO ,false, true, vencimiento , (short) 1287);

        Bebida cerveza = new Bebida("KKK222", "Cerveza Patagonia", "cerveza realizada en algun lugar", 2, 399.50, 201.21, true, true, 5.7, false, true, vencimiento, (short) 450);

        Bebida cervezaSinAlcohol = new Bebida("KKK222", "Cerveza Patagonia Sin Alcohol", "no recomendada para consumo", 2, 399.50, 201.21, true, false, 5.7, false, false, vencimiento, (short) 450);


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


    }
}