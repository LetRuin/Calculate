package com.example.calculate;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Button;


public class BlockNumberButton extends Fragment {

    private View myFragmentView;
    Activity activityRoot;

    public BlockNumberButton() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        activityRoot = getActivity();

        myFragmentView = inflater.inflate(R.layout.fragment_block_number_button, container, false);

        TableLayout btnsTable = myFragmentView.findViewById(R.id.buttonsTable);
        for(int i = 0; i < btnsTable.getChildCount(); i++ ) {
            View rowChild = btnsTable.getChildAt(i);
            if(rowChild instanceof TableRow) {
                TableRow row = (TableRow) rowChild;
                for (int j = 0; j < row.getChildCount(); j++) {
                    View btn = row.getChildAt(j);
                    if(btn instanceof Button) {
                        Button button = (Button) btn;
                        button.setOnClickListener(view -> onNumberClick(button.getText().toString()));
                    }
                }
            }
        }

        myFragmentView.findViewById(R.id.procent).setOnClickListener(View -> onNumberClick(" % "));
        myFragmentView.findViewById(R.id.perehod).setOnClickListener(View -> onPerehod());

        myFragmentView.findViewById(R.id.dot).setOnClickListener(View -> onOperationClick("."));
        myFragmentView.findViewById(R.id.clear).setOnClickListener(View -> clear());
        myFragmentView.findViewById(R.id.clearAll).setOnClickListener(View -> clearAll());

        return myFragmentView;
    }

    public void onNumberClick(String number) {
        ((MainActivity)activityRoot).onNumberClick(number);

    }
    public void clear() {
        ((MainActivity)activityRoot).clear();
    }

    public void clearAll() {
        ((MainActivity)activityRoot).clearAll();
    }

    public void onOperationClick(String op) {
        ((MainActivity)activityRoot).onOperationClick(op);
    }
    public void onPerehod(){
        ((MainActivity)activityRoot).onPerehod();
    }
}