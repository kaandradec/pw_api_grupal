package uce.edu.ec.api.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.ec.api.repository.IProductoRepo;
import uce.edu.ec.api.repository.modelo.Producto;

@ApplicationScoped
public class ProductoServi implements IProductoServi {
    @Inject
    private IProductoRepo iProductoRepo;

    @Override
    public Producto buscarPorId(Integer id) {
        return this.iProductoRepo.seleccionarPorId(id);
    }

    @Override
    public List<Producto> buscarTodo(String codigoBarras) {
       return this.iProductoRepo.seleccioarTodo(codigoBarras);
    }

    @Override
    public void actualizarPorId(Producto producto) {
       this.iProductoRepo.actualizarPorId(producto);
    }

    @Override
    public void actualizarParcialPorId(Producto producto) {
       this.iProductoRepo.actualizarParcialPorId(producto);
    }

    @Override
    public void eliminarPorId(Integer id) {
        this.iProductoRepo.eliminarPorId(id);
    }

    @Override
    public void guardar(Producto producto) {
      this.iProductoRepo.insertar(producto);
    }

}
