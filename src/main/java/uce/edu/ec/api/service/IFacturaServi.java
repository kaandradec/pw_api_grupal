package uce.edu.ec.api.service;

import java.util.List;

import uce.edu.ec.api.service.to.FacturaTo;

public interface IFacturaServi {

    void crearFactura(FacturaTo facturato);
     List<FacturaTo> consultarTodas();

}
