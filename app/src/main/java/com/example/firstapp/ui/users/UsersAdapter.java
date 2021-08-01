package com.example.firstapp.ui.users;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.firstapp.R;

import java.util.ArrayList;
import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder> {

    private List<User> list, originalList;
    private ClickListener clickListener;

    public UsersAdapter(List<User> list, ClickListener clickListener)  {
        this.clickListener = clickListener;
        this.list = list;
        this.originalList = list;
    }

    public void updateList (List<User> list){
        this.list = list;
        notifyDataSetChanged();
    }

    public void filter(String text) {
        if (text.trim().isEmpty()){
            resetList();
        }
        else {
            List<User> temp = new ArrayList<>();
            for (User d : originalList) {
                if (d.getName().toLowerCase().contains(text.toLowerCase()) ||
                        d.getNickName().toLowerCase().contains(text.toLowerCase())) {
                    temp.add(d);
                }
                updateList(temp);
            }
        }
    }

    public void resetList(){
        updateList(originalList);
    }

    public void clear(){
        list.clear();
        notifyDataSetChanged();
    }

    @Override
    public UsersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_holder, parent, false);
        return new UsersAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UsersAdapter.ViewHolder holder, int position) {
        User user = list.get(position);
        holder.textView.setText(user.getName());
        holder.nickName.setText("@" + user.getNickName());
        Glide.with(holder.imageView.getContext())
                .load(user.getLink())
                .into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onUserClick(user);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView textView, nickName;

        public ViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.image);
            textView = view.findViewById(R.id.tv1);
            nickName = view.findViewById(R.id.tv2);
        }
    }

}
