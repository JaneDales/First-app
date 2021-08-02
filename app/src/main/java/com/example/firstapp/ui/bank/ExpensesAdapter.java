package com.example.firstapp.ui.bank;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.firstapp.R;

import java.util.ArrayList;

public class ExpensesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static int TYPE_EXPENSES = 1;
    private static int TYPE_DATE = 2;

    private Context context;
    private ArrayList<IExpenseType> expenses;

    public ExpensesAdapter(Context context, ArrayList<IExpenseType> expenses) {
        this.context = context;
        this.expenses = expenses;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view;
        if (viewType == TYPE_EXPENSES) {
            view = LayoutInflater.from(context).inflate(R.layout.item_expense, viewGroup, false);
            return new ExpensesViewHolder(view);

        } else {
            view = LayoutInflater.from(context).inflate(R.layout.item_date, viewGroup, false);
            return new DateViewHolder(view);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(expenses.get(position) instanceof Date) {
            return TYPE_DATE;
        } else {
            return TYPE_EXPENSES;
        }
//        if (expenses.get(position).isShowDate()) {
//            return TYPE_DATE;
//        } else {
//            return TYPE_EXPENSES;
//        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        if (getItemViewType(position) == TYPE_EXPENSES) {
            ((ExpensesViewHolder) viewHolder).setExpensesDetails((Expenses) expenses.get(position));
        } else {
            ((DateViewHolder) viewHolder).setDateDetails((Date) expenses.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return expenses.size();
    }

    class ExpensesViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle, tvSubTitle, tvPrice;
        private ImageView ivIcon;

        ExpensesViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvSubTitle = itemView.findViewById(R.id.tvSubTitle);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            ivIcon = itemView.findViewById(R.id.ivIcon);
        }

        void setExpensesDetails(Expenses expenses) {
            tvTitle.setText(expenses.getTitle());
            tvSubTitle.setText(expenses.getSubTitle());
            tvPrice.setText(String.valueOf(expenses.getPrice()));

            RequestOptions requestOptions = new RequestOptions();
            requestOptions = requestOptions.transforms(new CenterCrop(), new RoundedCorners(100));

            Glide.with(ivIcon)
                    .load(expenses.getIcon())
                    .apply(requestOptions)
                    .into(ivIcon);
        }
    }

    class DateViewHolder extends RecyclerView.ViewHolder {

        private TextView tvDate;

        DateViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDate = itemView.findViewById(R.id.tvDate);
        }

        void setDateDetails(Date date) {
            tvDate.setText(date.getDate());
        }
    }
}
