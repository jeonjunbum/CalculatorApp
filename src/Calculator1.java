import javax.swing.*;
import java.awt.*;

public class Calculator1 extends JFrame {
    private JTextField displayField;

    Calculator1() {
        setTitle("계산기");
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
            p1.add(button);
        }
        add(p1, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new Calculator1();
    }
}