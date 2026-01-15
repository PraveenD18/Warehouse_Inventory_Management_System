package com.wims.entity;

import com.wims.enums.PickTaskStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "pick_tasks")
public class PickTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private SalesOrder salesOrder;

    @ManyToOne
    private Item item;

    private int qty;

    @ManyToOne
    private User assignedTo;

    @Enumerated(EnumType.STRING)
    private PickTaskStatus status;

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

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public User getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(User assignedTo) {
		this.assignedTo = assignedTo;
	}

	public PickTaskStatus getStatus() {
		return status;
	}

	public void setStatus(PickTaskStatus status) {
		this.status = status;
	}

    
}
