package HomePage;

import javax.swing.*;

public class HomePage extends JFrame {
    private JPanel mainPanel;
    private JPanel header;
    private JLabel titleLabel;
    private JPanel titlePanel;
    private JPanel addJournalPanel;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JTextArea textArea3;
    private JTextArea textArea4;
    private JTextArea textArea5;
    private JTextArea textArea6;
    private JTextArea textArea7;
    private JTextArea textArea8;
    private JButton readyToStartYourButton;
    private JButton browseExerciseButton;
    private JButton CANCELButton;
    private JButton STARTButton;
    private JPanel lowerPanel;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton routineButton;

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
