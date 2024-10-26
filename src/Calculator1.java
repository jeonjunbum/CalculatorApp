import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Java Swing을 이용한 간단한 계산기 GUI 애플리케이션입니다.
 * 이 클래스는 덧셈, 뺄셈, 곱셈, 나눗셈 등의 기본 계산 기능과 초기화, 부호 변환 등의 기능을 제공합니다.
 *
 * @author Your Name
 * @version 1.0
 * @since 2024-10-24
 */
public class Calculator1 extends JFrame {
    private JTextField displayField;
    private boolean startOfNumber = true;
    private String operator = "=";
    private double result = 0;

    /**
     * Calculator1 GUI를 생성하여 디스플레이와 버튼을 초기화합니다.
     * 메인 윈도우를 설정하고 구성 요소를 배치합니다.
     */
    Calculator1() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 700);
        setLayout(new BorderLayout());
        showNorth();
        showCenter();
        setVisible(true);
    }

    /**
     * 계산기 상단에 위치하는 디스플레이 필드를 초기화하고 설정합니다.
     * 현재 입력 값이나 결과를 표시합니다.
     */
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

    /**
     * 계산기의 버튼들을 그리드 레이아웃으로 생성하고 배치합니다.
     * 버튼에는 숫자(0-9), 연산자(+, -, x, ÷), 특수 기능(AC, CE, BS, ±)이 포함됩니다.
     */
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

    /**
     * 버튼 클릭 이벤트를 처리하여 적절한 계산이나 작업을 수행합니다.
     *
     * @param e 버튼이 눌릴 때 발생하는 ActionEvent
     */
    private void buttonPressed(ActionEvent e) {
        String command = ((JButton) e.getSource()).getText();

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
        } else {
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

    /**
     * 선택된 연산자를 바탕으로 계산을 수행하고 결과를 디스플레이에 업데이트합니다.
     *
     * @param x 계산에 사용할 숫자
     */
    private void calculate(double x) {
        switch (operator) {
            case "+":
                result += x;
                break;
            case "-":
                result -= x;
                break;
            case "x":
                result *= x;
                break;
            case "÷":
                if (x != 0) {
                    result /= x;
                } else {
                    JOptionPane.showMessageDialog(this, "0으로 나눌 수 없습니다.");
                }
                break;
            case "=":
                result = x;
                break;
        }
        displayField.setText("" + result);
    }

    /**
     * 계산기 애플리케이션을 시작하는 메인 메서드입니다.
     *
     * @param args 커맨드 라인 인수(사용되지 않음)
     */
    public static void main(String[] args) {
        new Calculator1();
    }
}
