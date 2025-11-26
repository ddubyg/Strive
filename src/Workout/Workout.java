package Workout;

import javax.swing.*;

public class Workout extends JFrame {


    private JPanel mainPanel;

    public Workout(){
        setContentPane(mainPanel);
        setSize(402, 874);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Workout();
    }
}
