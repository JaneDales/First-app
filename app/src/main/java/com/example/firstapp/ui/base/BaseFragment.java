package com.example.firstapp.ui.base;

import android.content.Context;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class BaseFragment extends Fragment {

    public void openFragment(Fragment fragment, int containerId){
        FragmentTransaction frt = getChildFragmentManager().beginTransaction();
        frt.replace(containerId, fragment);
        frt.addToBackStack(null);
        frt.commit();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if (getChildFragmentManager().getBackStackEntryCount() > 0) {
                    getChildFragmentManager().popBackStack();
                    return;
                }
                getParentFragmentManager().popBackStack();
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, onBackPressedCallback);
    }
}