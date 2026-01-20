package com.wims.dto.response;

import com.wims.enums.StockMovementType;

import java.time.LocalDateTime;

public class StockMovementResponse {

    private Long id;
    private StockMovementType movementType;
    private String itemSku;
    private String fromBin;
    private String toBin;
    private int qty;
    private String performedBy;
    private LocalDateTime performedAt;

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

    public String getItemSku() {
        return itemSku;
    }

    public void setItemSku(String itemSku) {
        this.itemSku = itemSku;
    }

    public String getFromBin() {
        return fromBin;
    }

    public void setFromBin(String fromBin) {
        this.fromBin = fromBin;
    }

    public String getToBin() {
        return toBin;
    }

    public void setToBin(String toBin) {
        this.toBin = toBin;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getPerformedBy() {
        return performedBy;
    }

    public void setPerformedBy(String performedBy) {
        this.performedBy = performedBy;
    }

    public LocalDateTime getPerformedAt() {
        return performedAt;
    }

    public void setPerformedAt(LocalDateTime performedAt) {
        this.performedAt = performedAt;
    }
}
