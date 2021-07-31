package com.example.firstapp.ui.chat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.firstapp.R;

import java.util.ArrayList;
import java.util.List;

interface MessageClickListener {
    void onClick(Message message);
}
public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {

    private List<Message> list = new ArrayList<>();
    private MessageClickListener messageClickListener;

    public ChatAdapter(MessageClickListener messageClickListener){
        this.messageClickListener = messageClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat, parent, false);
        return new ChatAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ChatAdapter.ViewHolder holder, int position) {
        Message message = list.get(position);
        holder.textView.setText(message.getText());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                messageClickListener.onClick(message);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addNewMessage(Message message) {
        list.add(0, message);
        notifyDataSetChanged();
    }

    public void deleteMessage(Message message){
        int index = list.indexOf(message);
        list.remove(message);
        notifyItemRemoved(index);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;

        public ViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.tvChat);
        }
    }
}
