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
            if (UserStore.username == null) {
                //No account found. Please create one first.
               JOptionPane.showMessageDialog(this, "No account found. Please create one first.");
                return;
            }
            if (user.equals(UserStore.username) && pass.equals(UserStore.password)) {
                //JOptionPane.showMessageDialog(this, "Login successful!");
                manager.showPage("home");
            } else {
                JOptionPane.showMessageDialog(this, "Incorrect username or password.");
            }

        });
    }


    public JPanel getMainPanel() {
        return mainPanel;
    }
}
