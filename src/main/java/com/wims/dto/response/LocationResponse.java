package com.wims.dto.response;

import com.wims.enums.BinType;

public class LocationResponse {

    private Long id;
    private String zone;
    private String aisle;
    private String rack;
    private String bin;
    private BinType binType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getAisle() {
        return aisle;
    }

    public void setAisle(String aisle) {
        this.aisle = aisle;
    }

    public String getRack() {
        return rack;
    }

    public void setRack(String rack) {
        this.rack = rack;
    }

    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public BinType getBinType() {
        return binType;
    }

    public void setBinType(BinType binType) {
        this.binType = binType;
    }
}
