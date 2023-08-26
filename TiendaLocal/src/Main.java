import com.tiendalocal.aplicaciontienda.menuInteractivo.MenuPrincipal;
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
        MenuPrincipal.main(args);
    }
}