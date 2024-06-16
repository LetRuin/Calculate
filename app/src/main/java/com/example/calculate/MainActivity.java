package com.example.calculate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

import android.annotation.SuppressLint;


public class MainActivity extends AppCompatActivity {

    TextView resultField;
    TextView inputField;

    TableLayout buttonsPanel;
    Button btn;
    boolean boolDod;
    boolean match;

    boolean perehod;


    public Calculate calculate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        calculate = new Calculate();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultField = findViewById(R.id.outputBox);
        inputField = findViewById(R.id.inputBox);
        buttonsPanel = findViewById(R.id.buttonHorizontalPanel);

        boolDod = false;
        match = false;
        perehod = false;


    }
    //сохранение состояния приложения
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("inputField", inputField.getText().toString());
        outState.putString("resultField", resultField.getText().toString());
        super.onSaveInstanceState(outState);
    }
    //восстановление сохраненного состояния
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedState) {
        super.onRestoreInstanceState(savedState);
        resultField.setText(savedState.getString("resultField"));
        inputField.setText(savedState.getString("inputField"));

    }

    public void clear() {
        if(inputField.getText().toString().length() > 0) {
            inputField.setText(inputField.getText().toString().substring(0, inputField.getText().toString().length() - 1));
        }
    }

    public void clearAll() {
        inputField.setText("");
        resultField.setText("");
        boolDod = false;
        match = false;
    }
    @SuppressLint("SetTextI18n")
    public void onNumberClick(String number) {
        inputField.setText(inputField.getText() + number);
        match = false;
    }

    public void onOperationClick(String op) {
        String number = inputField.getText().toString();
        if(number.length() > 0) {
            try {
                doRes(number, op);
            }
            catch(Exception ex) {
                resultField.setText("Ошибка Вычисления!");
            }
        }
    }

    public void onPerehod(){
        if(perehod){
            buttonsPanel.findViewById(R.id.blockCenterButton).setVisibility(View.GONE);
            buttonsPanel.findViewById(R.id.blockUpButton).setVisibility(View.GONE);
            buttonsPanel.findViewById(R.id.blockNumberButton).setBackgroundColor(Color.parseColor("#FF000000"));
            btn = findViewById(R.id.perehod);
            btn.setTextColor(Color.parseColor("#FFFFFFFF"));
            btn.setHeight(btn.getWidth());
            perehod = false;
        }else {
            buttonsPanel.findViewById(R.id.blockCenterButton).setVisibility(View.VISIBLE);
            buttonsPanel.findViewById(R.id.blockUpButton).setVisibility(View.VISIBLE);
            buttonsPanel.findViewById(R.id.blockNumberButton).setBackgroundColor(Color.parseColor("#383838"));
            btn = findViewById(R.id.perehod);
            btn.setTextColor(Color.parseColor("#4F67D3"));
            btn.setHeight(btn.getWidth());
            perehod = true;
        }
    }
    private void doRes(String number, String op) {
            switch (op) {
                case "=":
                    resultField.setText(String.valueOf(calculate.Run(number)));
                    break;
                case "+":
                    if(!match){
                        inputField.setText(inputField.getText() + " + ");
                        match = true;
                        boolDod = false;
                    }
                    break;
                case "-":
                    if(!match){
                        inputField.setText(inputField.getText() + " - ");
                        match = true;
                        boolDod = false;
                    }
                    break;
                case "*":
                    if(!match){
                        inputField.setText(inputField.getText() + " * ");
                        match = true;
                        boolDod = false;
                    }
                    break;
                case "÷":
                    if(!match){
                        inputField.setText(inputField.getText() + " ÷ ");
                        match = true;
                        boolDod = false;
                    }
                    break;
                case "^":
                    if(!match){
                        inputField.setText(inputField.getText() + " ^ ");
                        match = true;
                        boolDod = false;
                    }
                    break;
                case ".":
                    if(!boolDod){
                        inputField.setText(inputField.getText() + ".");
                        boolDod = true;
                    }
                    break;
                case " ( ":
                    if(true){
                        inputField.setText(inputField.getText() + " ( ");
                        match = true;
                        boolDod = false;
                    }
                    break;
                case " ) ":
                    if(!match){
                        inputField.setText(inputField.getText() + " ) ");
                        match = false;
                        boolDod = false;
                    }
                    break;
                case "!":
                    if(!match){
                        inputField.setText(inputField.getText() + " ! ");
                        match = true;
                        boolDod = false;
                    }
                    break;
                case "√":

                    resultField.setText(String.valueOf(FuncMatch.Sqrt(calculate.Run(number))));

                    break;
                case "sin":
                    resultField.setText(String.valueOf(FuncMatch.Sin(calculate.Run(number))));
                    break;
                case "cos":
                    resultField.setText(String.valueOf(FuncMatch.Cos(calculate.Run(number))));
                    break;
                case "pi":
                    resultField.setText(String.valueOf(FuncMatch.Pi(calculate.Run(number))));
                    break;
                case "log":
                    resultField.setText(String.valueOf(FuncMatch.Log(calculate.Run(number))));
                    break;
                case "tan":
                    resultField.setText(String.valueOf(FuncMatch.Tan(calculate.Run(number))));
                    break;
                case "in":
                    resultField.setText(String.valueOf(FuncMatch.In(calculate.Run(number))));
                    break;
            }
    }
}