package uce.edu.ec.api.repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.TransactionScoped;
import uce.edu.ec.api.repository.modelo.Cliente;

@TransactionScoped
@ApplicationScoped
public class ClienteRepoImpl implements IClienteRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void crearCliente(Cliente cliente) {
        this.entityManager.persist(cliente);
    }
@Override
    public List<Cliente> buscarTodos() {
        TypedQuery<Cliente> myQuery = this.entityManager.createQuery("SELECT c FROM Cliente c", Cliente.class);
        return myQuery.getResultList();
    }
    @Override
    public Cliente bucarCliente(Integer id) {
        return this.entityManager.find(Cliente.class, id);

    }

      @Override
    public Cliente buscarPorcedula(String cedula) {
        return this.entityManager.find(Cliente.class, cedula);

    }
    @Override
    public void actualizarCliente(Cliente cliente) {
        this.entityManager.merge(cliente);
    }
      @Override
    public void actualizarClienteParcial(Cliente cliente) {
        this.entityManager.merge(cliente);
    }

    @Override
    public void eliminarCliente(Integer id) {
    Cliente cliente = this.bucarCliente(id);
    this.entityManager.remove(cliente);
    }

}
