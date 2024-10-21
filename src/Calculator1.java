import javax.swing.*;
import java.awt.*;

public class Calculator1 extends JFrame {
    private JTextField displayField;

    Calculator1() {
        setTitle("calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 700);
        setLayout(new BorderLayout());
        showNorth();
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

    public static void main(String[] args) {
        new Calculator1();
    }
}