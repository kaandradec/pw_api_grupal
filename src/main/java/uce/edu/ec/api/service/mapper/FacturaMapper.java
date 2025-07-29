package uce.edu.ec.api.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import uce.edu.ec.api.repository.modelo.Factura;
import uce.edu.ec.api.repository.modelo.FacturaDetalle;
import uce.edu.ec.api.repository.modelo.dto.FacturaTo;
import uce.edu.ec.api.repository.modelo.dto.FacturaDetalleTo;
import uce.edu.ec.api.repository.modelo.dto.ClienteTo;

public class FacturaMapper {
    
    public static FacturaTo convertir(Factura factura) {
        if (factura == null) {
            return null;
        }
        
        ClienteTo clienteTo = ClienteMapper.convertir(factura.getCliente());
        List<FacturaDetalleTo> detallesTo = factura.getDetalles() != null ? 
            factura.getDetalles().stream()
                .map(FacturaDetalleMapper::convertir)
                .collect(Collectors.toList()) : null;
        
        return new FacturaTo(
            factura.getId(),
            factura.getRucEmpresa(),
            factura.getNumeroDocumento(),
            factura.getEstablecimiento(),
            factura.getPuntoEmision(),
            factura.getFechaEmision(),
            factura.getSubtotal(),
            factura.getTotalImpuestos(),
            factura.getTotal(),
            clienteTo,
            detallesTo
        );
    }
    
    public static Factura convertir(FacturaTo facturaTo) {
        if (facturaTo == null) {
            return null;
        }
        
        Factura factura = new Factura();
        factura.setId(facturaTo.getId());
        factura.setRucEmpresa(facturaTo.getRucEmpresa());
        factura.setNumeroDocumento(facturaTo.getNumeroDocumento());
        factura.setEstablecimiento(facturaTo.getEstablecimiento());
        factura.setPuntoEmision(facturaTo.getPuntoEmision());
        factura.setFechaEmision(facturaTo.getFechaEmision());
        factura.setSubtotal(facturaTo.getSubtotal());
        factura.setTotalImpuestos(facturaTo.getTotalImpuestos());
        factura.setTotal(facturaTo.getTotal());
        
        if (facturaTo.getCliente() != null) {
            factura.setCliente(ClienteMapper.ToEntity(facturaTo.getCliente()));
        }
        
        if (facturaTo.getDetalles() != null) {
            List<FacturaDetalle> detalles = facturaTo.getDetalles().stream()
                .map(detalleTo -> {
                    FacturaDetalle detalle = FacturaDetalleMapper.convertir(detalleTo);
                    detalle.setFactura(factura);
                    return detalle;
                })
                .collect(Collectors.toList());
            factura.setDetalles(detalles);
        }
        
        return factura;
    }
} 