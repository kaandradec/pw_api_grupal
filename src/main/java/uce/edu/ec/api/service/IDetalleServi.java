package uce.edu.ec.api.service;

import java.util.List;

import uce.edu.ec.api.service.to.DetalleFacturaTo;


public interface IDetalleServi {
    void crearDetalle(DetalleFacturaTo detalleTo);
    List<DetalleFacturaTo> buscarPorNumeroDocumento(String numeroDocumento);

}
