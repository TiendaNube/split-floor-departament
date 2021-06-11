package com.tiendanube.support.utils.address.model;

public class SplittedAddress {

    private String floor;
    private String department;
    private String observations;

    public SplittedAddress() {
    }

    public SplittedAddress(String floor, String department, String observations) {
        this.floor = floor;
        this.department = department;
        this.observations = observations;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public static SplittedAddress defaultIfFail(String floor) {
        return new SplittedAddress("", "", floor);
    }
}
