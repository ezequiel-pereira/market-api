package com.eze.market.domain;

import java.time.LocalDateTime;
import java.util.List;

public class PurchaseDomain {
    private int purchaseId;
    private String clientId;
    private LocalDateTime purchaseDate;
    private String paymentMethod;
    private String comment;
    private Boolean status;
    private List<PurchaseProductDomain> items;

    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<PurchaseProductDomain> getItems() {
        return items;
    }

    public void setItems(List<PurchaseProductDomain> items) {
        this.items = items;
    }
}
