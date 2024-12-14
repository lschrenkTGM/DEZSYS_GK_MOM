package com.election;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Party {
    @JsonProperty("partyID")
    private String partyID;

    @JsonProperty("amountVotes")
    private int amountVotes;

    // Konstruktoren
    public Party() {}

    public Party(String partyID, int amountVotes) {
        this.partyID = partyID;
        this.amountVotes = amountVotes;
    }

    // Getter und Setter
    public String getPartyID() {
        return partyID;
    }

    public void setPartyID(String partyID) {
        this.partyID = partyID;
    }

    public int getAmountVotes() {
        return amountVotes;
    }

    public void setAmountVotes(int amountVotes) {
        this.amountVotes = amountVotes;
    }
}
