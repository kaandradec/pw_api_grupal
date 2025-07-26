package uce.edu.ec.api.repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.TransactionScoped;
import uce.edu.ec.api.repository.modelo.Impuesto;

@TransactionScoped
@ApplicationScoped
public class ImpuestoRepoImpl implements IImpuestoRepo{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void crearImpuesto(Impuesto impuesto) {
        this.entityManager.persist(impuesto);
    }

    @Override
    public List<Impuesto> buscarTodos() {
        TypedQuery<Impuesto> myQuery =this.entityManager.createQuery("SELECT i FROM Impuesto i", Impuesto.class);
        return myQuery.getResultList();
    }

    @Override
    public Impuesto buscarPorId(Integer id) {
        return this.entityManager.find(Impuesto.class, id);
   }

    @Override
    public Impuesto buscarPorNombre(String nombre) {
    return this.entityManager.find(Impuesto.class, nombre);
}

    @Override
    public void actualizarParcialImpuesto(Impuesto impuesto) {
   this.entityManager.merge(impuesto);
 }

    @Override
    public void eliminarImpuesto(Integer id) {
      Impuesto impu =this.buscarPorId(id);
      this.entityManager.remove(impu);

    }

}
