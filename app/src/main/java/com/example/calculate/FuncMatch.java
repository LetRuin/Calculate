package com.example.calculate;

public class FuncMatch {
    public double Sum (double num1, double num2){
        return num1 + num2;
    } // Сложение
    public double Subtraction(double num1, double num2){
        return num2 - num1;
    } // Вычитание
    public double Multiplication (double num1, double num2){
        return num1 * num2;
    } // Умножение
    public double Division (double num1, double num2){
        return num2 / num1;
    } // Деление
    public double Percent (double num1, double num2){
        double temp = num2*0.01;
        return num1 * temp;
    } // Процент
    public static double Sin (double num){
        return Math.sin(num);
    } // Синус
    public static double Cos (double num){
        return Math.cos(num);
    } // Косинус
    public static double Pi (double num){
        return (Math.PI * num);
    } // Число пи
    public static double Log (double num){
        return Math.log10(num);
    } // Логарифм
    public static double Tan (double num){
        return Math.tan(num);
    } // Тангенс
    public static double In (double num){
        return Math.log(num);
    } //
    public double Factorial (double num){
        double temp = 1;
        for (int i=1; i <= num ;i++){
            temp = temp * i;
        }
        return temp;
    } // факториал
    public static double Sqrt (double num){
        return Math.sqrt(num);
    } // Корень
    public double Vosved (double num1, double num2){
        double temp = num1;
        for (int i=1; i < num2 ;i++){
            temp = temp * num1;
        }
        return temp;
    } // Возведение в степень
}
