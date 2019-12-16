package com.hackagr1d.team4.domain.model;

import com.fasterxml.jackson.annotation.*;
import com.hackagr1d.team4.rest.vo.PaymentRequest;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "cardType",
        "cardNumber",
        "expirationMonth",
        "expirationYear",
        "cvv",
        "nameOnCard",
        "holderTaxId"
})
public class CreditCard extends GenericLoggableObject{

    @JsonProperty("cardType")
    private String cardType;
    @JsonProperty("cardNumber")
    private String cardNumber;
    @JsonProperty("expirationMonth")
    private String expirationMonth;
    @JsonProperty("expirationYear")
    private String expirationYear;
    @JsonProperty("cvv")
    private String cvv;
    @JsonProperty("nameOnCard")
    private String nameOnCard;
    @JsonProperty("holderTaxId")
    private HolderTaxId holderTaxId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("cardType")
    public String getCardType() {
        return cardType;
    }

    @JsonProperty("cardType")
    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    @JsonProperty("cardNumber")
    public String getCardNumber() {
        return cardNumber;
    }

    @JsonProperty("cardNumber")
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @JsonProperty("expirationMonth")
    public String getExpirationMonth() {
        return expirationMonth;
    }

    @JsonProperty("expirationMonth")
    public void setExpirationMonth(String expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    @JsonProperty("expirationYear")
    public String getExpirationYear() {
        return expirationYear;
    }

    @JsonProperty("expirationYear")
    public void setExpirationYear(String expirationYear) {
        this.expirationYear = expirationYear;
    }

    @JsonProperty("cvv")
    public String getCvv() {
        return cvv;
    }

    @JsonProperty("cvv")
    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    @JsonProperty("nameOnCard")
    public String getNameOnCard() {
        return nameOnCard;
    }

    @JsonProperty("nameOnCard")
    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    @JsonProperty("holderTaxId")
    public HolderTaxId getHolderTaxId() {
        return holderTaxId;
    }

    @JsonProperty("holderTaxId")
    public void setHolderTaxId(HolderTaxId holderTaxId) {
        this.holderTaxId = holderTaxId;
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
