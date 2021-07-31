package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firstapp.ui.comments.CommentsListFragment;
import com.example.firstapp.ui.settings.SettingsFragment;
import com.example.firstapp.ui.todos.TodosListFragment;
import com.example.firstapp.ui.users.UsersListFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputLayout;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {
    private static final int MIN_TEXT_LENGTH = 4;
    private static final String EMPTY_STRING = "";

    private TextInputLayout mTextInputLayout;
    private EditText mEditText;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
        openFragment(new UsersListFragment());
    }

    private void initUI() {
        mTextInputLayout = findViewById(R.id.textInputLayout);
        mEditText = findViewById(R.id.editTextName);
        bottomNavigationView = findViewById(R.id.navigation);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_users:
                    openFragment(new UsersListFragment());
                    break;
                case R.id.navigation_comments:
                    openFragment(new CommentsListFragment());
                    break;
                case R.id.navigation_todos:
                    openFragment(TodosListFragment.newInstance());
                    break;
                case R.id.navigation_settings:
                    openFragment(new SettingsFragment());
                    break;
            }
            return true;
        });

        mTextInputLayout.setHint(getString(R.string.hint));
        mEditText.setOnEditorActionListener(ActionListener.newInstance(this));
    }

    private boolean shouldShowError() {
        int textLength = mEditText.getText().length();
        return textLength > 0 && textLength < MIN_TEXT_LENGTH;
    }

    private void showError() {
        mTextInputLayout.setError(getString(R.string.error));
    }

    private void hideError() {
        mTextInputLayout.setError(EMPTY_STRING);
    }

    private static final class ActionListener implements TextView.OnEditorActionListener {
        private final WeakReference<MainActivity> mainActivityWeakReference;

        public static ActionListener newInstance(MainActivity mainActivity) {
            WeakReference<MainActivity> mainActivityWeakReference = new WeakReference<>(mainActivity);
            return new ActionListener(mainActivityWeakReference);
        }

        private ActionListener(WeakReference<MainActivity> mainActivityWeakReference) {
            this.mainActivityWeakReference = mainActivityWeakReference;
        }

        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            MainActivity mainActivity = mainActivityWeakReference.get();
            if (mainActivity != null) {
                if (actionId == EditorInfo.IME_ACTION_GO && mainActivity.shouldShowError()) {
                    mainActivity.showError();
                } else {
                    mainActivity.hideError();
                }
            }
            return true;
        }
    }
    public void onClick1(View v){
        openFragment(new UsersListFragment());
    }

    public void onClick2(View v){
        openFragment(new CommentsListFragment());
    }

    public void openFragment(Fragment fragment){
        FragmentTransaction frt = getSupportFragmentManager().beginTransaction();
        frt.replace(R.id.container, fragment);
        frt.commit();
    }
}