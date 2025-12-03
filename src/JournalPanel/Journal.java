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


    private int selectedIndex = -1;

    public Journal(){
    loadHistoryIntoLabels();
    setCLEARButton();
    setSAVEButton();
    setRemoveSelectedButton();

        setHistorySelection();
        highlightSelected();
    }



    // setHistorySelection Still needs more work
    // adds listener to each entry labels for deletion purposes
    // calls the highliughtSelected function in order to show user
    // then passes to deleter
    // deleter is at journalFileManager line 52
    private void setHistorySelection() {

        firstHistoryLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectedIndex = 0;
                highlightSelected();
            }
        });

        secondHistoryLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectedIndex = 1;
                highlightSelected();
            }
        });

        thirdHistoryLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectedIndex = 2;
                highlightSelected();
            }
        });

        fourthHistoryLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectedIndex = 3;
                highlightSelected();
            }
        });
    }

    //this still needs improvement but, if it works it works ig
    // selects and highlights specific labels which contains the entry
    // then is called by the deleter
    private void highlightSelected() {
        firstHistoryLabel.setOpaque(true);
        secondHistoryLabel.setOpaque(true);
        thirdHistoryLabel.setOpaque(true);
        fourthHistoryLabel.setOpaque(true);

        // Reset all to default (no background color)
        firstHistoryLabel.setBackground(null);
        secondHistoryLabel.setBackground(null);
        thirdHistoryLabel.setBackground(null);
        fourthHistoryLabel.setBackground(null);

        // Apply highlight based on selectedIndex
        if (selectedIndex == 0) {
            firstHistoryLabel.setBackground(java.awt.Color.LIGHT_GRAY);
        } else if (selectedIndex == 1) {
            secondHistoryLabel.setBackground(java.awt.Color.LIGHT_GRAY);
        } else if (selectedIndex == 2) {
            thirdHistoryLabel.setBackground(java.awt.Color.LIGHT_GRAY);
        } else if (selectedIndex == 3) {
            fourthHistoryLabel.setBackground(java.awt.Color.LIGHT_GRAY);
        }
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
                selectedIndex = -1;
                loadHistoryIntoLabels();
            }else {
                // optional: inform user
                JOptionPane.showMessageDialog(this, "Please select an entry to remove.");
            }
        });
    }

    public void loadHistoryIntoLabels() {
        List<String> entries = JournalFileManager.loadEntries();

        firstHistoryLabel.setText(entries.size() > 0 ? entries.get(0) : "");
        secondHistoryLabel.setText(entries.size() > 1 ? entries.get(1) : "");
        thirdHistoryLabel.setText(entries.size() > 2 ? entries.get(2) : "");
        fourthHistoryLabel.setText(entries.size() > 3 ? entries.get(3) : "");

        // If the selectedIndex points to an entry that no longer exists, reset it
        if (selectedIndex >= entries.size()) {
            selectedIndex = -1;
        }
        highlightSelected();
    }


    private int getSelectedHistoryIndex() {
        return selectedIndex;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }


}
