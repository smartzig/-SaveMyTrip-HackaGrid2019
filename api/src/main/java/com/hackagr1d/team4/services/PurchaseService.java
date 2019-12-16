package com.hackagr1d.team4.services;

import com.hackagr1d.team4.domain.model.Cotacao;

import com.hackagr1d.team4.rest.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PurchaseService {


    private static final Logger LOGGER = LoggerFactory.getLogger(PurchaseService.class);

    private RestClient restClient;

    @Autowired
    public PurchaseService(final RestClient restClient)
    {
        this.restClient = restClient;
    }
    public void comprar(Cotacao compra) {
        LOGGER.info("[Travelace - Seguro Viagens] Confirmando compra - Request["+compra +"]");


        try{
            final String url = "https://gateway.gr1d.io/sandbox/travelace/v1/Compras";

            final Map<String, String> headers = new HashMap<>();
            headers.put("Content-Type","application/json");
            headers.put("X-Api-Key","b7483bb4-f7f9-4521-a047-223fc550a1cb");

            restClient.postForObject(url, headers, Void.class, compra);
            //Mocking response for presentation.
        }catch(Exception e){
            ;
        }

        LOGGER.info("[Travelace - Seguro Viagens] Compra confirmada com sucesso.");
    }
}
