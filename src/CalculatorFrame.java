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
    double lastResult = 0; // Store the result of the last operation
    String previousResult;
    JLabel resultLabel = new JLabel("");

    JButton one_button = new JButton("1");
    JButton two_button = new JButton("2");
    JButton three_button = new JButton("3");
    JButton four_button = new JButton("4");
    JButton five_button = new JButton("5");
    JButton six_button = new JButton("6");
    JButton seven_button = new JButton("7");
    JButton eight_button = new JButton("8");
    JButton nine_button = new JButton("9");
    JButton zero_button = new JButton("0");
    JButton dot_button = new JButton(".");
    JButton division_button = new JButton("/");
    JButton times_button = new JButton("x");
    JButton minus_button = new JButton("-");
    JButton plus_button = new JButton("+");
    JButton equal_button = new JButton("=");
    JButton erase_button = new JButton("<-");
    JButton ans_button = new JButton("Ans"); // previous answer button
    JButton clear_button = new JButton("Clr"); //button to clear the white panel
    JButton sqrt_button = new JButton("√");
    JButton pourcentage_button = new JButton("%");
    JButton power_button = new JButton("^");


    CalculatorFrame() {
        ImageIcon iconlogo = new ImageIcon("calculator-icon.png");
        this.setIconImage(iconlogo.getImage());//change java logo

        JLabel label = new JLabel();
        //label.setText(" Pink Calculator ");
        //background
        ImageIcon image = new ImageIcon("CALCULATOR.png");
        label.setIcon(image);
        label.setHorizontalAlignment(JLabel.CENTER);

        // Adding result label to the white panel
        JPanel resultPanel = new JPanel();
        resultPanel.setBackground(Color.white);
        resultPanel.setBounds(70, 100, 140, 40);
        resultPanel.add(resultLabel);


        //Buttons for the numbers
        one_button.setBounds(20, 170, width, height);
        two_button.setBounds(70, 170, width, height);
        three_button.setBounds(120, 170, width, height);
        four_button.setBounds(170, 170, width, height);
        five_button.setBounds(20, 210, width, height);
        six_button.setBounds(70, 210, width, height);
        seven_button.setBounds(120, 210, width, height);
        eight_button.setBounds(170, 210, width, height);
        nine_button.setBounds(20, 250, width, height);
        zero_button.setBounds(70, 250, width, height);
        dot_button.setBounds(120, 250, width, height);
        erase_button.setBounds(220,170,width,height);
        ans_button.setBounds(30,330,2*width,height);
        clear_button.setBounds(150,330,2*width,height);
        sqrt_button.setBounds(220,210,width,height);
        pourcentage_button.setBounds(220,250,width,height);
        power_button.setBounds(220,290,width,height);


        //buttons for operations

        division_button.setBounds(170, 250, width, height);
        times_button.setBounds(20, 290, width, height);
        minus_button.setBounds(70, 290, width, height);
        plus_button.setBounds(120, 290, width, height);
        equal_button.setBounds(170, 290, width, height);


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
                equal_button, erase_button, ans_button, clear_button, sqrt_button, pourcentage_button, power_button
        };
        for (JButton button : buttons) {
            button.addActionListener(this);
            this.add(button);
            button.setFocusable(false);// to stop the rectangle from appearing when clicking on a button
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
            case "^": // Add case for power operation
                handleOperation(buttonText);
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
            case "√":
                handleSquareRoot();
                break;
            case "%":
                handlePercentage();
                break;
            case "<-":
                handleBackspace();
                break;
            case "Ans":
                handleAns();
                break;
            case "Clr":
                handleClear();
                break;
        }
    }

    private void handleOperation(String op) {
        if (operand1.isEmpty()) {
            return; // If operand1 is empty, do nothing
        }

        if (!operation.isEmpty()) {
            evaluateExpression(); // If operation already exists, calculate the current result
        }

        operation = op; // Set the operation
        resultLabel.setText(resultLabel.getText() + op); // Update the result label
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
                    resultLabel.setText("Error");
                }
                break;
            case "^": // Handle power operation
                result = Math.pow(num1, num2);
                break;
        }
        previousResult = Double.toString(result);
        return result;
    }

    private void handleSquareRoot() {
        if (!operand1.isEmpty() && operation.isEmpty()) {
            double number = Double.parseDouble(operand1);
            if (number >= 0) {
                double result = Math.sqrt(number);
                resultLabel.setText(Double.toString(result));
                operand1 = Double.toString(result);
            } else {
                JOptionPane.showMessageDialog(this, "Error: Square root of a negative number");
                resultLabel.setText("Error");
            }
        }
    }

    private void handlePercentage() {
        if (!operand1.isEmpty() && operation.isEmpty()) {
            double number = Double.parseDouble(operand1);
            if (number >= 0) {
                double result = number / 100;
                resultLabel.setText(Double.toString(result));
                operand1 = Double.toString(result);
            } else {
                JOptionPane.showMessageDialog(this, "Error: cannot make a percentage out of this number");
                resultLabel.setText("Error");
            }
        }
    }

    private void handleBackspace() {
        if (!resultLabel.getText().isEmpty() && !resultLabel.getText().equals("Error")) {
            String currentText = resultLabel.getText();
            resultLabel.setText(currentText.substring(0, currentText.length() - 1));
            if (operation.isEmpty()) {
                operand1 = currentText.substring(0, currentText.length() - 1);
            } else {
                operand2 = currentText.substring(0, currentText.length() - 1);
            }
        }
    }

    private void handleAns() {
        if (!Double.isNaN(lastResult)) { // Check if lastResult is not NaN
            resultLabel.setText(resultLabel.getText() + previousResult);
        }
    }

    private void handleClear() {
        resultLabel.setText("");
    }
}
