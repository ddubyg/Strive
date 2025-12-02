package Main;

import HomePage.HomePage;
import JournalPanel.Journal;
import Profile.Profile;
import Workout.CardioPanel;
import Workout.StrengthPanel;
import LoginForm.Login;
import LoginForm.CreateAccount;
import Routine.RoutineForm;
import Routine.CardioForm;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PageManager extends JFrame {
    CardLayout layout = new CardLayout();
    JPanel container = new JPanel(layout);

    Login login = new Login(this);
    CreateAccount createAccount = new CreateAccount(this);
    HomePage home = new HomePage();
    Journal journal = new Journal();
    Profile profile = new Profile();
    CardioPanel cardio = new CardioPanel();
    StrengthPanel strength = new StrengthPanel();
    RoutineForm routine = new RoutineForm();
    CardioForm cardioForm = new CardioForm();

    public PageManager() {

        setTitle("Strive");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(402, 874);

        // para sa login
        container.add(login.getMainPanel(), "login");
        container.add(createAccount.getMainPanel(), "createAccount");
        // Add all panels to the CardLayout container
        container.add(home.getMainPanel(), "home");
        container.add(journal.getMainPanel(), "journal");
        container.add(profile.getMainPanel(), "profile");
        // *** ADD WORKOUT PANELS HERE ***
        container.add(strength.getMainPanel(), "strength");
        container.add(cardio.getMainPanel(), "cardio");
        container.add(routine.getMainPanel(), "routine");
        container.add(cardioForm.getMainPanel(), "cardioRoutine");

        add(container);
        layout.show(container, "login");

        setVisible(true);
        hookNavigation();
    }

    private void hookNavigation() {

        login.CREATEACCOUNTButton.addActionListener(e -> layout.show(container, "createAccount"));
        createAccount.LOGINButton   .addActionListener(e ->{
            home.setWelcome();
            layout.show(container, "login");
        });
        // --- GENERAL NAVIGATION (Home, Journal, Profile, Workout) ---
        login.ACCESSSTRIVEButton.addActionListener(e -> {
//            layout.show(container, "home");
            home.setWelcome();
        });
        // HOME PAGE buttons
        home.journal.addActionListener(e -> layout.show(container, "journal"));
        home.profile.addActionListener(e -> {
            profile.setProfilename();
            layout.show(container, "profile");
        });
        home.home.addActionListener(e -> layout.show(container, "home"));
        home.workout.addActionListener(e -> layout.show(container, "strength"));
        home.routineButton.addActionListener(e -> layout.show(container, "routine"));

        // JOURNAL PAGE NAVIGATION
        journal.homebtn.addActionListener(e -> layout.show(container, "home"));
        journal.profilebtn.addActionListener(e -> layout.show(container, "profile"));
        journal.workoutbtn.addActionListener(e -> layout.show(container, "strength"));
        journal.journalbtn.addActionListener(e -> layout.show(container, "journal"));
        journal.routineButton.addActionListener(e -> layout.show(container, "routine"));

        // PROFILE PAGE NAVIGATION
        profile.homebtn.addActionListener(e -> layout.show(container, "home"));
        profile.logoutButton.addActionListener(e -> layout.show(container, "login"));
        profile.workoutbtn.addActionListener(e -> layout.show(container, "strength"));
        profile.journalbtn.addActionListener(e -> layout.show(container, "journal"));
        profile.routineButton.addActionListener(e -> layout.show(container, "routine"));


        //WORKOUT SPECIFIC NAVIGATION
        // STRENGTH PANEL: CARDIO button switches to CardioPanel
        strength.CARDIOButton.addActionListener(e -> layout.show(container, "cardio"));
        strength.hometbn.addActionListener(e -> layout.show(container, "home"));
        strength.workoutbtn.addActionListener(e -> layout.show(container, "strength"));
        strength.journalbtn.addActionListener(e -> layout.show(container, "journal"));
        strength.profilebtn.addActionListener(e -> layout.show(container, "profile"));
        strength.routineButton.addActionListener(e -> layout.show(container, "routine"));
        strength.addWorkoutButton.addActionListener(e -> {
            String name = strength.getExerciseName();
            String sets = strength.getSets();
            String reps = strength.getReps();
            String type = strength.getTypee();
            String duration = strength.getDuration(); // e.g., "1 hr 30 min"

            if (name.isEmpty() || sets.isEmpty() || reps.isEmpty()) {
                JOptionPane.showMessageDialog(container, "Please fill in all fields");
            } else {
                // 1. Add to Routine
                routine.addWorkout(name, sets, reps, type, duration);

                // 2. Clear Inputs
                strength.clearInputs();

                // 3. SHOW SUCCESS MESSAGE (Do not switch screens)
                JOptionPane.showMessageDialog(container, "Workout added successfully!");

                // Note: We deleted 'layout.show(container, "routine");'
            }
        });

        // CARDIO PANEL: STRENGTH button switches back to StrengthPanel
        cardio.STRENGTHButton.addActionListener(e -> layout.show(container, "strength"));
        cardio.HOMEButton.addActionListener(e -> layout.show(container, "home"));
        cardio.workoutBtn.addActionListener(e -> layout.show(container, "strength"));
        cardio.journalBtn.addActionListener(e -> layout.show(container, "journal"));
        cardio.profilebtn.addActionListener(e -> layout.show(container, "profile"));
        cardio.routineButton.addActionListener(e -> layout.show(container, "routine"));
        cardio.addCardioButton.addActionListener(e -> {
            String type = cardio.getCardioType();
            String f1 = cardio.getField1();
            String f2 = cardio.getField2();
            String duration = cardio.getDuration();

            if (f1.isEmpty()) {
                JOptionPane.showMessageDialog(container, "Please enter distance/intensity.");
            } else {
                // Add to the Display Form
                cardioForm.addCardio(type, f1, f2, duration);

                // Clear inputs
                cardio.clearInputs();

                // Show Success
                JOptionPane.showMessageDialog(container, "Cardio Added Successfully!");
            }
        });

        routine.homeBtn.addActionListener(e -> layout.show(container, "home"));
        routine.journalBtn.addActionListener(e -> layout.show(container, "journal"));
        routine.workoutBtn.addActionListener(e -> layout.show(container, "strength"));
        routine.profileBtn.addActionListener(e -> layout.show(container, "profile"));
        routine.routineButton.addActionListener(e -> layout.show(container, "routine"));
        routine.GOTOCARDIOButton.addActionListener(e -> {
            layout.show(container, "cardioRoutine");
        });

        cardioForm.homebtn.addActionListener(e -> layout.show(container, "home"));
        cardioForm.journalBtn.addActionListener(e -> layout.show(container, "journal"));
        cardioForm.workoutbtn.addActionListener(e -> layout.show(container, "strength"));
        cardioForm.profileBtn.addActionListener(e -> layout.show(container, "profile"));
        cardioForm.RoutineButton.addActionListener(e -> layout.show(container, "routine"));
        cardioForm.GOTOSTRENGTHButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layout.show(container, "routine");
            }
        });


    }
    //helper
    public void showPage(String name) {

        layout.show(container, name);

    }

    public static void main(String[] args) {

        new PageManager();
    }
}