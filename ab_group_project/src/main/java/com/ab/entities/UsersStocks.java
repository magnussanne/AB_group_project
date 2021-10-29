package com.ab.entities;

public class UsersStocks {

    private Stocks stock;
    private int quantity;

    public UsersStocks(Stocks stock, int quantity) {
        super();
        this.stock = stock;
        this.quantity = quantity;
    }

    public Stocks getStock() {
        return stock;
    }

    public void setStock(Stocks stock) {
        this.stock = stock;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "User owns " + quantity + " of " + stock.getName();
    }

}
