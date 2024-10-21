import javax.swing.*;
import java.awt.*;

public class Calculator1 extends JFrame {
    Calculator1() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 700);
        setLayout(new BorderLayout());
        setVisible(true);
    }

    public static void main(String[] args) {
        new Calculator1();
    }
}

