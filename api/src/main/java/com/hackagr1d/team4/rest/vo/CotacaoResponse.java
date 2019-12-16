package com.hackagr1d.team4.rest.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hackagr1d.team4.domain.model.Cotacao;
import com.hackagr1d.team4.domain.model.GenericLoggableObject;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

public class CotacaoResponse extends GenericLoggableObject {

    @JsonProperty
    @ApiModelProperty(value = "Lista de cotacoes")
    List<Cotacao> cotacoes = new ArrayList<>();

    public List<Cotacao> getCotacoes() {
        return cotacoes;
    }

    public void setCotacoes(List<Cotacao> cotacoes) {
        this.cotacoes = cotacoes;
    }
}
