package com.example.tallercustomlistview;

public class Car {
    private int photo;
    private String license_plate;
    private int brand;
    private int model;
    private int colour;
    private int price;

    public Car(int photo, String license_plate, int brand, int model, int colour, int price) {
        this.photo = photo;
        this.license_plate = license_plate;
        this.brand = brand;
        this.model = model;
        this.colour = colour;
        this.price = price;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getLicense_plate() {
        return license_plate;
    }

    public void setLicense_plate(String license_plate) {
        this.license_plate = license_plate;
    }

    public int getBrand() {
        return brand;
    }

    public void setBrand(int brand) {
        this.brand = brand;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public int getColour() {
        return colour;
    }

    public void setColour(int colour) {
        this.colour = colour;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void save() {
        Data.save(this);
    }
}
