package com.example.calculate;

import android.hardware.ConsumerIrManager;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class StringNumber {
    List<String> list;
    String tempNumber;


    public StringNumber() {

    }

    public String GetStringFull () {
        String text = new String();
        for (int i = 0; i < list.size(); i++){
            text += list.get(i);
        }
        return text;
    }
    public static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    public void SetData(String data){
       if (isNumber(data)){
           tempNumber += data;
       } else if (EqvalseString(data, Arrays.asList(","))){
           if(!EqvalseDot(data)){
               tempNumber += data;
           }
       } else if (EqvalseString(data, Arrays.asList("(", ")"))){
           list.add(tempNumber);
           tempNumber = "";
           list.add(data);
       } else {
           list.add(tempNumber);
           tempNumber = "";
           list.add(data);
       }

    }
    public boolean EqvalseDot(String data){
        for (char ch : data.toCharArray()){
            if (ch == ','){
                return true;
            }
        }
        return false;
    }
    public boolean EqvalseString(String data,List arrChar){
        for (int i=0;i<arrChar.size();i++){
            if (data == arrChar.get(i)){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }
}
