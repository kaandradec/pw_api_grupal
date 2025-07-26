package uce.edu.ec.api.repository;

import java.util.List;

import uce.edu.ec.api.repository.modelo.Impuesto;

public interface IImpuestoRepo {
     void crearImpuesto(Impuesto impuesto);

    List<Impuesto> buscarTodos();

    Impuesto buscarPorId(Integer id);

    Impuesto buscarPorNombre(String nombre);

    void actualizarParcialImpuesto(Impuesto impuesto);

    void eliminarImpuesto(Integer id);

}
