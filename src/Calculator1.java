import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Calculator1 extends JFrame {
    private JTextField displayField;

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
            button.addActionListener(this::buttonPressed); // 이벤트 리스너 추가
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

        if (command.equals("AC")) {
            displayField.setText("0");
        } else if ("0123456789.".contains(command)) {
            displayField.setText(displayField.getText() + command);
        }
    }

    public static void main(String[] args) {
        new Calculator1();
    }
}