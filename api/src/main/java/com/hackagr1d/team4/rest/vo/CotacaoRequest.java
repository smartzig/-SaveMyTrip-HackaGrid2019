package com.hackagr1d.team4.rest.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hackagr1d.team4.domain.model.GenericLoggableObject;
import com.hackagr1d.team4.domain.model.Passageiros;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

public class CotacaoRequest extends GenericLoggableObject {

    @JsonProperty
    @ApiModelProperty(value = "Lista de países visitados", example = "[\"GRANADA\",\"ARGENTINA\"]", required = true)
    List<String> destinos = new ArrayList<>();

    @JsonProperty
    @ApiModelProperty(value = "Lista de passageiros",  required = true)
    List<Passageiros> passageiros = new ArrayList<>();
    private String dataSaida;


    private String dataRetorno;

    @JsonProperty
    @ApiModelProperty(value = "Tipo da viagem.", example ="1")
    private Integer tipoViagem;

    @JsonProperty
    @ApiModelProperty(value = "Tipo da tarifa.", example ="1")
    private Integer tipoTarifa;


    public List<String> getDestinos() {
        return destinos;
    }

    public void setDestinos(List<String> destinos) {
        this.destinos = destinos;
    }

    public List<Passageiros> getPassageiros() {
        return passageiros;
    }

    public void setPassageiros(List<Passageiros> passageiros) {
        this.passageiros = passageiros;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getDataRetorno() {
        return dataRetorno;
    }

    public void setDataRetorno(String dataRetorno) {
        this.dataRetorno = dataRetorno;
    }

    public Integer getTipoViagem() {
        return tipoViagem;
    }

    public void setTipoViagem(Integer tipoViagem) {
        this.tipoViagem = tipoViagem;
    }

    public Integer getTipoTarifa() {
        return tipoTarifa;
    }

    public void setTipoTarifa(Integer tipoTarifa) {
        this.tipoTarifa = tipoTarifa;
    }
}
