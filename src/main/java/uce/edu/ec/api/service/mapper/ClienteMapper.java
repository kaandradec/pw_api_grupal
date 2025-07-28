package uce.edu.ec.api.service.mapper;

import uce.edu.ec.api.repository.modelo.Cliente;
import uce.edu.ec.api.repository.modelo.dto.ClienteTo;

public class ClienteMapper {
    
    public static ClienteTo convertir(Cliente cliente) {
        if (cliente == null) {
            return null;
        }
        
        return new ClienteTo(
            cliente.getId(),
            cliente.getCedula(),
            cliente.getNombre(),
            cliente.getApellido(),
            cliente.getRazonSocial(),
            cliente.getDireccion(),
            cliente.getTelefono(),
            cliente.getCorreo()
        );
    }
    
    public static Cliente convertir(ClienteTo clienteTo) {
        if (clienteTo == null) {
            return null;
        }
        
        Cliente cliente = new Cliente();
        cliente.setId(clienteTo.getId());
        cliente.setCedula(clienteTo.getCedula());
        cliente.setNombre(clienteTo.getNombre());
        cliente.setApellido(clienteTo.getApellido());
        cliente.setRazonSocial(clienteTo.getRazonSocial());
        cliente.setDireccion(clienteTo.getDireccion());
        cliente.setTelefono(clienteTo.getTelefono());
        cliente.setCorreo(clienteTo.getCorreo());
        
        return cliente;
    }
} 