package HomePage;

import JournalPanel.Journal;

import javax.swing.*;

public class HomePage extends JFrame {
    private JPanel mainPanel;
    private JPanel header;
    private JLabel titleLabel;
    private JPanel titlePanel;

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
