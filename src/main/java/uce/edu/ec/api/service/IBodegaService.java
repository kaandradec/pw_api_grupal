package uce.edu.ec.api.service;

import java.util.List;

import uce.edu.ec.api.repository.modelo.dto.BodegaTo;

public interface IBodegaService {

    void guardar(BodegaTo bodega);

    void actualizar(BodegaTo bodega);

    void eliminar(Integer id);

    BodegaTo buscarPorId(Integer id);

    BodegaTo buscarPorCodigo(String codigo);

    List<BodegaTo> buscarTodos();

}
