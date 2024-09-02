package br.com.springframework.bo;

import br.com.springframework.dao.CRUD;
import br.com.springframework.dao.ClienteDAO;
import br.com.springframework.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteBO implements CRUD<Cliente, Long> {
    @Autowired
    private ClienteDAO dao;

    @Override
    public Cliente pesquisaPeloId(Long id) {
        return dao.pesquisaPeloId(id);
    }

    @Override
    public List<Cliente> lista() {
        return dao.lista();
    }

    @Override
    public void insere(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não pode ser nulo");
        }
        dao.insere(cliente);
    }

    @Override
    public void atualiza(Cliente cliente) {
        dao.atualiza(cliente);
    }

    @Override
    public void remove(Cliente cliente) {
        dao.remove(cliente);
    }

    public void inativa(Cliente cliente){
        cliente.setAtivo(false);
        dao.atualiza(cliente);
    }

    public void ativa(Cliente cliente){
        cliente.setAtivo(true);
        dao.atualiza(cliente);
    }
}
