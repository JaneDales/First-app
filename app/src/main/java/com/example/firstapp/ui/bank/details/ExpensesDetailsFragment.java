package com.example.firstapp.ui.bank.details;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.firstapp.R;
import com.example.firstapp.ui.bank.Expenses;


public class ExpensesDetailsFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";

    private Expenses expenses;
    private TextView tvTitle, tvPrice;

    public static ExpensesDetailsFragment newInstance(Expenses expenses) {
        ExpensesDetailsFragment fragment = new ExpensesDetailsFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, expenses);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            expenses = (Expenses) getArguments().getSerializable(ARG_PARAM1);
        }

//        ArrayList<Integer> list1 = new ArrayList<>();
//        ArrayList<Integer> list2 = new ArrayList<>();
//        for (int i = 1; i <= 10; i++){
//            if (i%2==0){
//                list1.add(i);
//            }
//            else {
//                list2.add(i);
//            }
//        }
//        for(Integer i : list1){
//            System.out.println("list 1 = " + i);
//        }
//        for (Integer i : list2){
//            System.out.println("list2 = " + i);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_expenses_details, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvTitle = view.findViewById(R.id.tvTitle);
        tvPrice = view.findViewById(R.id.tvPrice);

        tvTitle.setText(expenses.getTitle());

        String s = String.valueOf(expenses.getPrice());
        SpannableString ss1=  new SpannableString(s);
        ss1.setSpan(new RelativeSizeSpan(2f), 0,s.length()-1, 0); // set size
        tvPrice.setText(ss1);
    }
}