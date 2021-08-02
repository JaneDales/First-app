package com.example.firstapp.ui.bank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.firstapp.R;

import java.util.ArrayList;

public class ExpensesListActivity extends AppCompatActivity {

    private ExpensesAdapter expensesAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses_list);

        recyclerView = findViewById(R.id.recyclerView);


        ArrayList<IExpenseType> expenses = new ArrayList<>();

        Date expenses1 = new Date("29 июля");
        Expenses expenses2 = new Expenses("Cильпо","Продукты и супермаркеты", "https://silpo.ua/images/silpo_fb_share.png",-650.50);
        Expenses expenses3 = new Expenses("ATБ","Продукты и супермаркеты", "https://kremenchuk.tv/wp-content/uploads/2020/05/946cd9e118480dd738e062c4e6922b18_300_300_a.jpg",-560.50);
        Expenses expenses4 = new Expenses("Portmone","Коммуналка и интернет", "https://www.portmone.com.ua/public/i/portmone-logo-og.png",-250.0);
        Expenses expenses5 = new Expenses("Portmone","Коммуналка и интернет", "https://www.portmone.com.ua/public/i/portmone-logo-og.png",-200.0);
        Expenses expenses6 = new Expenses("Taxi","Такси", "https://w7.pngwing.com/pngs/889/660/png-transparent-youtube-business-taxi-logo-organization-youtube-text-service-logo.png",-950.50);
        Expenses expenses7 = new Expenses("Cильпо","Продукты и супермаркеты", "https://silpo.ua/images/silpo_fb_share.png",-650.50);

        Date expenses8 = new Date("28 июля");
        Expenses expenses9 = new Expenses("Cильпо","Продукты и супермаркеты", "https://silpo.ua/images/silpo_fb_share.png",-650.50);
        Expenses expenses10 = new Expenses("ATБ","Продукты и супермаркеты", "https://kremenchuk.tv/wp-content/uploads/2020/05/946cd9e118480dd738e062c4e6922b18_300_300_a.jpg",-560.50);
        Expenses expenses11 = new Expenses("Portmone","Коммуналка и интернет", "https://www.portmone.com.ua/public/i/portmone-logo-og.png",-250.0);
        Expenses expenses12 = new Expenses("Portmone","Коммуналка и интернет", "https://www.portmone.com.ua/public/i/portmone-logo-og.png",-200.0);
        Expenses expenses13 = new Expenses("Taxi","Такси", "https://w7.pngwing.com/pngs/889/660/png-transparent-youtube-business-taxi-logo-organization-youtube-text-service-logo.png",-950.50);
        Expenses expenses14 = new Expenses("Cильпо","Продукты и супермаркеты", "https://silpo.ua/images/silpo_fb_share.png",-650.50);

        expenses.add(expenses1);
        expenses.add(expenses2);
        expenses.add(expenses3);
        expenses.add(expenses4);
        expenses.add(expenses5);
        expenses.add(expenses6);
        expenses.add(expenses7);
        expenses.add(expenses8);
        expenses.add(expenses9);
        expenses.add(expenses10);
        expenses.add(expenses11);
        expenses.add(expenses12);
        expenses.add(expenses13);
        expenses.add(expenses14);


        expensesAdapter = new ExpensesAdapter(this, expenses);
        recyclerView.setAdapter(expensesAdapter);
    }
}