package uce.edu.ec.api.repository;

import java.util.List;

import uce.edu.ec.api.repository.modelo.Factura;

public interface IFacturaRepo {

    void crearFactura(Factura factura);
     List<Factura> consultarTodas();

}
