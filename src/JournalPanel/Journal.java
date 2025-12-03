package JournalPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.time.*;


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
    loadHistoryIntoLabels();
    setCLEARButton();
    setSAVEButton();
    setRemoveSelectedButton();
    }

    public void setCLEARButton(){
        CLEARButton.addActionListener(e->{
        writeJournal.setText("");
        });
    }
    public void setSAVEButton(){
        SAVEButton.addActionListener(e->{
            String text = writeJournal.getText();
            if (text.isEmpty()){
                return;
            };
            String mood = chooseBox.getSelectedItem().toString();

            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd || HH:mm"); // time format
            String timestamp = java.time.LocalDateTime.now().format(fmt); // added format, in order to follow the
            //format set above the time stamp


            JournalEntry entry = new JournalEntry(mood, text, timestamp);

            JournalFileManager.saveEntry(entry);

            loadHistoryIntoLabels();

            writeJournal.setText("");
        });

    }
    public void setRemoveSelectedButton(){
        removeSelectedButton.addActionListener(e -> {
            int index = getSelectedHistoryIndex();
            if (index != -1) {
                JournalFileManager.deleteEntry(index);
                loadHistoryIntoLabels();
            }
        });
    }
    public void loadHistoryIntoLabels() {
        List<String> entries = JournalFileManager.loadEntries();

        firstHistoryLabel.setText(entries.size() > 0 ? entries.get(0) : "");
        secondHistoryLabel.setText(entries.size() > 1 ? entries.get(1) : "");
        thirdHistoryLabel.setText(entries.size() > 2 ? entries.get(2) : "");
        fourthHistoryLabel.setText(entries.size() > 3 ? entries.get(3) : "");
    }


    private int getSelectedHistoryIndex() {
        return -1;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }


}
