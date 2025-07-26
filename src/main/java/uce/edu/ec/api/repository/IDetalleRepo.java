package uce.edu.ec.api.repository;

import java.util.List;

import uce.edu.ec.api.repository.modelo.DetalleFactura;

public interface IDetalleRepo {
    void crearDetalle(DetalleFactura detalle);
    List<DetalleFactura> buscarPorNumeroDocumento(String numeroDocumento);


}
