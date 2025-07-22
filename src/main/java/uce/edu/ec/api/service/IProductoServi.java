package uce.edu.ec.api.service;

import java.util.List;

import uce.edu.ec.api.repository.modelo.Producto;


public interface IProductoServi {
    Producto buscarPorId(Integer id);
    List<Producto> buscarTodo(String codigoBarras);
    void actualizarPorId(Producto producto);
    void actualizarParcialPorId(Producto producto);
    void eliminarPorId(Integer id);
    void guardar(Producto producto);
}
