package es.daw.jakarta.cabezerasapp.controller;

import java.io.*;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import es.daw.jakarta.cabezerasapp.model.Producto;
import es.daw.jakarta.cabezerasapp.model.recogerProductosImpl;

@WebServlet(name = "productos", value = {"/productos.xls", "/productos.html", "/productos"})
public class ProductosXlsServlet extends HttpServlet {
    private String message;
    private static final Logger LOG = Logger.getLogger(ProductosXlsServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException, ServletException {

        //como no he puesto static pues itero un objeto de donde tengo los datos
        recogerProductosImpl servicio = new recogerProductosImpl();

        //hago una lista que tenga los datos de esa clase
        List<Producto> listaproductos = servicio.findAll();

        System.out.println("Número de productos: " + listaproductos.size());
        for (Producto p : listaproductos) {
            System.out.println(p.getId() + " - " + p.getNombre() + " - " + p.getTipo() + " - " + p.getPrecio());
        }

        req.setAttribute("listaproductos", listaproductos);
        // a ese atributo le pongo un nombre para que este puede ser encontrado en varios lados

        LOG.info(" uri:  " + req.getRequestURI());
        LOG.info(" getservletpath " + req.getServletPath());
        LOG.info("context path: " + req.getContextPath());
        LOG.info("URL: " + req.getRequestURL());

        if(req.getServletPath().endsWith(".xls")) {
            resp.setContentType("application/vnd.ms-excel");
            resp.setHeader("Content-Disposition", "attachment; filename=productos.xls");

        }


        getServletContext().getRequestDispatcher("/Producto.jsp").forward(req , resp);

    }

}