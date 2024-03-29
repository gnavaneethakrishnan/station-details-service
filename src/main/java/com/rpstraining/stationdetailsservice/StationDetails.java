package com.rpstraining.stationdetailsservice;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StationDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer trainID;

    private String fromStation;

    private String toStation;


    public StationDetails(Integer trainID, String fromStation, String toStation) {
        this.trainID = trainID;
        this.fromStation = fromStation;
        this.toStation = toStation;
    }

    public StationDetails() {
    }

    public Integer getTrainID() {
        return trainID;
    }

    public void setTrainID(Integer trainID) {
        this.trainID = trainID;
    }

    public String getFromStation() {
        return fromStation;
    }

    public void setFromStation(String fromStation) {
        this.fromStation = fromStation;
    }

    public String getToStation() {
        return toStation;
    }

    public void setToStation(String toStation) {
        this.toStation = toStation;
    }
}
