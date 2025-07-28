package uce.edu.ec.api.repository;

import java.util.List;

import uce.edu.ec.api.repository.modelo.Factura;

public interface IFacturaRepo {
    void insertar(Factura factura);
    void actualizar(Factura factura);
    Factura buscarPorId(Integer id);
    List<Factura> buscarTodos();
    void eliminar(Integer id);
    Factura buscarPorNumeroDocumento(String numeroDocumento);
} 