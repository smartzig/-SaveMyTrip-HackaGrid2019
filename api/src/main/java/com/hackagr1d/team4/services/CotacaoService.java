package com.hackagr1d.team4.services;

import com.hackagr1d.team4.domain.model.Cotacao;

import com.hackagr1d.team4.rest.RestClient;
import com.hackagr1d.team4.rest.vo.CotacaoRequest;
import com.hackagr1d.team4.rest.vo.CotacaoResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CotacaoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CotacaoService.class);
    private RestClient restClient;

    @Autowired
    public CotacaoService(final RestClient restClient){
        this.restClient = restClient;
    }

    public CotacaoResponse getCotacoes(CotacaoRequest request) {

        LOGGER.info("[Travelace - Seguro Viagens] Buscado cotações - Request["+request +"].");

        try{
            final String url = "https://gateway.gr1d.io/sandbox/travelace/v1/Cotacao";

            final Map<String, String> headers = new HashMap<>();
            headers.put("Content-Type","application/json");
            headers.put("X-Api-Key","b7483bb4-f7f9-4521-a047-223fc550a1cb");

            restClient.postForObject(url, headers, Void.class, request);
            //Mocking response for presentation.
        }catch(Exception e){
            ;
        }


        CotacaoResponse response =new CotacaoResponse();
        List<Cotacao> cotacoes = new ArrayList<>();
        {
            Cotacao cotacao = new Cotacao();
            cotacao.setDescricao("Seguro de Viagem completo plus" +
                    "Despesas Médicas, Hospitalares e/ou Odontológicas - DMHO - R$ 10.000,00\n" +
                    "Morte acidental - R$ 80.000,00\n" +
                    "Invalidez Permanente Total ou Parcial por Acidente - R$ 80.000,00");
            cotacao.setDataSaida("20-12-2019");
            cotacao.setDataRetorno("31-12-2019");
            cotacao.setOperadora("Travel Ace");
            cotacao.setFormaPagamento("Cartão de Crédito");
            cotacao.setValorCompra("R$ 80,00");
            cotacao.setImgUrl("https://www.multiseguroviagem.com.br/www/img/operadoras/hq/travelace.png");
            cotacoes.add(cotacao);
        }

        {
            Cotacao cotacao = new Cotacao();
            cotacao.setDescricao("Seguro de Viagem completo Supreme" +
                    "Despesas Médicas, Hospitalares e/ou Odontológicas - DMHO - R$ 20.000,00\n" +
                    "Morte acidental - R$ 100.000,00\n" +
                    "Invalidez Permanente Total ou Parcial por Acidente - R$ 100.000,00");
            cotacao.setDataSaida("20-12-2019");
            cotacao.setDataRetorno("31-12-2019");
            cotacao.setOperadora("Porto Seguro");
            cotacao.setFormaPagamento("Cartão de Crédito");
            cotacao.setValorCompra("R$ 120,00");
            cotacao.setImgUrl("https://www.comparaonline.com.br/blog/wp-content/uploads/2015/10/logo-porto-seguro-1280x720.png");
            cotacoes.add(cotacao);
        }


        response.setCotacoes(cotacoes);

        LOGGER.info("[Travelace - Seguro Viagens] Resposta ["+response +"]");
        return response;
    }
}
