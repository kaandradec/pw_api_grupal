package uce.edu.ec.api.service;

import java.util.List;

import uce.edu.ec.api.repository.modelo.dto.FacturaTo;

public interface IFacturaService {
    void crear(FacturaTo facturaTo);
    void actualizar(FacturaTo facturaTo);
    FacturaTo buscarPorId(Integer id);
    List<FacturaTo> buscarTodos();
    void eliminar(Integer id);
    FacturaTo buscarPorNumeroDocumento(String numeroDocumento);
} 