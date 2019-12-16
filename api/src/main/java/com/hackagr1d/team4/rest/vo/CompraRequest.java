package com.hackagr1d.team4.rest.vo;

import com.hackagr1d.team4.domain.model.Cotacao;
import com.hackagr1d.team4.domain.model.GenericLoggableObject;

public class CompraRequest extends GenericLoggableObject {

    private Cotacao compra;

    public Cotacao getCompra() {
        return compra;
    }

    public void setCompra(Cotacao compra) {
        this.compra = compra;
    }
}
