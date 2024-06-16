package com.example.calculate;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Button;


public class BlockUpButton extends Fragment {

    private View myFragmentView;
    Activity activityRoot;

    public BlockUpButton() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        activityRoot = getActivity();

        myFragmentView = inflater.inflate(R.layout.fragment_block_up_button, container, false);


        myFragmentView.findViewById(R.id.bracketLeft).setOnClickListener(View -> onOperationClick(" ( "));
        myFragmentView.findViewById(R.id.bracketRight).setOnClickListener(View -> onOperationClick(" ) "));
        myFragmentView.findViewById(R.id.sinus).setOnClickListener(View -> onOperationClick("sin"));
        myFragmentView.findViewById(R.id.cosinus).setOnClickListener(View -> onOperationClick("cos"));
        myFragmentView.findViewById(R.id.tangens).setOnClickListener(View -> onOperationClick("tan"));
        myFragmentView.findViewById(R.id.logarifm).setOnClickListener(View -> onOperationClick("log"));
        myFragmentView.findViewById(R.id.sqrt).setOnClickListener(View -> onOperationClick("√"));
        myFragmentView.findViewById(R.id.in).setOnClickListener(View -> onOperationClick("in"));

        return myFragmentView;
    }

    public void onNumberClick(String number) {
        ((MainActivity)activityRoot).onNumberClick(number);

    }

    public void onOperationClick(String op) {
        ((MainActivity)activityRoot).onOperationClick(op);
    }
}