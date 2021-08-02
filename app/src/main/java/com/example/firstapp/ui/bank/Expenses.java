package com.example.firstapp.ui.bank;

public class Expenses implements IExpenseType {

    private String title, subTitle, icon;
    private double price;

    public Expenses (String title, String subTitle, String icon, double price){
        this.title = title;
        this.subTitle = subTitle;
        this.icon = icon;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public String getIcon() {
        return icon;
    }

    public double getPrice() {
        return price;
    }
}
