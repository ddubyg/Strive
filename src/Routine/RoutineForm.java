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
        // ... (Existing Constructor) ...
        putRoutinePanel.setLayout(new BoxLayout(putRoutinePanel, BoxLayout.Y_AXIS));

        startWorkoutButton.addActionListener(e -> {
            if (totalSeconds <= 0) {
                JOptionPane.showMessageDialog(mainPanel, "Total time is 0! Please set a duration.");
            } else {
                startCountdown(totalSeconds);
            }
        });
    }

    // MODIFIED: No longer takes duration string
    public void addWorkout(String name, String sets, String reps, String type) {
        int indexCount = (putRoutinePanel.getComponentCount() / 2) + 1;
        // The card visual only needs name/sets/reps
        WorkoutCard card = new WorkoutCard(String.valueOf(indexCount), name, sets, reps, type);

        putRoutinePanel.add(card);
        putRoutinePanel.add(Box.createVerticalStrut(10));
        putRoutinePanel.revalidate();
        putRoutinePanel.repaint();
    }

    // 2. Set Total Time (Call this when user is done)
    public void setTotalRoutineTime(long seconds) {
        this.totalSeconds = seconds;
        // Optional: Update a label on the routine screen showing "Total Time: 1:30:00"
    }

    public long getTotalSeconds() {
        return totalSeconds;
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
