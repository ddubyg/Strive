package HomePage;

import javax.swing.*;

public class HomePage extends JFrame {
    private JPanel mainPanel;
    private JPanel titlePanel;
    private JLabel titleLabel;


    public HomePage(){
        setContentPane(mainPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(402, 874);
        setVisible(true);
    }

    public static void main(String[] args) {
        new HomePage();
    }
}
