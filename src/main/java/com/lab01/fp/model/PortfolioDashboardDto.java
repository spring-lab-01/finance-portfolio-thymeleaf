package com.lab01.fp.model;


public class PortfolioDashboardDto {
    private double totalValue;
    private String currency;

    public PortfolioDashboardDto(double totalValue, String currency) {
        this.totalValue = totalValue;
        this.currency = currency;
    }


    public PortfolioDashboardDto() {
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
}
