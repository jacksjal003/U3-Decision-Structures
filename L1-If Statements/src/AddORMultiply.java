import javax.swing.*;
import java.util.Scanner;

public class AddORMultiply {


    /*
    Write two methods, one that adds two numbers and second that multiplies them.
    Then, write a main method that prompts the user to enter 2 numbers.

    If the first one is larger than the second, multiply and display the result
    If not, add them and display the results.
     */

    public static void main(String[] args) {
       double numInput1 = Double.parseDouble(JOptionPane.showInputDialog("Please enter a number"));
       double numInput2 = Double.parseDouble(JOptionPane.showInputDialog("Please enter a number"));
       double result = 0;

       if(numInput1 > numInput2){
           result = Multiplication(numInput1, numInput2);

       }

       if (numInput1 <= numInput2){
           result = Addition(numInput1, numInput2);
       }
       JOptionPane.showMessageDialog(null, "The result is" + result);


    }
    public static double Addition(double num1, double num2){
        return num1 + num2;

    }
    public static double Multiplication(double num1, double num2){
        return num1 * num2;

    }
}
