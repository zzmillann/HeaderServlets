package es.daw.jakarta.cabezerasapp.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import es.daw.jakarta.cabezerasapp.model.Producto;
import es.daw.jakarta.cabezerasapp.model.ProductoService;
import es.daw.jakarta.cabezerasapp.model.recogerProductosImpl;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "productos", value = {"/productos.xls", "/productos.html", "/productos"})
public class ProductosXlsServlet extends HttpServlet {
    private String message;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException, ServletException {

        //como no he puesto static pues itero un objeto de donde tengo los datos
        recogerProductosImpl servicio = new recogerProductosImpl();

        //hago una lista que tenga los datos de esa clase
        List<Producto> listaproductos = servicio.recogerProductos();

        System.out.println("Número de productos: " + listaproductos.size());
        for (Producto p : listaproductos) {
            System.out.println(p.getId() + " - " + p.getNombre() + " - " + p.getTipo() + " - " + p.getPrecio());
        }

        req.setAttribute("listaproductos", listaproductos);
        // a ese atributo le pongo un nombre para que este puede ser encontrado en varios lados

        getServletContext().getRequestDispatcher("/Producto.jsp").forward(req , resp);

    }

}