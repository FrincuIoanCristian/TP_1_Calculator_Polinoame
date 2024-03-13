package Main;

import View.CalculatorView;
import Controller.Controller;

public class Main {
    public static void main(String[] args) {
        CalculatorView calculator = new CalculatorView();
        Controller c = new Controller(calculator);
    }
}