package com.lab01.fp.model;


import java.util.ArrayList;
import java.util.List;

public class Portfolio {
    private long id;
    private String name;
    private double totalValue;
    private String currency;

    private List<Account> accounts;

    public Portfolio(long id, String name, double totalValue, String currency, List<Account> accounts) {
        this.id = id;
        this.name = name;
        this.totalValue = totalValue;
        this.currency = currency;
        this.accounts = accounts;
    }


    public Portfolio() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void addAccount(Account account) {
        if(accounts == null || !(accounts instanceof ArrayList))
            accounts = new ArrayList<Account>();
        this.accounts.add(account);
        updateBalance();
    }

    private void updateBalance() {
        this.totalValue = this.accounts.stream().mapToDouble(Account::getBalance).sum();
    }

}
