package uce.edu.ec.api.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.ec.api.repository.IClienteRepo;
import uce.edu.ec.api.service.to.ClienteTo;

@ApplicationScoped
public class ClienteServImpl implements IClienteServi{
    @Inject
    private IClienteRepo iClienteRepo;

    @Override
    public void crearCliente(ClienteTo clienteTo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearCliente'");
    }

    @Override
    public List<ClienteTo> buscarTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarTodos'");
    }

    @Override
    public ClienteTo bucarCliente(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'bucarCliente'");
    }

    @Override
    public ClienteTo buscarPorcedula(String cedula) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorcedula'");
    }

    @Override
    public void actualizarCliente(ClienteTo clienteTo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarCliente'");
    }

    @Override
    public void actualizarClienteParcial(ClienteTo clienteTo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarClienteParcial'");
    }

    @Override
    public void eliminarCliente(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarCliente'");
    }

    

}
