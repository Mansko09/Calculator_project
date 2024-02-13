import javax.swing.*;
import java.awt.*;

public class CalculatorGUI extends JFrame {
    CalculatorGUI() {
        JLabel label = new JLabel();
        label.setText(" Pink Calculator");
        this.setTitle("Calculator by Mansko09");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit out of application
        this.setResizable(false);//prevent this from being resized
        this.setSize(400, 600);
        this.setVisible(true); //make this visible

        try{
            ImageIcon image = new ImageIcon("C:\\Users\\mbeng\\Documents\\Programming_projects\\java_games\\Calculator_project\\lib\\Calculator_logo.webp");
            this.setIconImage(image.getImage());//change Icon of this
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("The file path cannot be found");
        }
        this.getContentPane().setBackground(Color.white);

        this.add(label);
    }
}
