package Workout;

import javax.swing.*;

public class StrengthPanel extends JFrame {
    private JPanel strengthPanel;
    private JPanel titlePanel;
    private JButton CARDIOButton;
    private JButton STRENGTHButton;
    private JPanel cardioPanel;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JTextField textField2;

    public StrengthPanel() {
        setContentPane(strengthPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(402, 874);
        setVisible(true);
    }

    public static void main(String[] args) {
        new StrengthPanel();
    }
}
