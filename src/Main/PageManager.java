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

            if (name.isEmpty() || sets.isEmpty() || reps.isEmpty()) {
                JOptionPane.showMessageDialog(container, "Please fill in Name, Sets, and Reps.");
            } else {
                try {
                    // 1. Validate Numbers
                    Integer.parseInt(sets);
                    Integer.parseInt(reps);

                    // 2. Add to Routine (Visual card only)
                    routine.addWorkout(name, sets, reps, type);

                    // 3. Clear the text fields for the next exercise
                    strength.clearExerciseInputs();

                    // 4. Ask if they want to add more
                    int choice = JOptionPane.showConfirmDialog(container,
                            "Workout added! Do you want to add another exercise?",
                            "Continue?",
                            JOptionPane.YES_NO_OPTION);

                    if (choice == JOptionPane.NO_OPTION) {
                        JOptionPane.showMessageDialog(container,
                                "Great! Now set the duration in the spinners and click 'Add Time'.");
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(container, "Sets and Reps must be whole numbers.");
                }
            }
        });
        strength.addTimeButton.addActionListener(e -> {
            // 1. Get the time from the spinners
            long totalSeconds = strength.getDurationInSeconds();

            // 2. Validate
            if (totalSeconds <= 0) {
                JOptionPane.showMessageDialog(container,
                        "Please select a duration (Hours/Minutes) greater than 0.",
                        "Invalid Time",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                // 3. Send to Routine Form
                routine.setTotalRoutineTime(totalSeconds);

                // 4. Success Message
                // Convert back to text just for the message (e.g., "1 hr 30 min")
                long h = totalSeconds / 3600;
                long m = (totalSeconds % 3600) / 60;
                String timeText = (h > 0 ? h + " hr " : "") + (m > 0 ? m + " min" : "");

                JOptionPane.showMessageDialog(container,
                        "Total duration set to: " + timeText + ".\nYour routine is ready!");

                // 5. Clear the spinners
                strength.clearTimeInputs();
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

        // --- LISTENER 1: ADD CARDIO EXERCISE ---
        cardio.addCardioButton.addActionListener(e -> {
            String type = cardio.getCardioType(); // Gets ComboBox selection
            String f1 = cardio.getField1();
            String f2 = cardio.getField2();

            // Basic Validation: Just need at least one field filled (like Distance)
            if (f1.isEmpty()) {
                JOptionPane.showMessageDialog(container, "Please enter distance or intensity (Field 1).");
            } else {
                // 1. Add to the Form (Visual only)
                cardioForm.addCardio(type, f1, f2);

                // 2. Clear text inputs
                cardio.clearExerciseInputs();

                // 3. Ask to Add More
                int choice = JOptionPane.showConfirmDialog(container,
                        "Cardio added! Do you want to add another activity?",
                        "Continue?",
                        JOptionPane.YES_NO_OPTION);

                if (choice == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(container,
                            "Great! Now please set the TOTAL duration in the spinners and click 'Add Time'.");
                }
            }
        });

// --- LISTENER 2: ADD TIME ---
        cardio.addTimeButton.addActionListener(e -> {
            long seconds = cardio.getDurationInSeconds();

            if (seconds <= 0) {
                JOptionPane.showMessageDialog(container, "Please set a duration greater than 0.");
            } else {
                // 1. Send total time to CardioForm
                cardioForm.setTotalCardioTime(seconds);

                // 2. Success Message
                long h = seconds / 3600;
                long m = (seconds % 3600) / 60;
                String timeText = (h > 0 ? h + " hr " : "") + (m > 0 ? m + " min" : "");

                JOptionPane.showMessageDialog(container, "Total Cardio Duration set to: " + timeText);

                // 3. Clear spinners
                cardio.clearTimeInputs();
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

    public HomePage getHome() {
        return home;
    }


    public static void main(String[] args) {
        new PageManager();
    }
}