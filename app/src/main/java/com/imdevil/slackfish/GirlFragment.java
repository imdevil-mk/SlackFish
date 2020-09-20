package com.imdevil.slackfish;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class GirlFragment extends BaseFragment {

    private static BaseFragment INSTANCE;

    public static BaseFragment instance(String args) {
        Bundle bundle = new Bundle();
        bundle.putString("ARGS", args);
        if (INSTANCE == null) {
            INSTANCE = new GirlFragment();
        }
        INSTANCE.setArguments(bundle);
        return INSTANCE;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        setLogTag("GirlFragment");
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_base, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        TextView tx = getView().findViewById(R.id.textView);
        tx.setText(getArguments().getString("ARGS"));
    }
}
