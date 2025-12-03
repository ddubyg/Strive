package LoginForm;

import Main.PageManager;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.lang.IllegalArgumentException;

public class CreateAccount {
    private PageManager manager;
    private JPanel mainPanel;
    private JPanel createAccountPanel;
    public JButton LOGINButton;
    public JButton CREATEACCOUNTButton;
    private JTextField userTextfield;
    public JTextField displayNameTExtfield;
    private JTextField passwordTextfield;
    private JTextField ageTextField;
    private JTextField heightTextField;
    private JTextField weightTextfield;
    public JButton CREATEPROFILEButton;

    public CreateAccount(PageManager manager) {
        this.manager = manager;
        setProfile();
    }

    // handling invalid inputs
    public void setProfile() {
        CREATEPROFILEButton.addActionListener(e -> {
            try {
                // validate age
                int age;
                try {
                    age = Integer.parseInt(ageTextField.getText());
                } catch (NumberFormatException nfe) {
                    throw new NumberFormatException("Age must be a valid whole number.");
                }

                if (age <= 0) {
                    throw new NumberFormatException("Age must be a positive integer.");
                }
                UserStore.age = String.valueOf(age);

                // validate height
                double height;
                try {
                    height = Double.parseDouble(heightTextField.getText());
                } catch (NumberFormatException nfe) {
                    throw new NumberFormatException("Height must be a valid number.");
                }

                if (height <= 0) {
                    throw new NumberFormatException("Height must be a positive number.");
                }
                UserStore.height = String.valueOf(height);

                // validate weight
                double weight;
                try {
                    weight = Double.parseDouble(weightTextfield.getText());
                } catch (NumberFormatException nfe) {
                    throw new NumberFormatException("Weight must be a valid number.");
                }

                if (weight <= 0) {
                    throw new NumberFormatException("Weight must be a positive number.");
                }
                UserStore.weight = String.valueOf(weight);

                // store data
                // check if empty
                if (userTextfield.getText().isEmpty() || passwordTextfield.getText().isEmpty()) {
                    throw new IllegalArgumentException("Username and Password cannot be empty.");
                }

                UserStore.username = userTextfield.getText();
                UserStore.password = passwordTextfield.getText();
                UserStore.displayName = displayNameTExtfield.getText().toUpperCase();

                UserStore.createProfile();

                //kani bago
                manager.getProfile().setProfilename();

                // success message
                JOptionPane.showMessageDialog(manager, "Account created!");

                // clear fields
                userTextfield.setText("");
                passwordTextfield.setText("");
                displayNameTExtfield.setText("");
                ageTextField.setText("");
                heightTextField.setText("");
                weightTextfield.setText("");

                // nav to login
                manager.showPage("login");

            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(manager, ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
