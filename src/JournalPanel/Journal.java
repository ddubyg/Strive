package JournalPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Journal extends JFrame{

    public JPanel mainPanel;
    private JTextArea writeJournal;
    private JComboBox chooseBox;
    private JButton CLEARButton;
    private JButton SAVEButton;
    private JPanel addJournalPanel;
    private JButton removeSelectedButton;
    private JPanel firstHIstory;
    private JPanel secondHistory;
    private JPanel thirdHistory;
    private JPanel fouthHistory;
    private JPanel titlePanel;
    private JLabel firstHistoryLabel;
    private JLabel secondHistoryLabel;
    private JLabel thirdHistoryLabel;
    private JLabel fourthHistoryLabel;
    private JPanel lowerPanel;
    private JLabel titleLabel;
    public JButton homebtn;
    public JButton workoutbtn;
    public JButton journalbtn;
    public JButton profilebtn;
    public JButton routineButton;


    public Journal(){
       /* setContentPane(mainPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(402,874);
        setVisible(true);*/
    }
    public JPanel getMainPanel() {
        return mainPanel;
    }


   /* public void clear(){
        CLEARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public void save(){
        SAVEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        new Journal();
    }*/
}
