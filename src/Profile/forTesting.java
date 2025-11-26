package Profile;

import javax.swing.*;

public class forTesting extends JFrame {

    private JPanel mainFrame;
    private JButton HOMEButton;
    private JButton PROFILEButton;
    private JButton WORKOUTButton;
    private JButton JOURNALButton;
    private JButton TARGETButton;
    private JLabel strive_icon;
    private JButton EDITButton;
    private JLabel title_Label;

    public forTesting(){
        setContentPane(mainFrame);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(430,800);
        setTitle("Strive");

        setVisible(true);
    }

    public void listeners(){

    }

    public static void main(String[] args) {
        new forTesting();
    }

}
