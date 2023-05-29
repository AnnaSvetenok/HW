package com.trainjavafx;

public class Train {


    private String name;

    private String type;

    private int carriages;

    private int seats;

    public Train(String name, String type, int carriages, int seats) {
        this.name = name;
        this.type = type;
        this.carriages = carriages;
        this.seats = seats;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getCarriages() {
        return carriages;
    }
    public void setCarriages(int carriages) {
        this.carriages = carriages;
    }
    public int getSeats() {
        return seats;
    }
    public void setSeats(int seats) {
        this.seats = seats;
    }
}