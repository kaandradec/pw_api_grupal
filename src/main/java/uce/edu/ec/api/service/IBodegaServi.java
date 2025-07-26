package uce.edu.ec.api.service;

import java.util.List;

import uce.edu.ec.api.service.to.BodegaTo;


public interface IBodegaServi {

    void crearBodega(BodegaTo bodegaTo);

    List<BodegaTo> buscarTodos();

    BodegaTo buscarPorId(Integer id);

    BodegaTo buscarPorCodigo(String codigoB);

    void actualizarBodega(BodegaTo bodegaTo);

    void eliminarBodega(Integer id);
}
