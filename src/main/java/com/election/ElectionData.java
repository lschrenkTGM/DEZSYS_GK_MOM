package com.election;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ElectionData {
    @JsonProperty("regionID")
    private String regionID;

    @JsonProperty("regionName")
    private String regionName;

    @JsonProperty("regionAddress")
    private String regionAddress;

    @JsonProperty("regionPostalCode")
    private String regionPostalCode;

    @JsonProperty("federalState")
    private String federalState;

    @JsonProperty("timestamp")
    private String timestamp;

    @JsonProperty("countingData")
    private CountingData countingData;

    // Getter und Setter
    public String getRegionID() {
        return regionID;
    }

    public void setRegionID(String regionID) {
        this.regionID = regionID;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getRegionAddress() {
        return regionAddress;
    }

    public void setRegionAddress(String regionAddress) {
        this.regionAddress = regionAddress;
    }

    public String getRegionPostalCode() {
        return regionPostalCode;
    }

    public void setRegionPostalCode(String regionPostalCode) {
        this.regionPostalCode = regionPostalCode;
    }

    public String getFederalState() {
        return federalState;
    }

    public void setFederalState(String federalState) {
        this.federalState = federalState;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public CountingData getCountingData() {
        return countingData;
    }

    public void setCountingData(CountingData countingData) {
        this.countingData = countingData;
    }
}
