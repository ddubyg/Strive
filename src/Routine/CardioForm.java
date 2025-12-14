package Routine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardioForm extends JFrame{
    public JPanel mainPanel;
    private JPanel headerPanel;
    private JPanel lowerPanel;
    public JPanel CardioPanel;
    private JPanel putCardioPanel;
    private JButton startWorkoutButton;
    public JButton GOTOSTRENGTHButton;
    public JButton homebtn;
    public JButton workoutbtn;
    public JButton journalBtn;
    public JButton profileBtn;
    public JButton RoutineButton;
    private static boolean added = true;
    private long totalSeconds = 0;

    public CardioForm() {
        // Layout Setup
        putCardioPanel.setLayout(new BoxLayout(putCardioPanel, BoxLayout.Y_AXIS));

        // Start Workout Logic (Countdown)
        startWorkoutButton.addActionListener(e -> {
            if (totalSeconds <= 0) {
                JOptionPane.showMessageDialog(mainPanel, "Total time is 0!");
            } else {
                startCountdown(totalSeconds);
            }
        });
    }

    public static boolean getAdded() {
        return added;
    }

    public static void addedTrue() {
        added = true;
    }

    // --- Updated Method with Try-Catch Validation ---
    public void addCardio(String type, String field1, String field2, String duration) {

        // 1. Validate Inputs before adding
        try {
            // Check if field1 is a number (e.g., Distance/Sets)
            // We use Double to allow decimals (e.g., 5.5)
            if (!field1.isEmpty()) {
                Double.parseDouble(field1);
            }

            // Check if field2 is a number (e.g., Speed/Reps)
            if (!field2.isEmpty()) {
                Double.parseDouble(field2);
            }

            // Check if duration creates valid seconds
            long checkTime = parseDurationToSeconds(duration);
            if (checkTime == 0) {
                // If time is 0, we consider it invalid or bad format
                throw new IllegalArgumentException("Invalid Duration format");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(mainPanel,
                    "Please enter valid numbers for your stats (no letters like 'km' or 'mph').",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
                    added = false;
            return; // Stop here, do not add the card
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(mainPanel,
                    "Invalid Duration! Use format '1 hr 30 min' or '45 min'.",
                    "Time Error",
                    JOptionPane.ERROR_MESSAGE);
                    added = false;
            return; // Stop here
        }

        // 2. Proceed if validation passed
        int index = (putCardioPanel.getComponentCount() / 2) + 1;

        // Combine text fields for details
        String details = field1;
        if(!field2.isEmpty()) {
            details += "km, " + field2;
        }

        CardioCard card = new CardioCard(String.valueOf(index), type, details, duration);

        putCardioPanel.add(card);
        putCardioPanel.add(Box.createVerticalStrut(10)); // Gap

        putCardioPanel.revalidate();
        putCardioPanel.repaint();

        // Update Timer
        totalSeconds += parseDurationToSeconds(duration);
        addedTrue();
    }

    // --- Timer Helpers ---
    private long parseDurationToSeconds(String durationText) {
        long seconds = 0;
        try {
            // Normalize text to handle case sensitivity
            String text = durationText.toLowerCase();

            if (text.contains("hr")) {
                String[] parts = text.split("hr");
                int hours = Integer.parseInt(parts[0].trim());
                seconds += (hours * 3600);

                if (parts.length > 1 && parts[1].contains("min")) {
                    String minPart = parts[1].replace("min", "").trim();
                    seconds += (Integer.parseInt(minPart) * 60);
                }
            } else if (text.contains("min")) {
                String minPart = text.replace("min", "").trim();
                seconds += (Integer.parseInt(minPart) * 60);
            }
        } catch (Exception e) {
            return 0; // Return 0 if parsing fails
        }
        return seconds;
    }

    private void startCountdown(long startSeconds) {
        JDialog timerDialog = new JDialog(this, "Cardio Session", true);
        timerDialog.setSize(300, 200);
        timerDialog.setLocationRelativeTo(this);
        timerDialog.setLayout(new BoxLayout(timerDialog.getContentPane(), BoxLayout.Y_AXIS));

        JLabel timeLabel = new JLabel(formatTime(startSeconds));
        timeLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
        timeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton stopBtn = new JButton("Finish Cardio");
        stopBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        timerDialog.add(Box.createVerticalGlue());
        timerDialog.add(timeLabel);
        timerDialog.add(Box.createVerticalStrut(20));
        timerDialog.add(stopBtn);
        timerDialog.add(Box.createVerticalGlue());

        Timer timer = new Timer(1000, null);
        final long[] currentSeconds = {startSeconds};

        timer.addActionListener(e -> {
            currentSeconds[0]--;
            if (currentSeconds[0] >= 0) {
                timeLabel.setText(formatTime(currentSeconds[0]));
            } else {
                timer.stop();
                timeLabel.setText("DONE!");
                JOptionPane.showMessageDialog(timerDialog, "Good Job!");
                timerDialog.dispose();
            }
        });

        stopBtn.addActionListener(e -> {
            timer.stop();
            timerDialog.dispose();
        });

        timer.start();
        timerDialog.setVisible(true);
    }

    private String formatTime(long totalSecs) {
        long hours = totalSecs / 3600;
        long minutes = (totalSecs % 3600) / 60;
        long seconds = totalSecs % 60;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
    public JPanel getMainPanel() {
        return mainPanel;
    }

}