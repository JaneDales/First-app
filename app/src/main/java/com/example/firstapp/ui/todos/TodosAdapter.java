package com.example.firstapp.ui.todos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.firstapp.R;

import java.util.List;

public class TodosAdapter extends RecyclerView.Adapter<TodosAdapter.ViewHolder> {

    private List<Todos> list;
    private TodosClickListener todosClickListener;

    public TodosAdapter(List<Todos> list, TodosClickListener todosClickListener) {
        this.list = list;
        this.todosClickListener = todosClickListener;
    }

    @Override
    public TodosAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_todo, parent, false);
        return new TodosAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TodosAdapter.ViewHolder holder, int position) {
        Todos todos = list.get(position);
        holder.tvTitle.setText(todos.getTitle());
        holder.cbFlag.setChecked(todos.getCompleted());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                todosClickListener.onTodosClick(todos);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvTitle;
        public CheckBox cbFlag;

        public ViewHolder(View view) {
            super(view);
            tvTitle = view.findViewById(R.id.tvTitle);
            cbFlag = view.findViewById(R.id.cbFlag);
        }
    }
}
