package br.com.zup.esportcenter.services;

import br.com.zup.esportcenter.dtos.ClienteDTO;
import br.com.zup.esportcenter.exceptions.ClienteDuplicadoException;
import br.com.zup.esportcenter.exceptions.ClienteNaoEncontradoException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ClienteService {
    private List<ClienteDTO> listaDeClientes = new ArrayList<>();

    // Método para cadastrar Clientes
    public ClienteDTO cadastrarClientes(ClienteDTO cliente){
        validaCpfDuplicado(cliente);
        listaDeClientes.add(cliente);
        return cliente;
    }
    // Método para validar CPF dublicado
    public void validaCpfDuplicado(ClienteDTO clienteDTO){
        for (ClienteDTO item:listaDeClientes) {
            if (item.getCpf().equals(clienteDTO.getCpf())){
                throw new ClienteDuplicadoException("CPF Duplicado!");
            }
        }
    }
    // Método para buscar clientes por CPF
    public ClienteDTO buscarClientesPorCpf(String cpf){
        for (ClienteDTO objCliente:listaDeClientes) {
            if (objCliente.getCpf().equals(cpf)) {
                return objCliente;
            }
        }
        throw new ClienteNaoEncontradoException("Cliente não encontrado!");
    }


}
