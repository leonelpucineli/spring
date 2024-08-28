package br.com.springframework.model;

public enum Sexo {
    MASCULINO("Masculino"),
    FEMININO("Femnino");

    private String descricao;

    Sexo(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }
}