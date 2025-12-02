package LoginForm;

import Main.PageManager;

import javax.swing.*;

public class Login extends JFrame{
    private PageManager manager;
    private JPanel LoginPanel;
    public JPanel mainPanel;
    public JButton LOGINButton;
    public JButton CREATEACCOUNTButton;
    private JTextField textField1;
    private JPasswordField passwordField1;
    public JButton ACCESSSTRIVEButton;

    public Login(PageManager manager){
        this.manager = manager;
    setACCESSSTRIVEButton();
    }

    //log in code
    public void setACCESSSTRIVEButton(){
        ACCESSSTRIVEButton.addActionListener(e ->{
            String user = textField1.getText(); // catches user inputted username
            String pass = new String(passwordField1.getPassword()); // same as String pass, same functionality

            // 1. Basic empty check
            if (user.isEmpty() || pass.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter username and password.");
                return;
            }

            // 2. CALL THE FILE CHECKER
            boolean loginSuccess = UserStore.authenticate(user, pass);
            //authenticator catches user and pass then passes to UserStore
            if (loginSuccess) {
                // Login Successful
                // JOptionPane.showMessageDialog(this, "Login successful!");
                manager.showPage("home");

                // sets fields to blank
                textField1.setText("");
                passwordField1.setText("");
            } else {
                // Login Failed
                JOptionPane.showMessageDialog(this, "Incorrect username or password, or account does not exist.");
            }
        });
    }


    public JPanel getMainPanel() {
        return mainPanel;
    }
}
