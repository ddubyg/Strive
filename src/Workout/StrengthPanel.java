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
    public JButton addTimeButton;


    public String getExerciseName() { return exerciseNameTxtField.getText(); }
    public String getSets() { return setsTextField.getText(); }
    public String getReps() { return repsTextField.getText(); }
    public String getTypee() {
        return (typeComboBox.getSelectedItem() != null) ? typeComboBox.getSelectedItem().toString() : "General";
    }

    // Helper to get seconds from spinners
    public long getDurationInSeconds() {
        try {
            int h = (Integer) HourSpinner.getValue();
            int m = (Integer) minutesSpinner.getValue();
            return (h * 3600L) + (m * 60L);
        } catch (Exception e) {
            return 0;
        }
    }

    public void clearExerciseInputs() {
        exerciseNameTxtField.setText("");
        setsTextField.setText("");
        repsTextField.setText("");
    }

    public void clearTimeInputs() {
        HourSpinner.setValue(0);
        minutesSpinner.setValue(0);
    }


    public JPanel getMainPanel() {
        return mainPanel;
    }

}
