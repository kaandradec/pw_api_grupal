package uce.edu.ec.api.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.ec.api.repository.IFacturaRepo;
import uce.edu.ec.api.repository.IClienteRepo;
import uce.edu.ec.api.repository.IProductoRepo;
import uce.edu.ec.api.repository.modelo.Factura;
import uce.edu.ec.api.repository.modelo.Cliente;
import uce.edu.ec.api.repository.modelo.Producto;
import uce.edu.ec.api.repository.modelo.dto.FacturaTo;
import uce.edu.ec.api.service.mapper.FacturaMapper;

@ApplicationScoped
public class FacturaServiceImpl implements IFacturaService {

    @Inject
    private IFacturaRepo iFacturaRepo;
    
    @Inject
    private IClienteRepo iClienteRepo;
    
    @Inject
    private IProductoRepo iProductoRepo;

    @Override
    public void crear(FacturaTo facturaTo) {
        // Validar que el cliente existe
        if (facturaTo.getCliente() != null && facturaTo.getCliente().getId() != null) {
            Cliente cliente = iClienteRepo.buscarPorId(facturaTo.getCliente().getId());
            if (cliente == null) {
                throw new RuntimeException("Cliente no encontrado");
            }
        }
        
        // Validar que los productos existen y calcular totales
        if (facturaTo.getDetalles() != null && !facturaTo.getDetalles().isEmpty()) {
            BigDecimal subtotal = BigDecimal.ZERO;
            BigDecimal totalImpuestos = BigDecimal.ZERO;
            
            for (var detalleTo : facturaTo.getDetalles()) {
                if (detalleTo.getProducto() != null && detalleTo.getProducto().getId() != null) {
                    Producto producto = iProductoRepo.seleccionarPorId(detalleTo.getProducto().getId());
                    if (producto == null) {
                        throw new RuntimeException("Producto no encontrado: " + detalleTo.getProducto().getId());
                    }
                    
                    // Validar stock si es producto
                    if ("PRODUCTO".equalsIgnoreCase(producto.getCategoria()) && 
                        producto.getStock() < detalleTo.getCantidad()) {
                        throw new RuntimeException("Stock insuficiente para el producto: " + producto.getNombre());
                    }
                    
                    // Calcular subtotal del detalle
                    BigDecimal subtotalDetalle = producto.getPrecio().multiply(new BigDecimal(detalleTo.getCantidad()));
                    detalleTo.setSubtotal(subtotalDetalle);
                    subtotal = subtotal.add(subtotalDetalle);
                    
                    // Calcular impuestos del detalle (simplificado - se puede mejorar)
                    BigDecimal impuestosDetalle = subtotalDetalle.multiply(new BigDecimal("0.12")); // IVA 12%
                    totalImpuestos = totalImpuestos.add(impuestosDetalle);
                }
            }
            
            facturaTo.setSubtotal(subtotal);
            facturaTo.setTotalImpuestos(totalImpuestos);
            facturaTo.setTotal(subtotal.add(totalImpuestos));
        }
        
        // Establecer fecha de emisión si no está establecida
        if (facturaTo.getFechaEmision() == null) {
            facturaTo.setFechaEmision(LocalDate.now());
        }
        
        Factura factura = FacturaMapper.convertir(facturaTo);
        iFacturaRepo.insertar(factura);
    }

    @Override
    public void actualizar(FacturaTo facturaTo) {
        if (facturaTo.getId() == null) {
            throw new RuntimeException("ID de factura es requerido para actualizar");
        }
        
        Factura facturaExistente = iFacturaRepo.buscarPorId(facturaTo.getId());
        if (facturaExistente == null) {
            throw new RuntimeException("Factura no encontrada");
        }
        
        // Aplicar la misma lógica de validación y cálculo que en crear
        crear(facturaTo);
    }

    @Override
    public FacturaTo buscarPorId(Integer id) {
        Factura factura = iFacturaRepo.buscarPorId(id);
        return FacturaMapper.convertir(factura);
    }

    @Override
    public List<FacturaTo> buscarTodos() {
        List<Factura> facturas = iFacturaRepo.buscarTodos();
        return facturas.stream()
                .map(FacturaMapper::convertir)
                .toList();
    }

    @Override
    public void eliminar(Integer id) {
        Factura factura = iFacturaRepo.buscarPorId(id);
        if (factura == null) {
            throw new RuntimeException("Factura no encontrada");
        }
        iFacturaRepo.eliminar(id);
    }

    @Override
    public FacturaTo buscarPorNumeroDocumento(String numeroDocumento) {
        Factura factura = iFacturaRepo.buscarPorNumeroDocumento(numeroDocumento);
        return FacturaMapper.convertir(factura);
    }
} 