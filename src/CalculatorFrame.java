import javax.swing.*;
import java.awt.*;

public class CalculatorFrame extends JFrame {
    CalculatorFrame() {
        ImageIcon iconlogo = new ImageIcon("C:\\Users\\mbeng\\Documents\\Programming_projects\\java_games\\Calculator_project\\calculator-icon.png");
        this.setIconImage(iconlogo.getImage());

        JLabel label = new JLabel();
        //label.setText(" Pink Calculator ");

        ImageIcon image = new ImageIcon("C:\\Users\\mbeng\\Documents\\Programming_projects\\java_games\\Calculator_project\\CALCULATOR.png");
        label.setIcon(image);
        label.setHorizontalAlignment(JLabel.CENTER);

        this.setTitle("The pink Calculator ");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit out of application
        this.setResizable(false);//prevent this from being resized
        this.setSize(300, 500);
        this.setVisible(true); //make this visible
        this.getContentPane().setBackground(Color.pink);


        this.add(label);
    }
}
