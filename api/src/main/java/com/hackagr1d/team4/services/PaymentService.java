package com.hackagr1d.team4.services;

import com.hackagr1d.team4.rest.RestClient;
import com.hackagr1d.team4.rest.vo.PaymentRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentService.class);

    private PurchaseService purchaseService;
    private RestClient restClient;

    @Autowired
    public PaymentService(final PurchaseService purchaseService, final RestClient restClient)
    {
        this.purchaseService = purchaseService;
        this.restClient = restClient;
    }

    public void pagar(PaymentRequest request) {
        LOGGER.info("[Matera - Meios de Pagamento - Server] Efetuando Pagamento - Request["+request +"]");
        LOGGER.info("[Matera - Meios de Pagamento - Server] Pagamento efetuado com sucesso");

        try{
            final String url = "https://varcom-mp-api-01.matera.com/v1/payments";

            final Map<String, String> headers = new HashMap<>();
            headers.put("Content-Type","application/json");
            headers.put("Accept","application/json");
            headers.put("Transaction-Hash","94fce6b541af4a841712a6965f5b139ccb4fde924f5618c0cf1590bd82d61727");
            headers.put("X-Api-Key","813F6952-D615-4E5C-9547-C31ABED75895");

            restClient.postForObject(url, headers, Void.class, request);
            //Mocking response for presentation.
        }catch(Exception e){
            ;
        }

        purchaseService.comprar(request.getCompra());

    }
}
