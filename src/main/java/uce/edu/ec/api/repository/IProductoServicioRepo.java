package uce.edu.ec.api.repository;

import java.util.List;

import uce.edu.ec.api.repository.modelo.ProductoServicio;

public interface IProductoServicioRepo {
    void CrearProServ(ProductoServicio productoServicio);

    List<ProductoServicio> buscarTodos();

    ProductoServicio buscarCodBarra(String codBarra);

    ProductoServicio buscarId(Integer id);

    void actualizarParcialProServ(ProductoServicio productoServicio);

    void eliminarProServ(Integer id);

}
