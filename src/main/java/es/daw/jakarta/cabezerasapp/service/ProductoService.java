package es.daw.jakarta.cabezerasapp.service;
import es.daw.jakarta.cabezerasapp.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {


    List<Producto> findAll();

    //en vez de hacer si es distinto de nulo o no
    public Optional<Producto> findById(Integer id);

    public Producto findByName(String name);


    // se pueden añadir tambien los metodos de CRUD y otros
}
