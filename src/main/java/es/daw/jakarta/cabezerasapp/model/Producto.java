package es.daw.jakarta.cabezerasapp.model;

import java.util.Objects;

public class Producto {
    private int id;
    private String nombre;
    private String tipo;
    private  int precio;

    public Producto(int id, String nombre, String tipo, int precio) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    public String getTipo() {
        return tipo;
    }

    public int getPrecio() {
        return precio;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return id == producto.id && precio == producto.precio && Objects.equals(nombre, producto.nombre) && Objects.equals(tipo, producto.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, tipo, precio);
    }
}
