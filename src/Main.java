import javax.swing.*;
import java.util.Scanner;

import static java.lang.Math.pow;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame(); //creates a frame
        frame.setTitle("Calculator by Mansko09");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit out of application
        frame.setResizable(false);//prevent frame from being resized
        frame.setSize(400, 600);
        frame.setVisible(true); //make frame visible

        ImageIcon image = new ImageIcon("C:\\Users\\mbeng\\Documents\\Programming_projects\\java_games\\Calculator_project\\src\\lib\\Calculator_logo.webp");
        frame.setIconImage(image.getImage());//change Icon of frame
    }
}






        /*String Operation;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n Please enter an operation : multiplication, addition, division and power. \n");
        Operation = scanner.next();
        Operation = Operation.toUpperCase();
        switch (Operation) {
            case "MULTIPLICATION":
                multiplication();
                break;
            case "ADDITION":
                addition();
                break;
            case "DIVISION":
                division();
                break;
            case "POWER":
                power();
            default:
                System.out.println("The operation has not been written correctly or is unknown\n");
        }
        scanner.close();
    }
    public static void multiplication(){
        Scanner scanner = new Scanner(System.in);
        float x,y,result;
        System.out.println("Give the first float");
        x=scanner.nextFloat();
        System.out.println("Give the second float");
        y=scanner.nextFloat();
        result=x*y;
        System.out.println(result);
        scanner.close();
    }
    public static void addition(){
        Scanner scanner = new Scanner(System.in);
        float x,y,result;
        System.out.println("Give the first float");
        x=scanner.nextFloat();
        System.out.println("Give the second float");
        y=scanner.nextFloat();
        result=x+y;
        System.out.println(result);
        scanner.close();
    }
    public static void division(){
        Scanner scanner = new Scanner(System.in);
        float x,y,result;
        System.out.println("Give the first float");
        x=scanner.nextFloat();
        System.out.println("Give the second float");
        y=scanner.nextFloat();
        if (y!=0){
            result=x/y;
            System.out.println(result);
        }
        else{System.out.println("Error:Division by zero");}
        scanner.close();
    }
    public static void power(){
        Scanner scanner = new Scanner(System.in);
        int x,y;
        double result;
        System.out.println("Give the first integer");
        x=scanner.nextInt();
        System.out.println("Give the second integer");
        y=scanner.nextInt();
        result=pow(x,y);
        System.out.println(result);
        scanner.close();
    }*/

