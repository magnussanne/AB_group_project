package com.ab.entities;

public class UsersStocks {

    private String stockName;
    private int quantity;

    public UsersStocks(String stock, int quantity) {
        super();
        this.stockName = stock;
        this.quantity = quantity;
    }

    public String getStock() {
        return stockName;
    }

    public void setStock(String stock) {
        this.stockName = stock;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "User owns " + quantity + " of " + stockName;
    }

}
