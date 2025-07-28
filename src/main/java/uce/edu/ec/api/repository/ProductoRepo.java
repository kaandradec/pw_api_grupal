package uce.edu.ec.api.repository;


import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import uce.edu.ec.api.repository.modelo.Producto;


@Transactional
@ApplicationScoped
public class ProductoRepo implements IProductoRepo{
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public Producto seleccionarPorId(Integer id) {
        TypedQuery<Producto> query = entityManager.createQuery(
            "SELECT DISTINCT p FROM Producto p " +
            "LEFT JOIN FETCH p.impuestos pi " +
            "LEFT JOIN FETCH pi.impuesto " +
            "WHERE p.id = :id", Producto.class);
        query.setParameter("id", id);
        
        List<Producto> resultados = query.getResultList();
        return resultados.isEmpty() ? null : resultados.get(0);
    }

    @Override
    public List<Producto> seleccioarTodo(String codigoBarras) {
        if (codigoBarras == null || codigoBarras.trim().isEmpty()) {
            TypedQuery<Producto> myQuery = this.entityManager.createQuery(
                "SELECT DISTINCT p FROM Producto p " +
                "LEFT JOIN FETCH p.impuestos pi " +
                "LEFT JOIN FETCH pi.impuesto", Producto.class);
            return myQuery.getResultList();
        } else {
            TypedQuery<Producto> myQuery = this.entityManager.createQuery(
                "SELECT DISTINCT p FROM Producto p " +
                "LEFT JOIN FETCH p.impuestos pi " +
                "LEFT JOIN FETCH pi.impuesto " +
                "WHERE p.codigoBarras = :codigoBarras", Producto.class);
            myQuery.setParameter("codigoBarras", codigoBarras);
            return myQuery.getResultList();
        }
    }

    @Override
    public void actualizarPorId(Producto producto) {
        this.entityManager.merge(producto);
    }

    @Override
    public void actualizarParcialPorId(Producto producto) {
        this.entityManager.merge(producto);
    }

    @Override
    public void eliminarPorId(Integer id) {
        Producto producto = this.entityManager.find(Producto.class, id);
        if(producto == null){
            throw new IllegalArgumentException("No se encontro:" + id);
        }
        this.entityManager.remove(producto);
    }

    @Override
    public void insertar(Producto producto) {
        this.entityManager.persist(producto);
    }
}