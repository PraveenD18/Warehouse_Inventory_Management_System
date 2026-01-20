package com.wims.mapper;

import com.wims.dto.response.StockMovementResponse;
import com.wims.entity.Location;
import com.wims.entity.StockMovement;

public class StockMovementMapper {

    public static StockMovementResponse toResponse(StockMovement sm) {

        StockMovementResponse res = new StockMovementResponse();
        res.setId(sm.getId());
        res.setMovementType(sm.getMovementType());
        res.setQty(sm.getQty());
        res.setPerformedAt(sm.getPerformedAt());

        res.setItemSku(sm.getItem().getSku());
        res.setPerformedBy(sm.getPerformedBy().getName());

        Location from = sm.getFromBin();
        Location to = sm.getToBin();

        res.setFromBin(from != null
                ? from.getZone() + "-" + from.getAisle() + "-" + from.getRack() + "-" + from.getBin()
                : null);

        res.setToBin(to != null
                ? to.getZone() + "-" + to.getAisle() + "-" + to.getRack() + "-" + to.getBin()
                : null);

        return res;
    }
}
