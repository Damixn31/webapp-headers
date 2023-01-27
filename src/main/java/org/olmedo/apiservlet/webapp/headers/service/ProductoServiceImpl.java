package org.olmedo.apiservlet.webapp.headers.service;

import org.olmedo.apiservlet.webapp.headers.models.Producto;

import java.util.Arrays;
import java.util.List;

public class ProductoServiceImpl implements ProductoService{

    @Override
    public List<Producto> listar() {
        return Arrays.asList(new Producto(1L, "notebook", "computacion", 17500),
                new Producto(2L, "mesa escritorio", "oficina", 100000),
                new Producto(3L, "teclado mecanico", "computacion", 40000));
    }
}
