package com.example.firstapp.ui.bank;

public class Date implements IExpenseType {

    private String date;

    public Date (String date){
        this.date = date;
    }

    public String getDate() {
        return date;
    }
}
