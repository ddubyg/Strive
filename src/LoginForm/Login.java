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
            String user = textField1.getText();
            String pass = new String(passwordField1.getPassword());


            if (user.isEmpty() || pass.isEmpty()) {
                JOptionPane.showMessageDialog(manager, "Please enter username and password.");
                return;
            }

            boolean loginSuccess = UserStore.authenticate(user, pass);

            if (loginSuccess) {
                manager.getProfile().setProfilename();
                manager.getHome().refreshUserData();
                manager.showPage("home");
                textField1.setText("");
                passwordField1.setText("");
            } else {
                JOptionPane.showMessageDialog(manager, "Incorrect username or password, or account does not exist.");
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
