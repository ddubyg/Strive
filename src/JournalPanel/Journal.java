package JournalPanel;

import JournalPanel.JournalFileManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Journal extends JFrame {

    public JPanel mainPanel;
    private JTextArea writeJournal;
    private JComboBox<String> chooseBox;
    private JButton CLEARButton;
    private JButton SAVEButton;
    private JPanel addJournalPanel;
    private JButton removeSelectedButton;

    // History Panels
    private JPanel firstHIstory;
    private JPanel secondHistory;
    private JPanel thirdHistory;
    private JPanel fouthHistory;


    private JPanel titlePanel;
    private JPanel lowerPanel;
    private JLabel titleLabel;

    // Public buttons for PageManager
    public JButton homebtn;
    public JButton workoutbtn;
    public JButton journalbtn;
    public JButton profilebtn;
    public JButton routineButton;

    private int selectedIndex = -1;
    private DefaultListModel<String> listModel;
    private JList<String> entryList;

    public Journal() {
        listModel = new DefaultListModel<>();
        entryList = new JList<>(listModel);

        initComponentsSafely(); // Prevent NullPointer crash

        // 1. Load Data
        loadHistoryIntoPanels();

        // 2. Setup Buttons
        setCLEARButton();
        setSAVEButton();
        setRemoveSelectedButton();

        // 3. Setup Selection Logic on the PANELS
        setPanelSelectionListeners();
        highlightSelected();
    }

    //refresher, basically just calls the loadHistory but this gives me less eyestrain and headaches
    public void refreshJournal() {
        loadHistoryIntoPanels();
    }

    // --- SAFETY CHECK ---
    private void initComponentsSafely() {
        if (mainPanel == null) mainPanel = new JPanel();

        // Initialize Panels if they are null (GUI Builder failed)
        if (firstHIstory == null) firstHIstory = new JPanel();
        if (secondHistory == null) secondHistory = new JPanel();
        if (thirdHistory == null) thirdHistory = new JPanel();
        if (fouthHistory == null) fouthHistory = new JPanel();

        if (writeJournal == null) writeJournal = new JTextArea();
        if (chooseBox == null) chooseBox = new JComboBox<>();
        if (SAVEButton == null) SAVEButton = new JButton("Save");
        if (CLEARButton == null) CLEARButton = new JButton("Clear");
        if (removeSelectedButton == null) removeSelectedButton = new JButton("Remove");
    }

    // --- NEW DISPLAY LOGIC ---
    public void loadHistoryIntoPanels() {
        List<JournalEntry> entries = JournalFileManager.loadEntries();

        // Update each panel dynamically
        updateSinglePanel(firstHIstory, entries.size() > 0 ? entries.get(0) : null);
        updateSinglePanel(secondHistory, entries.size() > 1 ? entries.get(1) : null);
        updateSinglePanel(thirdHistory, entries.size() > 2 ? entries.get(2) : null);
        updateSinglePanel(fouthHistory, entries.size() > 3 ? entries.get(3) : null);

        if (selectedIndex >= entries.size()) selectedIndex = -1;
        highlightSelected();
    }



    // Helper to add text inside a JPanel
    private void updateSinglePanel(JPanel panel, JournalEntry entry) {
        if (panel == null) return;

        // 1. Clear previous content (old text)
        panel.removeAll();

        // 2. Set layout so text fills the box
        panel.setLayout(new BorderLayout());

        // 3. If there is data, create a temporary label and add it
        if (entry != null) {
            JLabel tempLabel = new JLabel(entry.toHtmlDisplay());
            tempLabel.setVerticalAlignment(SwingConstants.TOP); // Start text at top

            // Allow mouse clicks on the label to pass through to the panel
            tempLabel.setOpaque(false);

            panel.add(tempLabel, BorderLayout.CENTER);
        }

        // 4. Refresh the UI
        panel.revalidate();
        panel.repaint();
    }

    public void setSAVEButton() {
        SAVEButton.addActionListener(e -> {
            String text = writeJournal.getText();
            if (text.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Journal entry cannot be empty.");
                return;
            }

            String mood = "General";
            if (chooseBox.getSelectedItem() != null) {
                mood = chooseBox.getSelectedItem().toString();
            }

            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MMM dd, HH:mm");
            String timestamp = LocalDateTime.now().format(fmt);

            JournalEntry entry = new JournalEntry(mood, text, timestamp);
            JournalFileManager.saveEntry(entry);

            loadHistoryIntoPanels(); // Reload panels
            writeJournal.setText("");
            chooseBox.setSelectedIndex(0);
        });
    }

    // --- SELECTION LOGIC (Now on Panels) ---

    private void setPanelSelectionListeners() {
        // We add listeners to the Panel, not the label
        addClickToPanel(firstHIstory, 0);
        addClickToPanel(secondHistory, 1);
        addClickToPanel(thirdHistory, 2);
        addClickToPanel(fouthHistory, 3);
    }

    private void addClickToPanel(JPanel panel, int index) {
        if (panel == null) return;
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectedIndex = index;
                highlightSelected();
            }
        });
    }

    private void highlightSelected() {
        Color selectedColor = new Color(220, 220, 220); // Light Gray
        Color defaultColor = new Color(245, 245, 245);  // Or whatever your default is (or null)

        // Reset backgrounds
        if(firstHIstory != null) firstHIstory.setBackground(defaultColor);
        if(secondHistory != null) secondHistory.setBackground(defaultColor);
        if(thirdHistory != null) thirdHistory.setBackground(defaultColor);
        if(fouthHistory != null) fouthHistory.setBackground(defaultColor);

        // Highlight specific panel
        if (selectedIndex == 0 && firstHIstory != null) firstHIstory.setBackground(selectedColor);
        if (selectedIndex == 1 && secondHistory != null) secondHistory.setBackground(selectedColor);
        if (selectedIndex == 2 && thirdHistory != null) thirdHistory.setBackground(selectedColor);
        if (selectedIndex == 3 && fouthHistory != null) fouthHistory.setBackground(selectedColor);
    }

    public void setCLEARButton() {
        CLEARButton.addActionListener(e -> writeJournal.setText(""));
    }

    public void setRemoveSelectedButton() {
        removeSelectedButton.addActionListener(e -> {
            if (selectedIndex != -1) {
                List<JournalEntry> entries = JournalFileManager.loadEntries();
                if (selectedIndex < entries.size()) {
                    int confirm = JOptionPane.showConfirmDialog(this, "Delete this entry?", "Confirm", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        JournalFileManager.deleteEntry(selectedIndex);
                        selectedIndex = -1;
                        loadHistoryIntoPanels();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Select a panel to delete.");
            }
        });
    }


    public JPanel getMainPanel() {
        return mainPanel;
    }
}