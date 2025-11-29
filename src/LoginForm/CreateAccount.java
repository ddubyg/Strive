package LoginForm;

import Main.PageManager;

import javax.swing.*;
import java.awt.event.ActionListener;

public class CreateAccount{
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

    public CreateAccount(PageManager manager){
        this.manager = manager;
    setProfile();
    }
// para sa log in and to store some info for profile
    public void setProfile(){
        CREATEPROFILEButton.addActionListener(e ->{
            UserStore.username = userTextfield.getText();
            UserStore.password = passwordTextfield.getText();
            UserStore.displayName = displayNameTExtfield.getText().toUpperCase();
            UserStore.age = ageTextField.getText();
            UserStore.height = heightTextField.getText();
            UserStore.weight = weightTextfield.getText();
            JOptionPane.showMessageDialog(null, "Account created!");
            userTextfield.setText("");
            passwordTextfield.setText("");
            displayNameTExtfield.setText("");
            ageTextField.setText("");
            heightTextField.setText("");
            weightTextfield.setText("");

            manager.showPage("login");

        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
