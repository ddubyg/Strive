package HomePage;

import JournalPanel.Journal;

import LoginForm.UserStore;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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
    private JButton browseWorkoutButton;
    private JButton CANCELButton;
    private JButton STARTButton;
    public JButton home;
    public JButton workout;
    public JButton journal;
    public JButton profile;
    public JButton routineButton;
    private JLabel welcome;


    public HomePage(){



    }
    //setting welcome
    public void setWelcome(){

        welcome.setText("WELCOME HOME " + UserStore.displayName + "!!!");
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }


}
