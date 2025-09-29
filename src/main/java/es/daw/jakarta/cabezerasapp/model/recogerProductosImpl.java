package es.daw.jakarta.cabezerasapp.model;

import es.daw.jakarta.cabezerasapp.service.ProductoService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class recogerProductosImpl implements ProductoService {
    @Override
    public List<Producto> findAll() {
       return  Arrays.asList(
        new Producto(1,"MANZANA","FRUTA",2000),
        new Producto(2,"PIZZA","COMIDA BASURA",3450),
        new Producto(3,"LUBINA","PESCADO",860),
        new Producto(4,"CHOCOLATE","DULCE",3490)
        );

    }

    @Override
    public Optional<Producto> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Producto findByName(String name) {
        return null;
    }


}
