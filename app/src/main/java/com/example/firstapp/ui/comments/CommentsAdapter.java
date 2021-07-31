package com.example.firstapp.ui.comments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.firstapp.R;
import com.example.firstapp.ui.users.ClickListener;

import java.util.List;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.ViewHolder> {

    private List<Comment> list;
    private CommentClickListener commentClickListener;
    public CommentsAdapter(List<Comment> list, CommentClickListener commentClickListener)  {
        this.list = list;
        this.commentClickListener = commentClickListener;
    }

    @Override
    public CommentsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_holder, parent, false);
        return new CommentsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CommentsAdapter.ViewHolder holder, int position) {
        Comment comment = list.get(position);
        holder.textView1.setText(comment.getName());
        holder.textView2.setText(comment.getBody());
        Glide.with(holder.imageView.getContext())
                .load(comment.getLink())
                .into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                commentClickListener.onCommentClick(comment);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView textView1, textView2;

        public ViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.image);
            textView1 = view.findViewById(R.id.tv1);
            textView2 = view.findViewById(R.id.tv2);
        }
    }
}
