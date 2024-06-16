package com.example.calculate;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class BlockRightButton extends Fragment {

    private View myFragmentView;
    Activity activityRoot;

    public BlockRightButton() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        activityRoot = getActivity();

        myFragmentView = inflater.inflate(R.layout.fragment_block_right_button, container, false);


        myFragmentView.findViewById(R.id.sum).setOnClickListener(View -> onOperationClick("+"));
        myFragmentView.findViewById(R.id.substring).setOnClickListener(View -> onOperationClick("-"));
        myFragmentView.findViewById(R.id.multiple).setOnClickListener(View -> onOperationClick("*"));
        myFragmentView.findViewById(R.id.division).setOnClickListener(View -> onOperationClick("÷"));
        myFragmentView.findViewById(R.id.result).setOnClickListener(View -> onOperationClick("="));


        return myFragmentView;
    }

    public void onNumberClick(String number) {
        ((MainActivity)activityRoot).onNumberClick(number);

    }

    public void onOperationClick(String op) {
        ((MainActivity)activityRoot).onOperationClick(op);
    }
}