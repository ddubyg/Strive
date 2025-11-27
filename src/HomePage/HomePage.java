package HomePage;

import javax.swing.*;

public class HomePage extends JFrame {
    private JPanel mainPanel;
    private JPanel welcomePanel;
    private JCheckBox mondayCheckBox;
    private JCheckBox tuesdayCheckBox;
    private JCheckBox wednesdayCheckBox;
    private JCheckBox thursdayCheckBox;
    private JCheckBox fridayCheckBox;
    private JCheckBox saturdayCheckBox;
    private JCheckBox sundayCheckBox;
    private JButton browseWorkoutButton;
    private JButton CANCELButton;
    private JButton STARTButton;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton routineButton;


    public HomePage(){
        setContentPane(mainPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(402, 874);
        setVisible(true);
    }

    public static void main(String[] args) {
        new HomePage();
    }
}
