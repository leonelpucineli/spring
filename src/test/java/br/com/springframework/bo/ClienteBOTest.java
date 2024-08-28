package br.com.springframework.bo;

import br.com.springframework.model.Cliente;
import br.com.springframework.model.Sexo;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClienteBOTest {
    @Autowired
    private ClienteBO bo;

    @Test
    @Order(1)
    public void insere(){
        Cliente cliente = new Cliente();
        cliente.setNome("José da Silva Cabrito");
        cliente.setCpf("01234567890");
        cliente.setDataNascimento(LocalDate.of(2000, 1, 8));
        cliente.setSexo(Sexo.MASCULINO);
        cliente.setTelefone("0123456789");
        cliente.setCelular("01234567890");
        cliente.setAtivo(true);

        bo.insere(cliente);
    }
    @Test
    @Order(2)
    public void pesquisaPeloId(){
        Cliente cliente = bo.pesquisaPeloId(1L);
        System.out.println(cliente);
    }

    @Test
    @Order(3)
    public void atualiza(){
        Cliente cliente = bo.pesquisaPeloId(1L);
        cliente.setCpf("98765432100");
        bo.atualiza(cliente);
    }


}
