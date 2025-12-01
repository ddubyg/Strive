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
    private int weeklyStreak = 0;
    private boolean hasCountedThisWeek = false;
    private int lastWeekNumber = -1;

    public HomePage(){
        setStreakLabel();

    }
    //setting welcome
    public void setWelcome(){

        welcome.setText("WELCOME HOME " + UserStore.displayName + "!!!");
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }


    public void setStreakLabel(){
        STARTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocalDate today = LocalDate.now();
                int currentWeek = today.get(WeekFields.ISO.weekOfYear());

                if (currentWeek != lastWeekNumber) {
                    hasCountedThisWeek = false;
                    lastWeekNumber = currentWeek;
                }
                boolean selected =
                        mondayCheckBox.isSelected() ||
                                tuesdayCheckBox.isSelected() ||
                                wednesdayCheckBox.isSelected() ||
                                thursdayCheckBox.isSelected() ||
                                fridayCheckBox.isSelected() ||
                                saturdayCheckBox.isSelected() ||
                                sundayCheckBox.isSelected();

                if (selected && !hasCountedThisWeek) {
                    weeklyStreak++;
                    hasCountedThisWeek = true;
                }
                streakLabel.setText(String.valueOf(weeklyStreak));

            }
        });
    }


}
