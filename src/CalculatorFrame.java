import javax.swing.*;
import java.awt.*;

public class CalculatorFrame extends JFrame {
    CalculatorFrame() {
        this.setTitle("Calculator by Mansko09");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit out of application
        this.setResizable(false);//prevent this from being resized
        this.setSize(400, 600);
        this.setVisible(true); //make this visible

        ImageIcon image = new ImageIcon("lib/Calculator_logo.webp");
        this.setIconImage(image.getImage());//change Icon of this
        this.getContentPane().setBackground(Color.pink);
    }
}
