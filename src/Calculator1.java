import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Calculator1 extends JFrame {
    private JTextField displayField;
    private boolean startOfNumber = true;
    private String operator = "=";
    private double result = 0;

    Calculator1() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 700);
        setLayout(new BorderLayout());
        showNorth();
        showCenter();
        setVisible(true);
    }

    void showNorth() {
        JPanel p1 = new JPanel();
        p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));

        displayField = new JTextField("0");
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        displayField.setEditable(false);
        displayField.setFont(new Font("SansSerif", Font.PLAIN, 20));
        displayField.setPreferredSize(new Dimension(500, 100));

        p1.add(displayField);
        add(p1, BorderLayout.NORTH);
    }

    void showCenter() {
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(5, 4, 2, 2));

        String[] buttonLabels = {
                "AC", "CE", "BS", "÷",
                "1", "2", "3", "x",
                "4", "5", "6", "-",
                "7", "8", "9", "+",
                "±", "0", ".", "="
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("SansSerif", Font.PLAIN, 20));
            button.addActionListener(this::buttonPressed);
            p1.add(button);

            if ("0123456789±.".contains(label)) {
                button.setBackground(Color.LIGHT_GRAY);
            } else {
                button.setBackground(Color.gray);
            }
        }

        add(p1, BorderLayout.CENTER);
    }

    private void buttonPressed(ActionEvent e) {
        String command = ((JButton) e.getSource()).getText();

        // AC 버튼 클릭 처리
        if (command.equals("AC")) {
            result = 0;
            operator = "=";
            startOfNumber = true;
            displayField.setText("0");
        } else if (command.equals("CE")) {
            displayField.setText("0");
            startOfNumber = true;
        } else if (command.equals("BS")) {
            String currentText = displayField.getText();
            if (currentText.length() > 1) {
                displayField.setText(currentText.substring(0, currentText.length() - 1));
            } else {
                displayField.setText("0");
                startOfNumber = true;
            }
        } else if ("0123456789.".contains(command)) {
            if (startOfNumber || displayField.getText().equals("0")) {
                displayField.setText(command);
                startOfNumber = false;
            } else {
                displayField.setText(displayField.getText() + command);
            }
        } else if (command.equals("±")) {
            double value = Double.parseDouble(displayField.getText());
            displayField.setText(String.valueOf(-value));
        } else { // 연산자 처리
            if (startOfNumber && !command.equals("=")) {
                operator = command;
            } else {
                double x = Double.parseDouble(displayField.getText());
                calculate(x);
                operator = command;
                startOfNumber = true;
            }
        }
    }

    private void calculate(double x) {
    }

    public static void main (String[]args){
            new Calculator1();
        }
    }
