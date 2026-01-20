package com.wims.dto.request;

import com.wims.enums.StockMovementType;

public class CreateStockMovementRequest {

    private StockMovementType movementType;
    private Long itemId;
    private Long fromBinId;
    private Long toBinId;
    private int qty;
    private Long performedByUserId;

    public StockMovementType getMovementType() {
        return movementType;
    }

    public void setMovementType(StockMovementType movementType) {
        this.movementType = movementType;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getFromBinId() {
        return fromBinId;
    }

    public void setFromBinId(Long fromBinId) {
        this.fromBinId = fromBinId;
    }

    public Long getToBinId() {
        return toBinId;
    }

    public void setToBinId(Long toBinId) {
        this.toBinId = toBinId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Long getPerformedByUserId() {
        return performedByUserId;
    }

    public void setPerformedByUserId(Long performedByUserId) {
        this.performedByUserId = performedByUserId;
    }
}
