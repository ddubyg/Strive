package JournalPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Journal extends JFrame{

    private JPanel mainPanel;
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
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton routineButton;


    public Journal(){
        setContentPane(mainPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(402,874);
        setVisible(true);
    }

    public void clear(){
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
    }
}
