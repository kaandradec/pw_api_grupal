package uce.edu.ec.api.service;

import java.util.List;

import uce.edu.ec.api.service.to.ProductoServicioTo;


public interface IProductoServicioServi {
    void CrearProServ(ProductoServicioTo productoServicioTo);

    List<ProductoServicioTo> buscarTodos();

    ProductoServicioTo buscarCodBarra(String codBarra);

    ProductoServicioTo buscarId(Integer id);

    void actualizarParcialProServ(ProductoServicioTo productoServicioTo);

    void eliminarProServ(Integer id);

}
