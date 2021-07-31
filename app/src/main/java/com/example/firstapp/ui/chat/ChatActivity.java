package com.example.firstapp.ui.chat;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.firstapp.R;

public class ChatActivity extends AppCompatActivity implements MessageClickListener {

    private RecyclerView recyclerView;
    private ChatAdapter chatAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        init();
    }

    public void init(){
        recyclerView = findViewById(R.id.recyclerView);
        chatAdapter = new ChatAdapter(this);
        recyclerView.setAdapter(chatAdapter);
        ((LinearLayoutManager)recyclerView.getLayoutManager()).setReverseLayout(true);

        Button btnSend = findViewById(R.id.btnSend);
        EditText etChat = findViewById(R.id.etChat);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = etChat.getText().toString().trim();
                if (text.isEmpty()){
                    return;
                }
                Message message = new Message(text);
                chatAdapter.addNewMessage(message);
                etChat.setText("");
            }
        });
    }

    public void deleteMessageDialog(Message message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete");
        builder.setMessage("Are you sure to delete this message?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                chatAdapter.deleteMessage(message);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    @Override
    public void onClick(Message message) {
        deleteMessageDialog(message);
    }

}