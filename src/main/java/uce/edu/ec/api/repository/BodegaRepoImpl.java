package uce.edu.ec.api.repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.TransactionScoped;
import uce.edu.ec.api.repository.modelo.Bodega;

@TransactionScoped
@ApplicationScoped
public class BodegaRepoImpl implements IBodegaRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void crearBodega(Bodega bodega) {
        this.entityManager.persist(bodega);

    }

    @Override
    public Bodega buscarPorCodigo(String codigoB){
          try {
            TypedQuery<Bodega> query = this.entityManager
                    .createQuery("SELECT b FROM Bodega b WHERE b.codigo = :codigo", Bodega.class);
            query.setParameter("codigo", codigoB);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    @Override
    public List<Bodega> buscarTodos() {
        TypedQuery<Bodega> myquery = this.entityManager.createQuery("SELEC b FROM Bodega b",Bodega.class );
        return myquery.getResultList();
    }
@Override
public Bodega buscarPorId(Integer id){
    return this.entityManager.find(Bodega.class, id);
}
    @Override
    public void actualizarBodega(Bodega bodega) {
        this.entityManager.merge(bodega);
    }

    @Override
    public void eliminarBodega(Integer id) {
        Bodega bodega = this.buscarPorId(id);
        this.entityManager.remove(bodega);

    }

}
