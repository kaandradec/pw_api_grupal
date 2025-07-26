package uce.edu.ec.api.service;

import java.util.List;

import uce.edu.ec.api.service.to.ClienteTo;


public interface IClienteServi {
    void crearCliente(ClienteTo clienteTo);

    List<ClienteTo> buscarTodos();

    ClienteTo bucarCliente(Integer id);

    ClienteTo buscarPorcedula(String cedula);

    void actualizarCliente(ClienteTo clienteTo);

    void actualizarClienteParcial(ClienteTo clienteTo);

    void eliminarCliente(Integer id);
}
