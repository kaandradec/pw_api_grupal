package uce.edu.ec.api.repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.TransactionScoped;
import uce.edu.ec.api.repository.modelo.ProductoServicio;

@TransactionScoped
@ApplicationScoped
public class ProductoServicioRepoImpl implements IProductoServicioRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void CrearProServ(ProductoServicio productoServicio) {
        this.entityManager.persist(productoServicio);
    }

     @Override
    public List<ProductoServicio> buscarTodos() {
        TypedQuery<ProductoServicio> query = this.entityManager.createQuery("SELECT p FROM ProductoServicio p", ProductoServicio.class);
        return query.getResultList();
    }

    @Override
    public ProductoServicio buscarCodBarra(String codBarra) {

        TypedQuery<ProductoServicio> myquery = this.entityManager.createQuery(
                "select p from ProductoServicio p where p.codigoBarras=: codigoBarras", ProductoServicio.class);
        myquery.setParameter("codigoBarras", codBarra);
        return myquery.getSingleResult();
    }

    @Override
    public ProductoServicio buscarId(Integer id) {
      return this.entityManager.find(ProductoServicio.class, id);
    
    }

    @Override
    public void actualizarParcialProServ(ProductoServicio productoServicio) {
       this.entityManager.merge(productoServicio);
    }

    @Override
    public void eliminarProServ(Integer id) {
     ProductoServicio produ = this.buscarId(id);
     this.entityManager.remove(produ);
    }

}
