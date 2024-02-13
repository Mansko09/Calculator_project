import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorFrame extends JFrame implements ActionListener {
    int width = 50;
    int height = 30;
    String operation = ""; // type of operation chosen
    String operand1 = "";
    String operand2 = "";
    JLabel resultLabel = new JLabel("");
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
    JButton erase_button = new JButton();


    CalculatorFrame() {
        ImageIcon iconlogo = new ImageIcon("C:\\Users\\mbeng\\Documents\\Programming_projects\\java_games\\Calculator_project\\calculator-icon.png");
        this.setIconImage(iconlogo.getImage());//change java logo

        JLabel label = new JLabel();
        //label.setText(" Pink Calculator ");
        //background
        ImageIcon image = new ImageIcon("C:\\Users\\mbeng\\Documents\\Programming_projects\\java_games\\Calculator_project\\CALCULATOR.png");
        label.setIcon(image);
        label.setHorizontalAlignment(JLabel.CENTER);

        // Adding result label to the white panel
        JPanel resultPanel = new JPanel();
        resultPanel.setBackground(Color.white);
        resultPanel.setBounds(70, 100, 140, 40);
        resultPanel.add(resultLabel);


        //Buttons for the numbers
        one_button.setBounds(20, 170, width, height);
        one_button.setText("1");
        two_button.setBounds(70, 170, width, height);
        two_button.setText("2");
        three_button.setBounds(120, 170, width, height);
        three_button.setText("3");
        four_button.setBounds(170, 170, width, height);
        four_button.setText("4");
        five_button.setBounds(20, 210, width, height);
        five_button.setText("5");
        six_button.setBounds(70, 210, width, height);
        six_button.setText("6");
        seven_button.setBounds(120, 210, width, height);
        seven_button.setText("7");
        eight_button.setBounds(170, 210, width, height);
        eight_button.setText("8");
        nine_button.setBounds(20, 250, width, height);
        nine_button.setText("9");
        zero_button.setBounds(70, 250, width, height);
        zero_button.setText("0");
        dot_button.setBounds(120, 250, width, height);
        dot_button.setText(".");
        erase_button.setBounds(220,170,width,height);
        erase_button.setText("<-");

        //buttons for operations

        division_button.setBounds(170, 250, width, height);
        division_button.setText("/");
        times_button.setBounds(20, 290, width, height);
        times_button.setText("x");
        minus_button.setBounds(70, 290, width, height);
        minus_button.setText("-");
        plus_button.setBounds(120, 290, width, height);
        plus_button.setText("+");
        equal_button.setBounds(170, 290, width, height);
        equal_button.setText("=");


        this.setTitle("The pink Calculator ");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit out of application
        this.setResizable(false);//prevent this from being resized
        this.setSize(300, 500);
        this.setVisible(true); //make this visible
        this.getContentPane().setBackground(Color.pink);

        // Adding action listeners to buttons
        JButton[] buttons = {
                one_button, two_button, three_button, four_button, five_button,
                six_button, seven_button, eight_button, nine_button, zero_button,
                dot_button, division_button, times_button, minus_button, plus_button,
                equal_button, erase_button
        };
        for (JButton button : buttons) {
            button.addActionListener(this);
            this.add(button);
        }

        this.add(resultPanel);
        this.add(label);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        String buttonText = clickedButton.getText();
        switch (buttonText) {
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "0":
            case ".":
                if (resultLabel.getText().isEmpty() || resultLabel.getText().equals("Error")) {
                    resultLabel.setText("");
                    operand1 = ""; // Reset operand1 when starting a new operation
                    operand2 = ""; // Reset operand2 when starting a new operation
                    operation = ""; // Reset operation when starting a new operation
                }
                if (operation.isEmpty()) {
                    operand1 += buttonText;
                } else {
                    operand2 += buttonText;
                }
                resultLabel.setText(resultLabel.getText() + buttonText);
                break;
            case "/":
            case "x":
            case "-":
            case "+":
                if (!operand1.isEmpty()) {
                    operation = buttonText;
                    resultLabel.setText(resultLabel.getText() + buttonText);
                }
                break;
            case "=":
                if (!operand1.isEmpty() && !operand2.isEmpty() && !operation.isEmpty()) {
                    double result = evaluateExpression();
                    resultLabel.setText(Double.toString(result));
                    // Reset operands and operation
                    operand1 = Double.toString(result);
                    operand2 = "";
                    operation = "";
                }
                break;
            case "<-":
                if (!resultLabel.getText().isEmpty() && !resultLabel.getText().equals("Error")) {
                    String currentText = resultLabel.getText();
                    resultLabel.setText(currentText.substring(0, currentText.length() - 1));
                    if (operation.isEmpty()) {
                        operand1 = currentText.substring(0, currentText.length() - 1);
                    } else {
                        operand2 = currentText.substring(0, currentText.length() - 1);
                    }
                }
                break;
        }
    }
    private double evaluateExpression() {
        double num1 = Double.parseDouble(operand1);
        double num2 = Double.parseDouble(operand2);
        double result = 0;
        switch (operation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "x":
                result = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    JOptionPane.showMessageDialog(this, "Error: Division by zero");
                }
                break;
        }
        return result;
    }





}
