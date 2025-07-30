package uce.edu.ec.api.repository;

import java.util.List;

import uce.edu.ec.api.repository.modelo.Producto;

public interface IProductoRepo {
    Producto seleccionarPorId(Integer id);
    List<Producto> seleccionarTodo(String codigoBarras);
    void actualizarPorId(Producto producto);
    void actualizarParcialPorId(Producto producto);
    void eliminarPorId(Integer id);
    void insertar(Producto producto);
}
