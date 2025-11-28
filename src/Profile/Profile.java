package Profile;

import javax.swing.*;

public class Profile extends JFrame {

    private JPanel mainFrame;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton routineButton;
    private JProgressBar progressBarWeight;
    private JButton EDITPROFILEButton;
    private JTextField ageTextField;
    private JTextField heightTextField;
    private JTextField weightProfileTextField;
    private JTextField goalTextField;
    private JTextField monthlyLogsTextField;
    private JPanel BMIpanel;
    private JLabel userNameLabel;
    private JPanel headPanel;
    private JPanel userPanel;
    private JPanel lowerPanel;
    private JPanel editablePanel;
    private JLabel editableJlabelBmi;
    private JButton EDITButton;
    private JButton confirm_button;
    private JPanel profile_panel;
    private JPanel edit_panel;
    private JLabel title_Label;

    public Profile(){
        setContentPane(mainFrame);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(402,874);
        setVisible(true);

    }



    public static void main(String[] args) {

        new Profile();
    }

}
