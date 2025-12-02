package Routine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoutineForm extends JFrame{
    public JPanel mainPanel;
    private JPanel headerPanel;
    private JPanel routinePanel;
    private JPanel lowerPanel;
    public JButton homeBtn;
    public JButton workoutBtn;
    public JButton journalBtn;
    public JButton profileBtn;
    public JButton routineButton;
    private JButton startWorkoutButton;
    private JPanel putRoutinePanel;
    public JButton GOTOCARDIOButton;

    private long totalSeconds = 0;

    public RoutineForm() {
        // Layout Setup
        putRoutinePanel.setLayout(new BoxLayout(putRoutinePanel, BoxLayout.Y_AXIS));

        // --- START BUTTON LOGIC ---
        startWorkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (totalSeconds <= 0) {
                    JOptionPane.showMessageDialog(mainPanel, "No workouts added or total time is 0!");
                } else {
                    // Open the Countdown Timer Window
                    startCountdown(totalSeconds);
                }
            }
        });
    }

    public void addWorkout(String name, String sets, String reps, String type, String duration) {
        // 1. Existing Logic to add the card
        int indexCount = (putRoutinePanel.getComponentCount() / 2) + 1;
        WorkoutCard card = new WorkoutCard(String.valueOf(indexCount), name, sets, reps, type, duration);
        putRoutinePanel.add(card);
        putRoutinePanel.add(Box.createVerticalStrut(10));
        putRoutinePanel.revalidate();
        putRoutinePanel.repaint();

        // 2. NEW: Calculate time and add to total
        totalSeconds += parseDurationToSeconds(duration);
    }

    // --- HELPER: Convert "1 hr 30 min" to Seconds ---
    private long parseDurationToSeconds(String durationText) {
        long seconds = 0;

        // The text looks like "1 hr 30 min" or "45 min" or "2 hr"
        try {
            if (durationText.contains("hr")) {
                // Split by " hr" and take the first part
                String[] parts = durationText.split(" hr");
                int hours = Integer.parseInt(parts[0].trim());
                seconds += (hours * 3600); // 1 hour = 3600 seconds

                // If there is also minutes (e.g., "1 hr 30 min")
                if (parts.length > 1 && parts[1].contains("min")) {
                    String minPart = parts[1].replace("min", "").trim();
                    seconds += (Integer.parseInt(minPart) * 60);
                }
            } else if (durationText.contains("min")) {
                // Just minutes (e.g., "45 min")
                String minPart = durationText.replace("min", "").trim();
                seconds += (Integer.parseInt(minPart) * 60);
            }
        } catch (NumberFormatException e) {
            System.out.println("Error parsing time: " + durationText);
        }

        return seconds;
    }

    // --- HELPER: Open a Popup Window for the Timer ---
    private void startCountdown(long startSeconds) {
        // Create a minimal dialog window
        JDialog timerDialog = new JDialog(this, "Active Workout", true);
        timerDialog.setSize(300, 200);
        timerDialog.setLocationRelativeTo(this);
        timerDialog.setLayout(new BoxLayout(timerDialog.getContentPane(), BoxLayout.Y_AXIS));

        // Label to show time
        JLabel timeLabel = new JLabel(formatTime(startSeconds));
        timeLabel.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 30));
        timeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Stop Button
        JButton stopBtn = new JButton("Stop Workout");
        stopBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        timerDialog.add(Box.createVerticalGlue());
        timerDialog.add(timeLabel);
        timerDialog.add(Box.createVerticalStrut(20));
        timerDialog.add(stopBtn);
        timerDialog.add(Box.createVerticalGlue());

        // The Timer Logic
        Timer timer = new Timer(1000, null); // Tick every 1 second

        // We need a final wrapper object to modify inside the inner class
        final long[] currentSeconds = {startSeconds};

        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentSeconds[0]--; // Subtract 1 second

                if (currentSeconds[0] >= 0) {
                    timeLabel.setText(formatTime(currentSeconds[0]));
                } else {
                    timer.stop();
                    timeLabel.setText("FINISHED!");
                    JOptionPane.showMessageDialog(timerDialog, "Workout Complete!");
                    timerDialog.dispose();
                }
            }
        });

        stopBtn.addActionListener(e -> {
            timer.stop();
            timerDialog.dispose();
        });

        timer.start();
        timerDialog.setVisible(true);
    }

    // --- HELPER: Format Seconds back to HH:MM:SS ---
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
