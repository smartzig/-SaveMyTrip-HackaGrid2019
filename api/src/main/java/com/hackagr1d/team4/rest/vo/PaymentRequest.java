package com.hackagr1d.team4.rest.vo;

import com.fasterxml.jackson.annotation.*;
import com.hackagr1d.team4.domain.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaymentRequest extends GenericLoggableObject {


    @JsonProperty("totalAmount")
    private String totalAmount;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("externalIdentifier")
    private String externalIdentifier;
    @JsonProperty("sender")
    private Sender sender;
    @JsonProperty("paymentInfo")
    private PaymentInfo paymentInfo;
    @JsonProperty("recipients")
    private List<Recipient> recipients = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    private Cotacao compra;

    public Cotacao getCompra() {
        return compra;
    }

    public void setCompra(Cotacao compra) {
        this.compra = compra;
    }

    @JsonProperty("totalAmount")
    public String getTotalAmount() {
        return totalAmount;
    }

    @JsonProperty("totalAmount")
    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonProperty("externalIdentifier")
    public String getExternalIdentifier() {
        return externalIdentifier;
    }

    @JsonProperty("externalIdentifier")
    public void setExternalIdentifier(String externalIdentifier) {
        this.externalIdentifier = externalIdentifier;
    }

    @JsonProperty("sender")
    public Sender getSender() {
        return sender;
    }

    @JsonProperty("sender")
    public void setSender(Sender sender) {
        this.sender = sender;
    }

    @JsonProperty("paymentInfo")
    public PaymentInfo getPaymentInfo() {
        return paymentInfo;
    }

    @JsonProperty("paymentInfo")
    public void setPaymentInfo(PaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    @JsonProperty("recipients")
    public List<Recipient> getRecipients() {
        return recipients;
    }

    @JsonProperty("recipients")
    public void setRecipients(List<Recipient> recipients) {
        this.recipients = recipients;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }













}
