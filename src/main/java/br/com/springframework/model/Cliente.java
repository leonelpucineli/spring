package br.com.springframework.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@Entity
@Table(name="cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 64)
    @NotBlank(message = "Este campo é obrigatório.")
    @Size(min= 3, max = 64, message = "O nome deve ter entre 3 e 64 caracteres")
    private String nome;

    @Column(length = 14)
    @NotNull(message = "Este campo é obrigatório.")
    private String cpf;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "dataNascimento", columnDefinition = "DATE")
    @NotNull(message = "Este campo é obrigatório.")
    private LocalDate dataNascimento;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Este campo é obrigatório.")
    private Sexo sexo;

    @Column(length = 14)
    private String telefone;

    @Column(length = 15)
    private String celular;

    @Column(length = 100)
    @Email
    private String email;

    @Column(length = 10)
    private boolean ativo;

    public Cliente() {
        this.ativo = true;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
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

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}