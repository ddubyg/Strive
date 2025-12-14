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

import static Routine.CardioForm.getAdded;

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
        createAccount.LOGINButton.addActionListener(e ->{
            home.setWelcome();
            layout.show(container, "login");
        });
        // --- GENERAL NAVIGATION (Home, Journal, Profile, Workout) ---
        login.ACCESSSTRIVEButton.addActionListener(e -> {
            home.setWelcome();
        });
        // HOME PAGE buttons
        home.journal.addActionListener(e -> {
            journal.refreshJournal();
            layout.show(container, "journal");
        });
        home.profile.addActionListener(e -> {
            profile.setProfilename();
            layout.show(container, "profile");
        });
        home.home.addActionListener(e ->{
                    layout.show(container, "home");
                    home.setWelcome();
                }
        );
        home.workout.addActionListener(e -> layout.show(container, "strength"));
        home.routineButton.addActionListener(e -> layout.show(container, "routine"));
        home.STARTButton.addActionListener(e->{
            layout.show(container, "routine");
        });

        // JOURNAL PAGE NAVIGATION
        journal.homebtn.addActionListener(e -> layout.show(container, "home"));
        journal.profilebtn.addActionListener(e -> layout.show(container, "profile"));
        journal.workoutbtn.addActionListener(e -> layout.show(container, "strength"));
        journal.journalbtn.addActionListener(e -> {
            journal.refreshJournal();
            layout.show(container, "journal");
        });
        journal.routineButton.addActionListener(e -> layout.show(container, "routine"));

        // PROFILE PAGE NAVIGATION
        profile.homebtn.addActionListener(e -> layout.show(container, "home"));
        profile.logoutButton.addActionListener(e -> layout.show(container, "login"));
        profile.workoutbtn.addActionListener(e -> layout.show(container, "strength"));
        profile.journalbtn.addActionListener(e -> {
            journal.refreshJournal();
            layout.show(container, "journal");
        });
        profile.routineButton.addActionListener(e -> layout.show(container, "routine"));


        //WORKOUT SPECIFIC NAVIGATION
        // STRENGTH PANEL: CARDIO button switches to CardioPanel
        strength.CARDIOButton.addActionListener(e -> layout.show(container, "cardio"));
        strength.hometbn.addActionListener(e -> layout.show(container, "home"));
        strength.workoutbtn.addActionListener(e -> layout.show(container, "strength"));
        strength.journalbtn.addActionListener(e -> {
            journal.refreshJournal();
            layout.show(container, "journal");
        });
        strength.profilebtn.addActionListener(e -> layout.show(container, "profile"));
        strength.routineButton.addActionListener(e -> layout.show(container, "routine"));

        // --- UPDATED STRENGTH ADD BUTTON WITH VALIDATION ---
        strength.addWorkoutButton.addActionListener(e -> {
            String name = strength.getExerciseName();
            String sets = strength.getSets();
            String reps = strength.getReps();
            String type = strength.getTypee();
            String duration = strength.getDuration();

            if (name.isEmpty() || sets.isEmpty() || reps.isEmpty()) {
                JOptionPane.showMessageDialog(container, "Please fill in all fields");
            } else {
                try {
                    // 1. Validate Sets and Reps (Must be numbers)
                    Integer.parseInt(sets);
                    Integer.parseInt(reps);

                    // 2. Validate Duration (Must parse to > 0 seconds)
                    long checkTime = parseDurationToSeconds(duration);
                    if (checkTime == 0) {
                        // Throw specific exception to be caught below
                        throw new IllegalArgumentException("Invalid Duration");
                    }

                    // 3. Add to Routine (Only if validations pass)
                    routine.addWorkout(name, sets, reps, type, duration);

                    // 4. Clear Inputs
                    strength.clearInputs();

                    // 5. Success Message
                    JOptionPane.showMessageDialog(container, "Workout added successfully!");

                } catch (NumberFormatException ex) {
                    // Catches Set/Rep errors
                    JOptionPane.showMessageDialog(container,
                            "Sets and Reps must be whole numbers (e.g., 3, 12).",
                            "Input Error",
                            JOptionPane.ERROR_MESSAGE);

                } catch (IllegalArgumentException ex) {
                    // Catches Duration errors
                    JOptionPane.showMessageDialog(container,
                            "Invalid Duration! Use format '1 hr 30 min' or '45 min'.",
                            "Time Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        // --------------------------------------------------

        // CARDIO PANEL: STRENGTH button switches back to StrengthPanel
        cardio.STRENGTHButton.addActionListener(e -> layout.show(container, "strength"));
        cardio.HOMEButton.addActionListener(e -> layout.show(container, "home"));
        cardio.workoutBtn.addActionListener(e -> layout.show(container, "strength"));
        cardio.journalBtn.addActionListener(e -> {
            journal.refreshJournal();
            layout.show(container, "journal");
        });
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

                if (getAdded()) {
                    JOptionPane.showMessageDialog(container, "Cardio Added Successfully!");
                }
            }
        });

        routine.homeBtn.addActionListener(e -> layout.show(container, "home"));
        routine.journalBtn.addActionListener(e -> {
            journal.refreshJournal();
            layout.show(container, "journal");
        });
        routine.workoutBtn.addActionListener(e -> layout.show(container, "strength"));
        routine.profileBtn.addActionListener(e -> layout.show(container, "profile"));
        routine.routineButton.addActionListener(e -> layout.show(container, "routine"));
        routine.GOTOCARDIOButton.addActionListener(e -> {
            layout.show(container, "cardioRoutine");
        });

        cardioForm.homebtn.addActionListener(e -> layout.show(container, "home"));
        cardioForm.journalBtn.addActionListener(e -> {
            journal.refreshJournal();
            layout.show(container, "journal");
        });
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

    // --- HELPER METHOD FOR DURATION PARSING ---
    private long parseDurationToSeconds(String durationText) {
        long seconds = 0;
        try {
            // Normalize text to handle case sensitivity
            String text = durationText.toLowerCase();

            if (text.contains("hr")) {
                String[] parts = text.split("hr");
                int hours = Integer.parseInt(parts[0].trim());
                seconds += (hours * 3600);

                if (parts.length > 1 && parts[1].contains("min")) {
                    String minPart = parts[1].replace("min", "").trim();
                    seconds += (Integer.parseInt(minPart) * 60);
                }
            } else if (text.contains("min")) {
                String minPart = text.replace("min", "").trim();
                seconds += (Integer.parseInt(minPart) * 60);
            }
        } catch (Exception e) {
            return 0; // If parsing fails, return 0 to trigger the error
        }
        return seconds;
    }

    //helper
    public void showPage(String name) {
        layout.show(container, name);
    }

    //getter sa profile
    public Profile getProfile() {
        return profile;
    }

    public static void main(String[] args) {
        new PageManager();
    }
}