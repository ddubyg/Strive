package HomePage;

import LoginForm.UserStore;
import javax.swing.*;


public class HomePage extends JFrame {
   /* private Journal journal1;*/

    public JPanel mainPanel;
    private UserStore login;
    private JPanel welcomePanel;
    private JCheckBox mondayCheckBox;
    private JCheckBox tuesdayCheckBox;
    private JCheckBox wednesdayCheckBox;
    private JCheckBox thursdayCheckBox;
    private JCheckBox fridayCheckBox;
    private JCheckBox saturdayCheckBox;
    private JCheckBox sundayCheckBox;
    private JButton CALCULATECALORIESButton;
    public JButton STARTButton;
    public JButton home;
    public JButton workout;
    public JButton journal;
    public JButton profile;
    public JButton routineButton;
    private JLabel welcome;
    private JLabel streakLabel;
    private JLabel displayCaloriesJlabel;
    private JPanel calculatePanel;
    private JTextField ageTxtField;
    private JRadioButton MALERadioButton;
    private JRadioButton FEMALERadioButton;
    private JTextField heightTxtfield;
    private JTextField textField1;
    private JButton CALCULATEButton;
    private JComboBox activityTypeComboBox;
    private int weeklyStreak = 0;
    private boolean hasCountedThisWeek = false;
    private int lastWeekNumber = -1;
    private ButtonGroup genderGroup;

    public HomePage(){

        UserStore.ensureDisplayName();
        setupCalorieCalculator();
        setMaleFemale();

    }
    //setting welcome
    public void setWelcome() {
        String name;
        if (UserStore.displayName == null || UserStore.displayName.isEmpty()) {
            name = UserStore.username;
        } else {
            name = UserStore.displayName;
        }
        welcome.setText("Time to level up, " + name + "!");
    }

    public void refreshUserData() {
        UserStore.ensureDisplayName();
        setWelcome();
    }

    public void setMaleFemale(){
        genderGroup = new ButtonGroup();
        genderGroup.add(MALERadioButton);
        genderGroup.add(FEMALERadioButton);

        // Optional: Add action listeners if you want to respond to changes
        MALERadioButton.addActionListener(e -> {
            // Male selected - you can add logic here if needed
            FEMALERadioButton.setSelected(false);
        });

        FEMALERadioButton.addActionListener(e -> {
            // Female selected - you can add logic here if needed
            MALERadioButton.setSelected(false);
        });






    }
    private double getActivityMultiplier(int index) {
        return switch (index) {
            case 0 -> 1.2;   // Sedentary
            case 1 -> 1.375; // Light
            case 2 -> 1.55;  // Moderate
            case 3 -> 1.725; // Intense
            case 4 -> 1.9;   // Athlete
            default -> throw new IllegalArgumentException("Invalid activity level");
        };
    }

//    Code	Activity Level
//1	Sedentary	Little to no exercise
//2	Light exercise 1–3 days/week
//3	Moderate (Medium)	Exercise 3–5 days/week
//4	Intense (Heavy)	Hard exercise 6–7 days/week
//5	Very Intense / Athlete	Training twice per day
    // for ui ni siya

    private void setupCalorieCalculator() {

        CALCULATEButton.addActionListener(e -> {
            int selectedIndex = activityTypeComboBox.getSelectedIndex();
            if (selectedIndex == -1) {
                throw new IllegalArgumentException("Please select an activity level.");
            }

            try {
                int age = Integer.parseInt(UserStore.age);
                double height = Double.parseDouble(UserStore.height);
                double weight = Double.parseDouble(UserStore.weight); // assuming this is weight
                double activityLevel = getActivityMultiplier(selectedIndex);

                // VALIDATION
                if (age <= 0 || height <= 0 || weight <= 0 || activityLevel <= 0) {
                    throw new IllegalArgumentException("All values must be positive.");
                }

                // CHECK SEX
                if (!MALERadioButton.isSelected() && !FEMALERadioButton.isSelected()) {
                    throw new IllegalArgumentException("Please select Male or Female.");
                }

                double BMR;

                if (MALERadioButton.isSelected()) {
                    // Male BMR
                    BMR = 66.47 + (13.75 * weight) + (5.003 * height) - (6.755 * age);
                } else {
                    // Female BMR
                    BMR = 655.1 + (9.563 * weight) + (1.850 * height) - (4.676 * age);
                }

                // TOTAL CALORIES
                double totalCalories = BMR * activityLevel;

                // DISPLAY RESULT
                displayCaloriesJlabel.setText(String.format("%.0f", totalCalories));

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numbers.");
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }




}
