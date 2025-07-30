package uce.edu.ec.api.service;


import java.util.List;
import java.util.stream.Collectors;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.ec.api.repository.IProductoRepo;
import uce.edu.ec.api.repository.modelo.Impuesto;
import uce.edu.ec.api.repository.modelo.Producto;
import uce.edu.ec.api.repository.modelo.ProductoImpuesto;
import uce.edu.ec.api.service.To.ProductoTo;
import uce.edu.ec.api.service.mapper.ProductoMapper;

@ApplicationScoped
public class ProductoServi implements IProductoServi {
    @Inject
    private IProductoRepo iProductoRepo;
    @Inject
    private ImpuestoService impuestoService; 

    @Override
    public Producto buscarPorId(Integer id) {
        return this.iProductoRepo.seleccionarPorId(id);
    }

    @Override
    public List<Producto> buscarTodo(String codigoBarras) {
       return this.iProductoRepo.seleccionarTodo(codigoBarras);
    }

    @Override
    public void actualizarPorId(Producto producto) {
       this.iProductoRepo.actualizarPorId(producto);
    }

    @Override
    public void actualizarParcialPorId(Producto producto) {
        Producto productoExistente = iProductoRepo.seleccionarPorId(producto.getId());
        if (productoExistente == null) {
            throw new RuntimeException("Producto no encontrado");
        }

        if (producto.getNombre() != null) {
            productoExistente.setNombre(producto.getNombre());
        }
        if (producto.getCodigoBarras() != null) {
            productoExistente.setCodigoBarras(producto.getCodigoBarras());
        }
        if (producto.getCategoria() != null) {
            productoExistente.setCategoria(producto.getCategoria());
        }
        if (producto.getPrecio() != null) {
            productoExistente.setPrecio(producto.getPrecio());
        }
        if (producto.getStock() != null) {
            productoExistente.setStock(producto.getStock());
        }
        if (producto.getBodega() != null && producto.getBodega().getId() != null) {
            productoExistente.setBodega(producto.getBodega());
        }
        if (producto.getImpuestos() != null && !producto.getImpuestos().isEmpty()) {
            productoExistente.setImpuestos(producto.getImpuestos());
        }
        iProductoRepo.actualizarPorId(productoExistente);
    }

    @Override
    public void actualizarParcial(ProductoTo productoTo) {
        Producto productoParcial = ProductoMapper.toEntity(productoTo);
        actualizarParcialPorId(productoParcial);
    }

    @Override
    public void eliminarPorId(Integer id) {
        this.iProductoRepo.eliminarPorId(id);
    }

    @Override
    public void guardar(Producto producto) {
      this.iProductoRepo.insertar(producto);
    }

    @Override
    public void guardarDesdeTo(ProductoTo productoTo) {
        Producto producto = ProductoMapper.toEntity(productoTo);

        if (productoTo.getImpuestos() != null && !productoTo.getImpuestos().isEmpty()) {
            List<ProductoImpuesto> productoImpuestos = productoTo.getImpuestos().stream()
                .map(impuestoDto -> {
                    ProductoImpuesto pi = new ProductoImpuesto();
                    pi.setProducto(producto);
                    Impuesto impuesto = impuestoService.buscarPorId(impuestoDto.getId());
                    pi.setImpuesto(impuesto);
                    return pi;
                })
                .collect(Collectors.toList());
            producto.setImpuestos(productoImpuestos);
        }

        this.iProductoRepo.insertar(producto);
        }

}
