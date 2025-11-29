package Main;

import HomePage.HomePage;
import JournalPanel.Journal;
import Profile.Profile;
import Workout.CardioPanel;
import Workout.StrengthPanel;
import LoginForm.Login;
import  LoginForm.CreateAccount;


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

        // JOURNAL PAGE NAVIGATION
        journal.homebtn.addActionListener(e -> layout.show(container, "home"));
        journal.profilebtn.addActionListener(e -> layout.show(container, "profile"));
        journal.workoutbtn.addActionListener(e -> layout.show(container, "strength"));
        journal.journalbtn.addActionListener(e -> layout.show(container, "journal"));

        // PROFILE PAGE NAVIGATION
        profile.homebtn.addActionListener(e -> layout.show(container, "home"));
        profile.logoutButton.addActionListener(e -> layout.show(container, "login"));
        profile.workoutbtn.addActionListener(e -> layout.show(container, "strength"));
        profile.journalbtn.addActionListener(e -> layout.show(container, "journal"));


        //WORKOUT SPECIFIC NAVIGATION
        // STRENGTH PANEL: CARDIO button switches to CardioPanel
        strength.CARDIOButton.addActionListener(e -> layout.show(container, "cardio"));
        strength.hometbn.addActionListener(e -> layout.show(container, "home"));
        strength.workoutbtn.addActionListener(e -> layout.show(container, "strength"));
        strength.journalbtn.addActionListener(e -> layout.show(container, "journal"));
        strength.profilebtn.addActionListener(e -> layout.show(container, "profile"));

        // CARDIO PANEL: STRENGTH button switches back to StrengthPanel
        cardio.STRENGTHButton.addActionListener(e -> layout.show(container, "strength"));
        cardio.HOMEButton.addActionListener(e -> layout.show(container, "home"));
        cardio.workoutBtn.addActionListener(e -> layout.show(container, "strength"));
        cardio.journalBtn.addActionListener(e -> layout.show(container, "journal"));
        cardio.profilebtn.addActionListener(e -> layout.show(container, "profile"));
    }
    //helper
    public void showPage(String name) {

        layout.show(container, name);

    }

    public static void main(String[] args) {

        new PageManager();
    }
}