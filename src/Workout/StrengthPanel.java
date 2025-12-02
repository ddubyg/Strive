package Workout;


import javax.swing.*;

public class StrengthPanel extends JFrame {


    private JPanel mainPanel;
    private JPanel titlePanel;
    private JPanel lowerPanel;
    public JButton CARDIOButton;
    private JButton STRENGTHButton;
    private JPanel cardioPanel;
    private JTextField setsTextField;
    private JTextField repsTextField;
    private JPanel durationPanel;
    private JSpinner HourSpinner;
    private JPanel belowPanel;
    public JButton hometbn;
    public JButton workoutbtn;
    public JButton journalbtn;
    public JButton profilebtn;
    public JButton routineButton;
    public JComboBox typeComboBox;
    private JTextField exerciseNameTxtField;
    public JButton addWorkoutButton;
    private JSpinner minutesSpinner;


    public String getExerciseName() {
        return exerciseNameTxtField.getText();
    }

    public String getSets() {
        return setsTextField.getText();
    }

    public String getReps() {
        return repsTextField.getText();
    }

    public String getTypee() {
        if (typeComboBox.getSelectedItem() != null) {
            return typeComboBox.getSelectedItem().toString();
        }
        return "General";
    }

    // --- UPDATED DURATION LOGIC ---
    public String getDuration() {
        // Safe casting to Integer (Spinners usually return Objects)
        int hours = (Integer) HourSpinner.getValue();
        int minutes = (Integer) minutesSpinner.getValue();

        // Logic to format it nicely
        if (hours > 0 && minutes > 0) {
            return hours + " hr " + minutes + " min";
        } else if (hours > 0) {
            return hours + " hr";
        } else {
            return minutes + " min";
        }
    }

    // --- UPDATED CLEAR INPUTS ---
    public void clearInputs() {
        exerciseNameTxtField.setText("");
        setsTextField.setText("");
        repsTextField.setText("");
        // Reset both spinners to 0
        HourSpinner.setValue(0);
        minutesSpinner.setValue(0);
    }


    public JPanel getMainPanel() {
        return mainPanel;
    }

}
