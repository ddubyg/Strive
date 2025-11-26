package Profile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class forTesting extends JFrame {

    private JPanel mainFrame;
    private JButton HOMEButton;
    private JButton PROFILEButton;
    private JButton WORKOUTButton;
    private JButton JOURNALButton;
    private JButton TARGETButton;
    private JLabel strive_icon;
    private JButton EDITButton;
    private JButton confirm_button;
    private JPanel profile_panel;
    private JPanel edit_panel;
    private JTextArea textArea1;
    private JLabel title_Label;

    private CardLayout cardLayout;
    private int currentIndex = 0;
    private JPanel[] panels;

    public forTesting(){
        setContentPane(mainFrame);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(402,874);
        setTitle("Strive");

        Panels();
        listeners();

        setVisible(true);

    }

    public void listeners(){

        EDITButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(currentIndex < panels.length - 1){
                    currentIndex++;
                    cardLayout.next(mainFrame);
                    updateButtonState();
                }
            }
        });

        confirm_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(currentIndex > 0){
                    currentIndex--;
                    cardLayout.previous(mainFrame);
                    updateButtonState();
                }
            }

        });
    }

    public void Panels(){
        cardLayout = new CardLayout();
        mainFrame.setLayout(cardLayout);

        panels = new JPanel[]{profile_panel, edit_panel};

        mainFrame.add(profile_panel,"profile_panel");
        mainFrame.add(edit_panel,"edit_panel");

        cardLayout.show(mainFrame, "profile_panel");
        updateButtonState();
    }

    private void updateButtonState() {
        confirm_button.setEnabled(currentIndex > 0);
        EDITButton.setEnabled(currentIndex < panels.length - 1);
    }

    public static void main(String[] args) {
        new forTesting();
    }

}
