package com.wims.entity;



import jakarta.persistence.*;

@Entity
@Table(name = "sales_order_items")
public class SalesOrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private SalesOrder salesOrder;

    @ManyToOne
    private Item item;

    private int orderedQty;
    private int allocatedQty;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public SalesOrder getSalesOrder() {
		return salesOrder;
	}
	public void setSalesOrder(SalesOrder salesOrder) {
		this.salesOrder = salesOrder;
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
	public int getAllocatedQty() {
		return allocatedQty;
	}
	public void setAllocatedQty(int allocatedQty) {
		this.allocatedQty = allocatedQty;
	}

    
}
