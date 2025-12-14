package Routine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WorkoutCard extends JPanel {

    // Colors
    private static final Color STRIVE_ORANGE = new Color(255, 87, 34);
    private static final Color CARD_BG = new Color(20, 25, 40);
    private static final Color TEXT_WHITE = new Color(240, 240, 240);
    private static final Color TEXT_GRAY = new Color(150, 150, 150);

    // REMOVED duration from constructor arguments
    public WorkoutCard(String index, String exerciseName, String sets, String reps, String type) {
        // 1. Panel Settings
        setOpaque(false);
        setLayout(new BorderLayout(15, 0));
        setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 85));
        setPreferredSize(new Dimension(300, 85));
        setAlignmentX(Component.LEFT_ALIGNMENT);

        // 2. The Number Box (Left)
        JPanel numberPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(35, 40, 55));
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
            }
        };
        numberPanel.setOpaque(false);
        numberPanel.setPreferredSize(new Dimension(40, 40));
        numberPanel.setLayout(new GridBagLayout());

        JLabel lblIndex = new JLabel(index);
        lblIndex.setForeground(TEXT_GRAY);
        lblIndex.setFont(new Font("SansSerif", Font.BOLD, 14));
        numberPanel.add(lblIndex);

        // 3. The Text Info (Center)
        JPanel textPanel = new JPanel(new GridLayout(2, 1));
        textPanel.setOpaque(false);

        // Title: Exercise Name + (Type)
        JLabel lblName = new JLabel(exerciseName + " (" + type + ")");
        lblName.setForeground(TEXT_WHITE);
        lblName.setFont(new Font("SansSerif", Font.BOLD, 15));

        // Details: Sets x Reps (Removed Duration)
        String detailText = sets + " sets x " + reps + " reps";
        JLabel lblDetails = new JLabel(detailText);
        lblDetails.setForeground(STRIVE_ORANGE);
        lblDetails.setFont(new Font("SansSerif", Font.PLAIN, 12));

        textPanel.add(lblName);
        textPanel.add(lblDetails);

        // 4. Action Icons (Right)
        JPanel iconPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        iconPanel.setOpaque(false);

        JLabel deleteBtn = new JLabel("✕");
        deleteBtn.setForeground(Color.RED);
        deleteBtn.setFont(new Font("SansSerif", Font.BOLD, 16));
        deleteBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        deleteBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Container parent = getParent();
                if(parent != null) {
                    parent.remove(WorkoutCard.this);
                    parent.revalidate();
                    parent.repaint();
                }
            }
        });

        iconPanel.add(deleteBtn);

        add(numberPanel, BorderLayout.WEST);
        add(textPanel, BorderLayout.CENTER);
        add(iconPanel, BorderLayout.EAST);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(CARD_BG);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
    }
}