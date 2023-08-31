# tienda-local

Aplicacion de tienda local realizada en Java 11 con menu interactivo por terminal, que se ejecuta sobre clase Main.

Una vez ejectuado el menu, por practicidad se recomienda ejecutar la Semilla, ubicada en el menu .4

Luego se puede navegar entre los menus para Comprar, Vender u Operar sobre los productos.

Indice:

1. Administrar Productos
    1.Agregar producto al inventario: Se define el tipo de producto y se crea un producto en base al constructor del mismo. Y los agrega al inventario.
   
    2.Buscar Producto por su identificador: Buscar un producto por el id deseado. (Metodos definidos en ListaProductos)

    3.Mostrar todos los productos del inventario: Muestra todos los productos creados. (Metodos definidos en ListaProductos)

    4.Eliminar un producto del inventario: Elimina un producto en base a su identificador. (Metodos definidos en ListaProductos)

    5.Aplicar descuento: Se ingresa que % de descuento se desea aplicar, si es valido lo aplica. (Metodos definidos en Productos e Interfaz Descuento)


     6.listarProductosConUtilidadesInferiores: Metodo requerido!, se recorre la lista de productos y devulve los que reporten menos utilidad, que la
       ingresada por el usuario (Metodos definidos en ListaProductos y Ejectuados en MenuProductos case 6)


     7.obtenerComestiblesConMenorDescuento: Metodo requerido!, obtiene los comestibles y no importados con menos descuento que el ingresado por el usuario.
     (Metodo definido en ListaProductos)

     8.imprimirListaDeProductosConGananciaIncorrecta: Determina productos con ganancias incorrectas y los pone no disponible.(Metodo definido en ListaProductos)



3. Comprar
   1.Comprar producto: Requiere que el usuario ingrese Id, cantidad y costo. Si la compra es valida, actualiza los valores.  (Metodos definidos en Tienda e Interfaz ComprarProducto)
   2.Mostrar Saldo: Muestra el saldo de la tienda.(Clase Tienda)
   3.Motrar Inventario: Muestra los productos en el inventario.(Clase Tienda guarda ids, y consulta en Clase Lista Producto)


/*
Venta a diferencia de Compra(una interfaz, implementada en tienda) es una clase, fue una decision justificada en principio. Que en el desarrollo de la aplicacion, se hizo mas dificil sostener.
Las razones que perduraron: Bajar cohesion en Tienda,
                            mantener metodos con nombres muy descriptivos,
                            utiliza un carrito para guardar productos y valores extras,
                            al trabajar con descuentos y detalle me parecio necesario tener margen de crecimiento
                            
*/
                            

        
3.Venta
  1.Agregar producto al carrito: agrega un producto valido al carrito
  2.Ver carrito: Imprime de forma detallada lo que se encuentra en el carrito, previo a comprar
  3.Finalizar Compra: finaliza la compra con los productos en el carrito y envia el detalle de la misma.
  4.Precio Total: imprime el precio de la compra al momento de consultar.
  5.Limpiar carrito: Vacia el carrito


   
   

  
