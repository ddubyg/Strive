package Profile;

import LoginForm.UserStore;
import Profile.backend.userProfile;

import javax.swing.*;

public class Profile extends JFrame {

    public JPanel mainFrame;
    public JButton homebtn;
    public JButton workoutbtn;
    public JButton journalbtn;
    public JButton profilebtn;
    public JButton routineButton;
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
    public  JButton logoutButton;
    private JButton EDITButton;
    private JButton confirm_button;
    private JPanel profile_panel;
    private JPanel edit_panel;
    private JLabel title_Label;

    public Profile(){

    }
    public void setProfilename(){

        userNameLabel.setText(UserStore.displayName);
        ageTextField.setText(UserStore.age);
        heightTextField.setText(UserStore.height);
        weightProfileTextField.setText(UserStore.weight);
        editableJlabelBmi.setText(userProfile.getBMI());

    }
    public JPanel getMainPanel() {
        return mainFrame;
    }


}
