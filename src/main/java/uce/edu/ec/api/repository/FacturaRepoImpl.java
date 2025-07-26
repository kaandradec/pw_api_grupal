package uce.edu.ec.api.repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.TransactionScoped;
import uce.edu.ec.api.repository.modelo.Factura;

@TransactionScoped
@ApplicationScoped
public class FacturaRepoImpl implements IFacturaRepo{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void crearFactura(Factura factura) {
        this.entityManager.persist(factura);
  }

    @Override
    public List<Factura> consultarTodas() {
          TypedQuery<Factura> myquery = this.entityManager.createQuery("SELEC f FROM Factura f",Factura.class );
        return myquery.getResultList();
    }

}
