package com.example.firstapp.helpers;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class TextChangedHelper {

    public interface TextChangedCallback{
        void onTextChanged(String s);
    }

    private TextChangedCallback textChangedCallback;

    public TextChangedHelper(TextChangedCallback textChangedCallback) {
        this.textChangedCallback = textChangedCallback;
    }

    public void attachEditText(EditText editText) {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void afterTextChanged(Editable editable) {
                textChangedCallback.onTextChanged(editable.toString().trim());
            }
        });
    }

}
