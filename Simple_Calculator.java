import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface ICalculator {
    /**
    * Adds given two numbers
    * @param x first number
    * @param y second number
    * @return the sum of the two numbers
    */
     int add(int x, int y);
    /**
    * Divides two numbers
    * @param x first number
    * @param y second number
    * @return the division result
    */
     float divide(int x, int y) throws RuntimeException;
}


 public class Calculator implements ICalculator{
  /* Implement your calculator class here*/
    public static void main (String[]args){
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        char s=input.next().charAt(0);
        int y = input.nextInt();
        Calculator c1 = new Calculator();
        switch(s){
            case '+':
                System.out.println(c1.add(x,y));
                break;
            case '/':
                if (y!=0){
                    System.out.println(c1.divide(x,y));
                    break;}
                else System.out.println("Error");
                break;
            default: System.out.println("Error");}
        }
        public int add(int x,int y){return x+y;}
    public float divide(int x,int y){return((float) x/y);}
}

