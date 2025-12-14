package Workout;

import javax.swing.*;

public class CardioPanel extends JFrame {
    private JPanel strengthPanel;
    private JPanel titlePanel;
    public JButton CARDIOButton;
    public JButton STRENGTHButton;
    private JPanel cardioPanel;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JTextField textField2;
    private JSpinner hourSpinner;
    private JPanel lowerPanel;
    public JButton HOMEButton;
    public JButton workoutBtn;
    public JButton journalBtn;
    public JButton profilebtn;
    public JButton routineButton;
    public JButton addCardioButton;
    private JPanel durationPanel;
    private JSpinner minuteSpinner;
    public JButton addTimeButton;

    public CardioPanel() { }

    public String getCardioType() {
        if (comboBox1.getSelectedItem() != null) {
            return comboBox1.getSelectedItem().toString();
        }
        return "Cardio";
    }

    public String getField1() { return textField1.getText(); }
    public String getField2() { return textField2.getText(); }

    // --- TIME LOGIC (For the Add Time Button) ---
    public long getDurationInSeconds() {
        try {
            int h = (Integer) hourSpinner.getValue();
            int m = (Integer) minuteSpinner.getValue();
            return (h * 3600L) + (m * 60L);
        } catch (Exception e) {
            return 0;
        }
    }

    // --- CLEARING INPUTS ---
    public void clearExerciseInputs() {
        textField1.setText("");
        textField2.setText("");
    }

    public void clearTimeInputs() {
        hourSpinner.setValue(0);
        minuteSpinner.setValue(0);
    }
    public JPanel getMainPanel() {
        return strengthPanel;
    }
}
