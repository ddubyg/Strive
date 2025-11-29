package LoginForm;

import javax.swing.*;

public class Login extends JFrame{
    private JPanel LoginPanel;
    public JPanel mainPanel;
    public JButton LOGINButton;
    public JButton CREATEACCOUNTButton;
    private JTextField textField1;
    private JPasswordField passwordField1;
    public JButton ACCESSSTRIVEButton;

    public Login(){
   /*     setContentPane(mainPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(402,874);
        setVisible(true);*/
    }

    public JPanel getMainPanel() {

        return mainPanel;
    }
}
