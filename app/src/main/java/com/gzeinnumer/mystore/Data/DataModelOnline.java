package com.gzeinnumer.mystore.Data;

public class DataModelOnline {
    int id;
    String title;
    String description;
    double rating;
    double price;
    String image;

    public DataModelOnline(int id, String title, String description, double rating, double price, String image) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.price = price;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getRating() {
        return rating;
    }

    public double getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }
}
