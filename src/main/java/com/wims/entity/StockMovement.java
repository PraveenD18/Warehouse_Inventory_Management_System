package com.wims.entity;

import com.wims.enums.StockMovementType;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "stock_movements")
public class StockMovement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private StockMovementType movementType;

    @ManyToOne
    private Item item;

    @ManyToOne
    private Location fromBin;

    @ManyToOne
    private Location toBin;

    private int qty;

    @ManyToOne
    private User performedBy;

    private LocalDateTime performedAt;

    @PrePersist
    void onCreate() {
        this.performedAt = LocalDateTime.now();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StockMovementType getMovementType() {
		return movementType;
	}

	public void setMovementType(StockMovementType movementType) {
		this.movementType = movementType;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Location getFromBin() {
		return fromBin;
	}

	public void setFromBin(Location fromBin) {
		this.fromBin = fromBin;
	}

	public Location getToBin() {
		return toBin;
	}

	public void setToBin(Location toBin) {
		this.toBin = toBin;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public User getPerformedBy() {
		return performedBy;
	}

	public void setPerformedBy(User performedBy) {
		this.performedBy = performedBy;
	}

	public LocalDateTime getPerformedAt() {
		return performedAt;
	}

	public void setPerformedAt(LocalDateTime performedAt) {
		this.performedAt = performedAt;
	}

    
	
}

