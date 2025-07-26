package uce.edu.ec.api.repository;

import java.util.List;

import uce.edu.ec.api.repository.modelo.Bodega;

public interface IBodegaRepo {

    void crearBodega(Bodega bodega);

    List<Bodega> buscarTodos();

    Bodega buscarPorId(Integer id);

    Bodega buscarPorCodigo(String codigoB);

    void actualizarBodega(Bodega bodega);

    void eliminarBodega(Integer id);
}
