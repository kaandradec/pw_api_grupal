package uce.edu.ec.api.repository;

import java.util.List;

import uce.edu.ec.api.repository.modelo.Cliente;

public interface IClienteRepo {
    void crearCliente(Cliente cliente);

    List<Cliente> buscarTodos();

    Cliente bucarCliente(Integer id);

    Cliente buscarPorcedula(String cedula);

    void actualizarCliente(Cliente cliente);

    void actualizarClienteParcial(Cliente cliente);

    void eliminarCliente(Integer id);
}
