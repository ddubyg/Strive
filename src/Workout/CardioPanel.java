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

    public CardioPanel() {

    }
    public String getCardioType() {
        if (comboBox1.getSelectedItem() != null) {
            return comboBox1.getSelectedItem().toString();
        }
        return "Cardio";
    }

    public String getField1() {
        return textField1.getText(); // e.g. Distance
    }

    public String getField2() {
        return textField2.getText(); // e.g. Notes
    }

    public String getDuration() {
        int hours = (Integer) hourSpinner.getValue();
        int minutes = (Integer) minuteSpinner.getValue();

        if (hours > 0 && minutes > 0) return hours + " hr " + minutes + " min";
        if (hours > 0) return hours + " hr";
        return minutes + " min";
    }

    public void clearInputs() {
        textField1.setText("");
        textField2.setText("");
        hourSpinner.setValue(0);
        minuteSpinner.setValue(0);
    }
    public JPanel getMainPanel() {
        return strengthPanel;
    }
}
