package Workout;

import javax.swing.*;

public class StrengthPanel extends JFrame {
    private JPanel strengthPanel;
    private JPanel header;
    private JLabel titleLabel;
    private JPanel optionPanel;
    private JButton cardioBtn;
    private JButton strengthBtn;
    private JPanel exerciseNamePanel;
    private JComboBox nameDropDown;
    private JTextField setsTextField;
    private JTextField repsTextField;
    private JComboBox typeDropDown;
    private JLabel repsLabel;
    private JLabel typeLabel;
    private JLabel setLabel;
    private JLabel nameLabel;
    private JLabel minutesLabel;
    private JLabel durationLabel;
    private JSpinner minutesSpinner;

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
