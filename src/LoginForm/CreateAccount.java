package LoginForm;

import Main.PageManager;

import javax.swing.*;
import java.awt.event.ActionListener;

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

    // This method is responsible for handling the profile creation process
    public void setProfile() {
        CREATEPROFILEButton.addActionListener(e -> {
            try {
                // Validate and parse age as integer
                int age = Integer.parseInt(ageTextField.getText());
                if (age <= 0) {
                    throw new NumberFormatException("Age must be a positive integer.");
                }
                UserStore.age = String.valueOf(age);

                // Validate and parse height as double
                double height = Double.parseDouble(heightTextField.getText());
                if (height <= 0) {
                    throw new NumberFormatException("Height must be a positive number.");
                }
                UserStore.height = String.valueOf(height);

                // Validate and parse weight as double
                double weight = Double.parseDouble(weightTextfield.getText());
                if (weight <= 0) {
                    throw new NumberFormatException("Weight must be a positive number.");
                }
                UserStore.weight = String.valueOf(weight);

                // Store other user data
                UserStore.username = userTextfield.getText();
                UserStore.password = passwordTextfield.getText();
                UserStore.displayName = displayNameTExtfield.getText().toUpperCase();


                UserStore.createProfile();

                // Show success message
                JOptionPane.showMessageDialog(null, "Account created!");

                // Clear the input fields
                userTextfield.setText("");
                passwordTextfield.setText("");
                displayNameTExtfield.setText("");
                ageTextField.setText("");
                heightTextField.setText("");
                weightTextfield.setText("");

                // Navigate to login page
                manager.showPage("login");

            } catch (NumberFormatException ex) {
                // Show error message in case of invalid input
                JOptionPane.showMessageDialog(null, "Invalid input: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
