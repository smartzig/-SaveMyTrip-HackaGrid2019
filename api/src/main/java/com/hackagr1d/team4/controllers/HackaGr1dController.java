package com.hackagr1d.team4.controllers;


import com.hackagr1d.team4.helpers.ApiConstants;
import com.hackagr1d.team4.rest.vo.CompraRequest;
import com.hackagr1d.team4.rest.vo.CotacaoRequest;
import com.hackagr1d.team4.rest.vo.CotacaoResponse;
import com.hackagr1d.team4.rest.vo.PaymentRequest;
import com.hackagr1d.team4.services.CotacaoService;
import com.hackagr1d.team4.services.PaymentService;
import com.hackagr1d.team4.services.PurchaseService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
@Api(tags = { ApiConstants.API_NAME })
public class HackaGr1dController {

    private CotacaoService cotacaoService;
    private PaymentService paymentService;

    @Autowired
    public HackaGr1dController(
            final CotacaoService cotacaoService, final PaymentService paymentService) {
        this.cotacaoService = cotacaoService;
        this.paymentService = paymentService;


    }

    @ApiOperation(value = "Retorna lista de cotações", response = CotacaoResponse.class)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE, path="/cotacao")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 403, message = "Forbidden"), @ApiResponse(code = 404, message = "Not Found") })
    public ResponseEntity<CotacaoResponse> cotacao(
            @Valid @RequestBody final CotacaoRequest request) {
            return new ResponseEntity(cotacaoService.getCotacoes(request), HttpStatus.OK);




    }

    @ApiOperation(value = "Efetua o pagamento")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, path="/pagamento")
    public ResponseEntity<Void> pagamento(@Valid @RequestBody final PaymentRequest request) {

        paymentService.pagar(request);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}

