package HomePage;

import LoginForm.UserStore;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.temporal.WeekFields;


public class HomePage extends JFrame {
   /* private Journal journal1;*/

    public JPanel mainPanel;
    private UserStore login;
    private JPanel welcomePanel;
    private JCheckBox mondayCheckBox;
    private JCheckBox tuesdayCheckBox;
    private JCheckBox wednesdayCheckBox;
    private JCheckBox thursdayCheckBox;
    private JCheckBox fridayCheckBox;
    private JCheckBox saturdayCheckBox;
    private JCheckBox sundayCheckBox;
    private JButton CALCULATECALORIESButton;
    private JButton STARTButton;
    public JButton home;
    public JButton workout;
    public JButton journal;
    public JButton profile;
    public JButton routineButton;
    private JLabel welcome;
    private JLabel streakLabel;
    private JLabel displayCaloriesJlabel;
    private JPanel calculatePanel;
    private JTextField ageTxtField;
    private JRadioButton MALERadioButton;
    private JRadioButton FEMALERadioButton;
    private JTextField heightTxtfield;
    private JTextField textField1;
    private JTextField activityTxtField;
    private JButton CALCULATEButton;
    private int weeklyStreak = 0;
    private boolean hasCountedThisWeek = false;
    private int lastWeekNumber = -1;

    public HomePage(){

    setWelcome();

    }
    //setting welcome
    public void setWelcome(){

        welcome.setText("Time to level up, " + UserStore.displayName + "!");
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }




}
