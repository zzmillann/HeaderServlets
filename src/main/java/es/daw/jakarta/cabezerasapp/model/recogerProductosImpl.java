package es.daw.jakarta.cabezerasapp.model;

import java.util.ArrayList;
import java.util.List;

public class recogerProductosImpl implements ProductoService {
    @Override
    public List<Producto> recogerProductos() {
       List<Producto> productos = new ArrayList<Producto>();
       productos.add(new Producto(1,"MANZANA","FRUTA",2000));
       productos.add(new Producto(2,"PIZZA","COMIDA BASURA",3450));
       productos.add(new Producto(3,"LUBINA","PESCADO",860));
       productos.add(new Producto(4,"CHOCOLATE","DULCE",3490));
       return productos;


    }


}
