import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorFrame extends JFrame implements ActionListener {
    int width=40;
    int height = 30;
    int firstNumber;
    JButton one_button = new JButton();
    JButton two_button = new JButton();
    JButton three_button = new JButton();
    JButton four_button = new JButton();
    JButton five_button = new JButton();
    JButton six_button = new JButton();
    JButton seven_button = new JButton();
    JButton eight_button = new JButton();
    JButton nine_button = new JButton();
    JButton zero_button = new JButton();
    JButton dot_button = new JButton();
    JButton division_button = new JButton();
    JButton times_button = new JButton();
    JButton minus_button = new JButton();
    JButton plus_button = new JButton();
    JButton equal_button = new JButton();
    CalculatorFrame() {
        ImageIcon iconlogo = new ImageIcon("C:\\Users\\mbeng\\Documents\\Programming_projects\\java_games\\Calculator_project\\calculator-icon.png");
        this.setIconImage(iconlogo.getImage());//change java logo

        JLabel label = new JLabel();
        //label.setText(" Pink Calculator ");
        //background
        ImageIcon image = new ImageIcon("C:\\Users\\mbeng\\Documents\\Programming_projects\\java_games\\Calculator_project\\CALCULATOR.png");
        label.setIcon(image);
        label.setHorizontalAlignment(JLabel.CENTER);

        //panel to show the result of the operation
        JPanel resultPanel = new JPanel();
        resultPanel.setBackground(Color.white);
        resultPanel.setBounds(70,100,140,40);

        //Buttons for the numbers
        one_button.setBounds(20,170,width,height);
        two_button.setBounds(70,170,width,height);
        three_button.setBounds(120,170,width,height);
        four_button.setBounds(170,170,width,height);
        five_button.setBounds(20,210,width,height);
        six_button.setBounds(70,210,width,height);
        seven_button.setBounds(120,210,width,height);
        eight_button.setBounds(170,210,width,height);
        nine_button.setBounds(20,250,width,height);
        zero_button.setBounds(70,250,width,height);
        dot_button.setBounds(120,250,width,height);

        //buttons for operations

        division_button.setBounds(170,250,width,height);
        times_button.setBounds(20,290,width,height);
        minus_button.setBounds(70,290,width,height);
        plus_button.setBounds(120,290,width,height);
        equal_button.setBounds(170,290,width,height);



        this.setTitle("The pink Calculator ");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit out of application
        this.setResizable(false);//prevent this from being resized
        this.setSize(300, 500);
        this.setVisible(true); //make this visible
        this.getContentPane().setBackground(Color.pink);

        //adding all the buttons
        this.add(one_button);
        this.add(two_button);
        this.add(three_button);
        this.add(four_button);
        this.add(five_button);
        this.add(six_button);
        this.add(seven_button);
        this.add(eight_button);
        this.add(nine_button);
        this.add(zero_button);
        this.add(division_button);
        this.add(dot_button);
        this.add(times_button);
        this.add(plus_button);
        this.add(minus_button);
        this.add(equal_button);

        one_button.addActionListener(this);

        this.add(resultPanel);
        this.add(label);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(one_button)) {
            firstNumber = 1;
            System.out.println(firstNumber);
        }
        //else if (e.getSource().equals(two_button))

    }
}
