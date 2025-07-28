package uce.edu.ec.api.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.ec.api.repository.IClienteRepo;
import uce.edu.ec.api.repository.modelo.Cliente;
import uce.edu.ec.api.repository.modelo.dto.ClienteTo;
import uce.edu.ec.api.service.mapper.ClienteMapper;

@ApplicationScoped
public class ClienteServiceImpl implements IClienteService {

    @Inject
    private IClienteRepo iClienteRepo;

    @Override
    public void crear(ClienteTo clienteTo) {
        // Validar que la cédula no esté duplicada
        if (clienteTo.getCedula() != null) {
            Cliente clienteExistente = iClienteRepo.buscarPorCedula(clienteTo.getCedula());
            if (clienteExistente != null) {
                throw new RuntimeException("Ya existe un cliente con la cédula: " + clienteTo.getCedula());
            }
        }
        
        Cliente cliente = ClienteMapper.convertir(clienteTo);
        iClienteRepo.insertar(cliente);
    }

    @Override
    public void actualizar(ClienteTo clienteTo) {
        if (clienteTo.getId() == null) {
            throw new RuntimeException("ID de cliente es requerido para actualizar");
        }
        
        Cliente clienteExistente = iClienteRepo.buscarPorId(clienteTo.getId());
        if (clienteExistente == null) {
            throw new RuntimeException("Cliente no encontrado");
        }
        
        // Validar que la cédula no esté duplicada (excluyendo el cliente actual)
        if (clienteTo.getCedula() != null && !clienteTo.getCedula().equals(clienteExistente.getCedula())) {
            Cliente clienteConCedula = iClienteRepo.buscarPorCedula(clienteTo.getCedula());
            if (clienteConCedula != null) {
                throw new RuntimeException("Ya existe un cliente con la cédula: " + clienteTo.getCedula());
            }
        }
        
        Cliente cliente = ClienteMapper.convertir(clienteTo);
        iClienteRepo.actualizar(cliente);
    }

    @Override
    public ClienteTo buscarPorId(Integer id) {
        Cliente cliente = iClienteRepo.buscarPorId(id);
        return ClienteMapper.convertir(cliente);
    }

    @Override
    public List<ClienteTo> buscarTodos() {
        List<Cliente> clientes = iClienteRepo.buscarTodos();
        return clientes.stream()
                .map(ClienteMapper::convertir)
                .toList();
    }

    @Override
    public void eliminar(Integer id) {
        Cliente cliente = iClienteRepo.buscarPorId(id);
        if (cliente == null) {
            throw new RuntimeException("Cliente no encontrado");
        }
        iClienteRepo.eliminar(id);
    }

    @Override
    public ClienteTo buscarPorCedula(String cedula) {
        Cliente cliente = iClienteRepo.buscarPorCedula(cedula);
        return ClienteMapper.convertir(cliente);
    }
} 