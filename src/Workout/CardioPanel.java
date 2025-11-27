package Workout;

import javax.swing.*;

public class CardioPanel extends JFrame {
    private JPanel strengthPanel;
    private JPanel titlePanel;
    private JButton CARDIOButton;
    private JButton STRENGTHButton;
    private JPanel cardioPanel;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JTextField textField2;
    private JSpinner spinner1;
    private JTextField textField3;
    private JRadioButton MALERadioButton;
    private JRadioButton FEMALERadioButton;
    private JPanel lowerPanel;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JButton CALCULATEButton;
    private JButton HOMEButton;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton routineButton;

    public CardioPanel() {
        setContentPane(strengthPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(402, 874);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CardioPanel();
    }
}
