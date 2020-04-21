/*
 * Mouner Dabjan 
 * 4/20/2020
 * This program starts with a four-tuple of nonnegative integers (a,b,c,d) and that repeatedly apply this rule:
 (a,b,c,d) → (|a−b|,|b−c|,|c−d|,|d−a|)

 */
package fourtuple;

import static java.lang.Math.abs;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author User
 */
public class FourTuple {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // asking the user for the 4 numbers as their input 
        int num1 = Integer.parseInt(JOptionPane.showInputDialog("Please enter your first number"));
        int num2 = Integer.parseInt(JOptionPane.showInputDialog("Please enter your second number"));
        int num3 = Integer.parseInt(JOptionPane.showInputDialog("Please enter your third number"));
        int num4 = Integer.parseInt(JOptionPane.showInputDialog("Please enter your fourth number"));
        // checking if the numbers are positive or not 
        if (num1 < 0 || num2 < 0 || num3 < 0 || num4 < 0) {
            System.out.println("Please enter positive numbers"); // asking the user for their input but with positive numbers 
        } 
        else {

            // creating a new static array to store the variables 
            ArrayList<Integer> numbers = new ArrayList();
            numbers.add(0, num1);
            numbers.add(1, num2);
            numbers.add(2, num3);
            numbers.add(3, num4);
            numbers.add(0); // adding a 0 to keep track with the number of steps
            transform(numbers); // calling the transform method 
            // fixing the output so that the step counter is removed
            String output = numbers.toString().substring(1, numbers.toString().length() - 4);
            //outputting the results to the screen 
            System.out.println("The number of recursion is " + numbers.get(4) + "(" + output + ")");
        }

    }

    public static ArrayList<Integer> transform(ArrayList<Integer> numbers) {
        // match each letter to a number input by the user 
        int a = numbers.get(0);
        int b = numbers.get(1);
        int c = numbers.get(2);
        int d = numbers.get(3);
        // Recursive method: if one of the numbers reaches 0, the method will stop 
        if (a == 0 || b == 0 || c == 0 || d == 0) {
            return numbers; //returning the numbers 
        } else {
            //setting each new number as the abs of the difference between itself and the number after it  
            numbers.set(0, abs(a - b));
            numbers.set(1, abs(b - c));
            numbers.set(2, abs(c - d));
            numbers.set(3, abs(d - a));
            numbers.set(4, numbers.get(4) + 1); //keeping count of the number of the steps 
            return transform(numbers);
        }
    }
}
