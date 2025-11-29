package HomePage;

import JournalPanel.Journal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class HomePage extends JFrame {
   /* private Journal journal1;*/
    public JPanel mainPanel;
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


    public HomePage(){

    }
    public JPanel getMainPanel() {
        return mainPanel;
    }


}
