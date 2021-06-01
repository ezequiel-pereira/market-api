package com.eze.market.persistance.entity;

import javax.persistence.*;

@Entity
@Table(name = "compras_productos")
public class PurchaseProducts {
    @EmbeddedId
    private PurchaseProductsPK id;

    @Column(name = "cantidad")
    private Integer quantity;

    @Column(name = "total")
    private Double total;

    @Column(name = "estado")
    private Boolean status;

    @ManyToOne
    @MapsId("saleId")
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private Purchase purchase;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Product product;

    public PurchaseProductsPK getId() {
        return id;
    }

    public void setId(PurchaseProductsPK id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
