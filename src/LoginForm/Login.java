package LoginForm;

import javax.swing.*;

public class Login extends JFrame{
    private JPanel LoginPanel;
    private JPanel mainPanel;
    private JTextField textField1;
    private JPasswordField passwordField1;

    public Login(){
        setContentPane(mainPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(402,874);
        setVisible(true);
    }
}
