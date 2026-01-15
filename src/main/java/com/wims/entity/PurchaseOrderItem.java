package com.wims.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "purchase_order_items")
public class PurchaseOrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private PurchaseOrder purchaseOrder;

    @ManyToOne
    private Item item;

    private int orderedQty;
    private int receivedQty;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}
	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public int getOrderedQty() {
		return orderedQty;
	}
	public void setOrderedQty(int orderedQty) {
		this.orderedQty = orderedQty;
	}
	public int getReceivedQty() {
		return receivedQty;
	}
	public void setReceivedQty(int receivedQty) {
		this.receivedQty = receivedQty;
	}

    
}
