package com.example.calculate;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class BlockCenterButton extends Fragment {

    private View myFragmentView;
    Activity activityRoot;

    public BlockCenterButton() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        activityRoot = getActivity();

        myFragmentView = inflater.inflate(R.layout.fragment_block_center_button, container, false);
        myFragmentView.findViewById(R.id.pi).setOnClickListener(View -> onOperationClick("pi"));
        myFragmentView.findViewById(R.id.vosved).setOnClickListener(View -> onOperationClick("^"));
        myFragmentView.findViewById(R.id.factorial).setOnClickListener(View -> onOperationClick("!"));

        return myFragmentView;
    }

    public void onNumberClick(String number) {
        ((MainActivity)activityRoot).onNumberClick(number);

    }

    public void onOperationClick(String op) {
        ((MainActivity)activityRoot).onOperationClick(op);
    }
}