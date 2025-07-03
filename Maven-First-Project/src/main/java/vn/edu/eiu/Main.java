package vn.edu.eiu;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
      Calculator_Square calc = new Calculator_Square();
      Scanner in = new Scanner(System.in);
      double price = 100;

      System.out.println("Giá đất: " + calc.getSquare(10,5) * price);



    }
}