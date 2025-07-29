package uce.edu.ec.api.repository;

import java.util.List;

import uce.edu.ec.api.repository.modelo.Bodega;



public interface IBodegaRepo {

    void insertar(Bodega bodega);

    void actualizar(Bodega bodega);

    void eliminar(Integer id);

    Bodega seleccionarPorId(Integer id);

    List<Bodega> seleccionarTodas();

    Bodega seleccionarPorCodigo(String codigo);

}
