package HomePage;

import JournalPanel.Journal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class HomePage extends JFrame {
    private Journal journal1;
    private JPanel mainPanel;
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
    private JButton home;
    private JButton workout;
    private JButton journal;
    private JButton profile;
    private JButton routineButton;


    public HomePage(){
        setContentPane(mainPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(402, 874);

        journal1 = new Journal();
        journal1.setVisible(false);

        setVisible(true);
        setJournal();
    }



    // para sa browse workout
    public void setBrowseWorkoutButton(){
        browseWorkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    // para sa cancel button
    public void setCANCELButton(){
        CANCELButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    //para sa start button
    public void setSTARTButton(){
        STARTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    // para sa home button
    public void setHome(){
        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    // para sa workout button
    public void setWorkout(){
        workout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    // para sa journal button
    public void setJournal(){
        journal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                showPanel(1);
                setVisible(false);
                //journal1 = new Journal();
            }
        });
    }

    // para sa profile button
    public void setProfile(){
        profile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    // para sa routine button
    public void setRoutineButton(){
        routineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }


    public void showPanel(int num){
        journal1.setVisible(num == 1);
    }



    public static void main(String[] args) {
        new HomePage();
    }

}
