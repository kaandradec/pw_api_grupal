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
import uce.edu.ec.api.repository.modelo.dto.FacturaDetalleTo;
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
    final BigDecimal IVA_PORCENTAJE = new BigDecimal("0.12");

    // Validar cliente
    if (facturaTo.getCliente() == null || facturaTo.getCliente().getId() == null) {
        throw new RuntimeException("La factura no tiene cliente asignado");
    }

    Cliente cliente = iClienteRepo.buscarPorId(facturaTo.getCliente().getId());
    if (cliente == null) {
        throw new RuntimeException("Cliente no encontrado");
    }

    // Validar y procesar detalles
    List<FacturaDetalleTo> detalles = facturaTo.getDetalles();
    if (detalles == null || detalles.isEmpty()) {
        throw new RuntimeException("La factura no tiene detalles");
    }

    BigDecimal subtotal = BigDecimal.ZERO;
    BigDecimal totalImpuestos = BigDecimal.ZERO;

    for (FacturaDetalleTo detalleTo : detalles) {
        if (detalleTo.getProducto() == null || detalleTo.getProducto().getId() == null) {
            throw new RuntimeException("Detalle sin producto asignado");
        }

        Producto producto = iProductoRepo.seleccionarPorId(detalleTo.getProducto().getId());
        if (producto == null) {
            throw new RuntimeException("Producto no encontrado: " + detalleTo.getProducto().getId());
        }

        // Validar stock
        if ("PRODUCTO".equalsIgnoreCase(producto.getCategoria())) {
            if (producto.getStock() < detalleTo.getCantidad()) {
                throw new RuntimeException("Stock insuficiente para el producto: " + producto.getNombre());
            }
            producto.setStock(producto.getStock() - detalleTo.getCantidad());
            iProductoRepo.actualizarPorId(producto);
        }

        // Calcular subtotal y impuestos
        BigDecimal cantidad = BigDecimal.valueOf(detalleTo.getCantidad());
        BigDecimal precioUnitario = producto.getPrecio();
        BigDecimal subtotalDetalle = precioUnitario.multiply(cantidad);
        detalleTo.setSubtotal(subtotalDetalle);

        BigDecimal impuestosDetalle = subtotalDetalle.multiply(IVA_PORCENTAJE);
        subtotal = subtotal.add(subtotalDetalle);
        totalImpuestos = totalImpuestos.add(impuestosDetalle);
    }

    facturaTo.setSubtotal(subtotal);
    facturaTo.setTotalImpuestos(totalImpuestos);
    facturaTo.setTotal(subtotal.add(totalImpuestos));

    // Establecer fecha de emisión si no viene desde frontend
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