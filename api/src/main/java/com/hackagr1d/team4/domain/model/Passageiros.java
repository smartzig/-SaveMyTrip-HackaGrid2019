package com.hackagr1d.team4.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Passageiros extends GenericLoggableObject {

    @JsonProperty
    @NotNull
    @Size(max = 255)
    @ApiModelProperty(value = "Nome do passageiro.", example ="Tony Ramos", required = true)
    private String nome;

    @JsonProperty
    @NotNull
    @ApiModelProperty(
            example = "1985-03-04T00:00:00.000Z",
            notes =
                    "Data de nascimento. formato de UTC timezone. https://en.wikipedia.org/wiki/ISO_8601")
    private String dataNascimento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
