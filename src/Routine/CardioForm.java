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
        putCardioPanel.setLayout(new BoxLayout(putCardioPanel, BoxLayout.Y_AXIS));

        // Start Workout Logic
        startWorkoutButton.addActionListener(e -> {
            if (totalSeconds <= 0) {
                JOptionPane.showMessageDialog(mainPanel, "Total time is 0! Please add time.");
            } else {
                startCountdown(totalSeconds);
            }
        });
    }

    public static boolean getAdded() {
        return added;
    }

    public static void setAdded() {
        added = true;
    }

    // --- UPDATED ADD METHOD ---
    // Change void to boolean
    public boolean addCardio(String type, String distance, String speed) {
        try {
            double d = Double.parseDouble(distance);
            double s = Double.parseDouble(speed);

            if (d < 0 || s < 0) {
                JOptionPane.showMessageDialog(mainPanel, "Distance and Speed cannot be negative.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            int index = (putCardioPanel.getComponentCount() / 2) + 1;

            CardioCard card = new CardioCard(String.valueOf(index), type, distance, speed);

            putCardioPanel.add(card);
            putCardioPanel.add(Box.createVerticalStrut(10));
            putCardioPanel.revalidate();
            putCardioPanel.repaint();

            return true;

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(mainPanel, "Distance and Speed must be valid numbers!", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public void setTotalCardioTime(long seconds) {
        this.totalSeconds = seconds;
    }

    // --- Timer Helpers (Keep existing) ---
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