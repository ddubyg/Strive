package Profile;

import LoginForm.UserStore;
import Profile.backend.userProfile;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        setProfilename();

        setFieldsEditable(false);

        EDITPROFILEButton.addActionListener(e -> {
            String currentAction = EDITPROFILEButton.getText();

            if(currentAction.equals("EDIT PROFILE")) {
                setFieldsEditable(true);
                EDITPROFILEButton.setText("SAVE PROFILE");
            } else {
                saveProfileChanges();
            }
        });
    }

    private void saveProfileChanges() {
        try {
            int newAge = Integer.parseInt(ageTextField.getText());
            if(newAge <= 0) throw new IllegalArgumentException("Age must be positive.");

            double newHeight = Double.parseDouble(heightTextField.getText());
            if(newHeight <= 0) throw new IllegalArgumentException("Height must be positive.");

            double newWeight = Double.parseDouble(weightProfileTextField.getText());
            if(newWeight <= 0) throw new IllegalArgumentException("Weight must be positive.");

            UserStore.age = String.valueOf(newAge);
            UserStore.height = String.valueOf(newHeight);
            UserStore.weight = String.valueOf(newWeight);

            editableJlabelBmi.setText(userProfile.getBMI());

            setFieldsEditable(false);
            EDITPROFILEButton.setText("EDIT PROFILE");

            JOptionPane.showMessageDialog(mainFrame, "Profile Updated Successfully!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(mainFrame, "Please enter valid numbers for Age, Height, and Weight.", "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e ) {
            JOptionPane.showMessageDialog(mainFrame, e.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setFieldsEditable(boolean isEditable) {
        ageTextField.setEditable(isEditable);
        heightTextField.setEditable(isEditable);
        weightProfileTextField.setEditable(isEditable);
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