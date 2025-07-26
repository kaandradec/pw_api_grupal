package uce.edu.ec.api.service;

import java.util.List;

import uce.edu.ec.api.service.to.ImpuestoTo;


public interface IImpuestoServi {
     void crearImpuesto(ImpuestoTo impuestoTo);

    List<ImpuestoTo> buscarTodos();

    ImpuestoTo buscarPorId(Integer id);

    ImpuestoTo buscarPorNombre(String nombre);

    void actualizarParcialImpuesto(ImpuestoTo impuestoTo);

    void eliminarImpuesto(Integer id);

}
