package br.com.springframework.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CNPJ;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name="fornecedor")
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 64)
    @NotBlank(message = "Este campo é obrigatório.")
    @Size(min= 3, max = 64, message = "O nome fantasia deve ter entre 3 e 64 caracteres")
    private String nomeFantasia;

    @Column(nullable = false, length = 64)
    @NotBlank(message = "Este campo é obrigatório.")
    @Size(min= 3, max = 64, message = "A razão social deve ter entre 3 e 64 caracteres")
    private String razaoSocial;

    @Column(length = 18)
    @NotNull(message = "Este campo é obrigatório.")
    @CNPJ(message = "CNPJ ínvalido.")
    private String cnpj;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "dataNascimento", columnDefinition = "DATE")
    @NotNull(message = "Este campo é obrigatório.")
    private LocalDate dataNascimento;

    @Column(length = 14)
    private String telefone;

    @Column(length = 15)
    private String celular;

    @Column(length = 100)
    @Email
    private String email;

    @Column(length = 10)
    private boolean ativo;

    public Fornecedor() {
        this.ativo = true;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}