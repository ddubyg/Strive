package Profile;

import LoginForm.UserStore;
import Profile.backend.userProfile;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;

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

    //
    public Profile(){
        progressBarWeight.setBackground(new java.awt.Color(10, 25, 45));
        // "Foreground" is the filled part (Bright Blue)
        progressBarWeight.setForeground(new java.awt.Color(66, 135, 245));

        progressBarWeight.setStringPainted(true);

        // 2. Initialize Data
        setProfilename(); // This now calls updateProgressBar() inside it (from previous step)

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
    //
    //
    private void updateProgressBar() {
        try {
            double currentW = Double.parseDouble(weightProfileTextField.getText());
            double goalW = Double.parseDouble(goalTextField.getText());

            if (goalW <= 0) {
                progressBarWeight.setValue(0);
                progressBarWeight.setString("0%");
                return;
            }

            int progressPercent;

            if (currentW == goalW) {
                progressPercent = 100;
            }
            // Weight LOSS
            else if (currentW > goalW) {
                progressPercent = (int) ((goalW / currentW) * 100);
            }
            // Weight GAIN
            else {
                progressPercent = (int) ((currentW / goalW) * 100);
            }

            // Clamp safety
            progressPercent = Math.max(0, Math.min(progressPercent, 100));

            progressBarWeight.setValue(progressPercent);
            progressBarWeight.setString(progressPercent + "%");

        } catch (Exception e) {
            progressBarWeight.setValue(0);
            progressBarWeight.setString("0%");
        }
    }


    //
    private void saveProfileChanges() {
        try {
            // 1. Get the numbers from the text fields
            int newAge = Integer.parseInt(ageTextField.getText());
            double newHeight = Double.parseDouble(heightTextField.getText());
            double newCurrentWeight = Double.parseDouble(weightProfileTextField.getText());
            double newGoalWeight = Double.parseDouble(goalTextField.getText());

            // 2. CHECK IF THIS IS A NEW GOAL
            // If the user changed the goal number OR if it's their first time (null)
            String previousGoal = UserStore.goalWeight;
            boolean isNewGoal = previousGoal == null || !previousGoal.equals(String.valueOf(newGoalWeight));

            // 3. AUTO-SET START WEIGHT
            // If it's a new goal, we say "Okay, we are starting from HERE (Current Weight)"
            if (isNewGoal) {
                UserStore.startWeight = String.valueOf(newCurrentWeight);
            }
            // (If the goal is the same, we keep the old startWeight so the bar continues to fill up)

            // 4. Save everything to UserStore
            UserStore.age = String.valueOf(newAge);
            UserStore.height = String.valueOf(newHeight);
            UserStore.weight = String.valueOf(newCurrentWeight);
            UserStore.goalWeight = String.valueOf(newGoalWeight);

            // 5. Update the Database File and UI
            UserStore.updateUserFile();
            editableJlabelBmi.setText(userProfile.getBMI());

            updateProgressBar(); // Recalculate the bar immediately

            // 6. Reset UI buttons
            setFieldsEditable(false);
            EDITPROFILEButton.setText("EDIT PROFILE");

            JOptionPane.showMessageDialog(mainFrame, "Profile & Goals Updated!");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(mainFrame, "Please enter valid numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setFieldsEditable(boolean isEditable) {
        ageTextField.setEditable(isEditable);
        heightTextField.setEditable(isEditable);
        weightProfileTextField.setEditable(isEditable);
        goalTextField.setEditable(isEditable); // ADD THIS
    }

    public void setProfilename(){
        if(UserStore.height == null || UserStore.weight == null) {
            return;
        }

        userNameLabel.setText(UserStore.displayName);
        ageTextField.setText(UserStore.age);
        heightTextField.setText(UserStore.height);
        weightProfileTextField.setText(UserStore.weight);

        // NEW: Load the goal from UserStore
        goalTextField.setText(UserStore.goalWeight);

        editableJlabelBmi.setText(userProfile.getBMI());

        // NEW: Update the bar immediately
        updateProgressBar();
    }
    public JPanel getMainPanel() {
        return mainFrame;
    }


}