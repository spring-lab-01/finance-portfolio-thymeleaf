package com.lab01.fp.model;

public class Account {
    private int id;
    private String name;
    private double balance;
    private long portfolioId;
    public Account() {}
    public Account(int id, String name, double balance, long portfolioId) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.portfolioId = portfolioId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public long getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(long portfolioId) {
        this.portfolioId = portfolioId;
    }
}
