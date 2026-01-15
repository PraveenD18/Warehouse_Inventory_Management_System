package com.wims.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "inventory", uniqueConstraints = @UniqueConstraint(columnNames = { "item_id", "bin_id" }))
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Item item;

	@ManyToOne
	private Location bin;

	private int qtyOnHand;
	private int qtyReserved;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Location getBin() {
		return bin;
	}

	public void setBin(Location bin) {
		this.bin = bin;
	}

	public int getQtyOnHand() {
		return qtyOnHand;
	}

	public void setQtyOnHand(int qtyOnHand) {
		this.qtyOnHand = qtyOnHand;
	}

	public int getQtyReserved() {
		return qtyReserved;
	}

	public void setQtyReserved(int qtyReserved) {
		this.qtyReserved = qtyReserved;
	}

}
