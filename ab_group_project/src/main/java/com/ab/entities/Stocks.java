package com.ab.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stocks")
public class Stocks {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int stockId;
    private String name;
    private String description;
    private Double sellPrice;
    private Double buyPrice;
    private int available;

    public Stocks() {

    }

    public Stocks(String name, String description, Double sellPrice, Double buyPrice, int available) {
        super();
        this.name = name;
        this.description = description;
        this.sellPrice = sellPrice;
        this.buyPrice = buyPrice;
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Stocks: [name=" + name + ", description=" + description + ", sellPrice="
                + sellPrice + ", buyPrice=" + buyPrice + "]";
    }
}