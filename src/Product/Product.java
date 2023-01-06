package Product;

import java.awt.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Product {
    private String id;
    private String trademark;
    private String name;
    private Double sizes;
    private String color;
    private int amount;
    private Double price;

    public Product() {
    }


    public Product(String id, String trademark, String name, Double sizes, String color, int amount, Double price) {
        this.id = id;
        this.trademark = trademark;
        this.name = name;
        this.sizes = sizes;
        this.color = color;
        this.amount = amount;
        this.price = price;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTrademark() {
        return trademark;
    }

    public void setTrademark(String productType) {
        this.trademark = trademark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Double getSize() {
        return sizes;
    }

    public void setSize(Double sizes) {
        this.sizes = sizes;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "----Product----" + "\n" +
                "ID: " + id + "\n" +
                "Kiểu: " + trademark + "\n" +
                "Tên: " + name + "\n" +
                "Kích cỡ: " + sizes + "\n" +
                "Màu: " + color + "\n" +
                "Số lượng: " + amount + "\n" +
                "Giá: " + price + "\n"
                ;
    }

    public String tofile() {
        return id + "," +trademark + "," + name + "," + sizes + "," + color + "," + amount + "," + price;
    }
}
