package com.example.supplychainsystem;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;

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
    public static ObservableList<Product> getAllProducts(){
        DatabaseConnection databaseConnection= new DatabaseConnection();
        ObservableList<Product> productList= FXCollections.observableArrayList();
        String selectProducts="Select * from product1";
        try{
            ResultSet rs= databaseConnection.getQueryTable(selectProducts);
            while(rs.next()){
                productList.add(new Product(
                        rs.getInt("product_id"),
                        rs.getString("name"),
                        rs.getDouble("price")
                )
                );
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return productList;
    }

    public static ObservableList<Product> getProductsByName(String productName){
        DatabaseConnection databaseConnection= new DatabaseConnection();
        ObservableList<Product> productList= FXCollections.observableArrayList();
        String selectProducts=String.format("Select * from product1 where lower(name) like '%%%s%%'",productName.toLowerCase());
        try{
            ResultSet rs= databaseConnection.getQueryTable(selectProducts);
            while(rs.next()){
                productList.add(new Product(
                                rs.getInt("product_id"),
                                rs.getString("name"),
                                rs.getDouble("price")
                        )
                );
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return productList;
    }
}
