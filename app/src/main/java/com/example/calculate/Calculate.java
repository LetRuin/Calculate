package com.example.calculate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;
import java.util.Stack;

public class Calculate {
    private FuncMatch funcMatch;
    HashMap<String, Integer> arrMatch;
    Stack<Double> stackNum;
    Stack<String> stackMatch;
    public Calculate(){
        funcMatch = new FuncMatch();
        arrMatch = new HashMap<>();
        arrMatch.put("+",1);
        arrMatch.put("-",1);
        arrMatch.put("%",2);
        arrMatch.put("*",3);
        arrMatch.put("÷",3);
        arrMatch.put("^",4);
        arrMatch.put("!",4);
    }

    public double Run (String numOfString){
        stackNum = new Stack<>();
        stackMatch = new Stack<>();
        String staples;

        Scanner sc = new Scanner(numOfString);
        sc.useLocale(Locale.US);
        while(sc.hasNext()){
            if (sc.hasNextDouble()){
                if(!stackMatch.empty()){Equalse();}
                stackNum.push(sc.nextDouble());
            }else if (sc.hasNext("[%*÷+-^!]")){
                if(!stackMatch.empty()){
                    String temp = sc.next();
                    stackMatch.push(temp);
                }else{stackMatch.push(sc.next());}
            }else if(sc.hasNext("[(]")){
                staples = new String();
                int count =0;
                sc.next();
                do{
                    if (sc.hasNextFloat()){
                        staples += sc.nextDouble();
                    }else if (sc.hasNext("[(]")) {
                        staples += " " + sc.next() + " ";
                    count ++;
                    }else if (sc.hasNext("[)]")) {
                        staples += " " + sc.next() + " ";
                        count --;
                    } else {
                        staples += (" " + sc.next() + " ");
                    }

                }while (!sc.hasNext("[)]") || count != 0);

                Calculate calc = new Calculate();
                stackNum.push(calc.Run(staples));
            }else {
                sc.next();
            }
        }
        EqualseEnd();  //Завершение всех не законченный Выражений
        return stackNum.peek(); //возврат решонного числа
    } //Логика класса
    private void EqualseEnd(){
        while (stackMatch.size() > 0) {
            Match();
        }
    } //Итоговое вычисление
    private void Equalse () {
        int priority = arrMatch.get(stackMatch.peek());
        do {
            if(EqualseMatch(priority)){
                String temp = stackMatch.pop();
                Match();
                stackMatch.push(temp);
            }
        }while(EqualseMatch(priority));
    } //Промежуточное вычисление
    private void Match (){
        switch (stackMatch.pop()) {
            case ("+"):
                stackNum.push(funcMatch.Sum(stackNum.pop(), stackNum.pop()));
                break;
            case ("-"):
                stackNum.push(funcMatch.Subtraction(stackNum.pop(), stackNum.pop()));
                break;
            case ("*"):
                stackNum.push(funcMatch.Multiplication(stackNum.pop(), stackNum.pop()));
                break;
            case ("÷"):
                stackNum.push(funcMatch.Division(stackNum.pop(), stackNum.pop()));
                break;
            case ("%"):
                stackNum.push(funcMatch.Percent(stackNum.pop(), stackNum.pop()));
                break;
            case ("^"):
                stackNum.push(funcMatch.Vosved(stackNum.pop(), stackNum.pop()));
                break;
            case ("!"):
                stackNum.push(funcMatch.Factorial(stackNum.pop()));
                break;
            case ("√"):
                stackNum.push(funcMatch.Sqrt(stackNum.pop()));
                break;
        }
    } //Вычисление
    private boolean EqualseMatch(int priority){
        if(stackMatch.size()> 1) {
            String operatorEnd = stackMatch.pop();
            String operatorDoEnd = stackMatch.peek();
            if (arrMatch.get(operatorDoEnd) >= priority) {
                stackMatch.push(operatorEnd);
                return true;
            } else {
                stackMatch.push(operatorEnd);
                return false;
            }
        }else{
            return false;
        }
    } //Сравнение
}
