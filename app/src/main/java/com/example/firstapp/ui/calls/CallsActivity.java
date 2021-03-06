package com.example.firstapp.ui.calls;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.firstapp.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CallsActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calls);

        initUI();
        dateFormatTest();
    }

    private void dateFormatTest() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM, yyyy, hh:mm a");
        Date date = Calendar.getInstance().getTime();
        String strDateTime = sdf.format(date);
        System.out.println("date === " + strDateTime);

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -3);
        calendar.add(Calendar.HOUR_OF_DAY, 5);
        Date date1 = calendar.getTime();
        System.out.println("date 1 = " + sdf.format(date1));
    }

    private void initUI() {
        recyclerView = findViewById(R.id.recyclerView);

        ArrayList<Employee> employees = new ArrayList<>();

        Employee employee = new Employee();
        employee.setName("Robert");
        employee.setAddress("New York");
        employee.setPhone("+61234456");
        employees.add(employee);

        employee = new Employee();
        employee.setName("Tom");
        employee.setAddress("California");
        employee.setEmail("tom_frank@gmail.com");
        employees.add(employee);

        employee = new Employee();
        employee.setName("Smith");
        employee.setAddress("Philadelphia");
        employee.setEmail("smith_carrol@gmail.com");
        employees.add(employee);

        employee = new Employee();
        employee.setName("Ryan");
        employee.setAddress("Canada");
        employee.setPhone("+612001456");
        employees.add(employee);

        employee = new Employee();
        employee.setName("Mark");
        employee.setAddress("Boston");
        employee.setEmail("mark_walmerd@gmail.com");
        employees.add(employee);

        employee = new Employee();
        employee.setName("Adam");
        employee.setAddress("Brooklyn");
        employee.setPhone("+61211780");
        employees.add(employee);

        employee = new Employee();
        employee.setName("Kevin");
        employee.setAddress("New Jersey");
        employee.setPhone("+94221035");
        employees.add(employee);

        employee = new Employee();
        employee.setName("David");
        employee.setAddress("New York");
        employee.setPhone("+94221035");
        employees.add(employee);

        employee = new Employee();
        employee.setName("Diana");
        employee.setAddress("Zp");
        employee.setPhone("+94221035");
        employees.add(employee);

        // set adapter
        EmployeeAdapter adapter = new EmployeeAdapter(this, employees);
        recyclerView.setAdapter(adapter);
    }

}