package com.demo;

public class App {

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println("demo-app is running");
        System.out.println("2 + 3 = " + calc.add(2, 3));
        System.out.println("10 / 2 = " + calc.divide(10, 2));
    }
}
