package Workout;

import javax.swing.*;

public class Workout extends JFrame {


    private JPanel mainPanel;
    private JPanel titlePanel;
    private JPanel lowerPanel;
    private JButton CARDIOButton;
    private JButton STRENGTHButton;
    private JPanel cardioPanel;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JTextField textField2;
    private JPanel durationPanel;
    private JSpinner spinner1;
    private JTextField textField3;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JPanel belowPanel;
    private JTextField textField4;
    private JTextField textField5;
    private JButton CALCULATEButton;
    private JTextField textField6;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton routineButton;
    private JComboBox comboBox2;

    public Workout(){
        setContentPane(mainPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(402, 874);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Workout();
    }
}
