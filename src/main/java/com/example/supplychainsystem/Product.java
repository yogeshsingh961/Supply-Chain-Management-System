package com.example.supplychainsystem;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Product {

    private SimpleIntegerProperty id;
    private StringProperty name;
    private SimpleDoubleProperty price;

    public int getId() {
        return id.get();
    }

//    public SimpleIntegerProperty idProperty() {
//        return id;
//    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public double getPrice() {
        return price.get();
    }

//    public SimpleDoubleProperty priceProperty() {
//        return price;
//    }

    public Product(int id, String name, double price) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleDoubleProperty(price);
    }
}
