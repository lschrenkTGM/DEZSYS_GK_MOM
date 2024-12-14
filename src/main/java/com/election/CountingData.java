package com.election;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CountingData {
    @JsonProperty("parties")
    private List<Party> parties;

    // Getter und Setter
    public List<Party> getParties() {
        return parties;
    }

    public void setParties(List<Party> parties) {
        this.parties = parties;
    }
}
