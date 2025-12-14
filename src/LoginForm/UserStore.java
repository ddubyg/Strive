package LoginForm;
import java.util.*;
import java.io.*;

public class UserStore {
    // 1. ADD NEW VARIABLES
    public static String username;
    public static String password;
    public static String displayName;
    public static String age;
    public static String height;
    public static String weight;
    public static String goalWeight;  // NEW
    public static String startWeight; // NEW

    public UserStore() {
        // Validation logic...
    }

    public static void ensureDisplayName() {
        if (displayName == null || displayName.isEmpty()) {
            displayName = username;
        }
    }

    // 2. NEW METHOD: SAVE UPDATES TO CSV
    // Call this whenever you change profile details (Age, Weight, Goal)
    public static void updateUserFile() {
        if (username == null) return;

        String rootPath = System.getProperty("user.dir");
        File userFile = new File(rootPath, "userData/" + username + "/user_data.csv");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(userFile))) {
            // Updated Header
            writer.write("Username,Password,DisplayName,Age,Height,Weight,GoalWeight,StartWeight");
            writer.newLine();

            // Handle nulls to avoid "null" text in CSV
            String safeGoal = (goalWeight == null) ? "0" : goalWeight;
            String safeStart = (startWeight == null) ? weight : startWeight; // Default start to current weight

            String csvData = String.format("%s,%s,%s,%s,%s,%s,%s,%s",
                    username, password, displayName, age, height, weight, safeGoal, safeStart
            );

            writer.write(csvData);
            System.out.println("User data updated.");

        } catch (IOException e) {
            System.err.println("Error updating file: " + e.getMessage());
        }
    }

    public static void createProfile() {
        // ... (Keep your existing validation logic here) ...

        // Folder creation logic (Keep existing)
        String rootPath = System.getProperty("user.dir");
        File dbFolder = new File(rootPath, "userData");
        if (!dbFolder.exists()) dbFolder.mkdirs();
        File userFolder = new File(dbFolder, username);
        if (!userFolder.exists()) userFolder.mkdirs();

        File userFile = new File(userFolder, "user_data.csv");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(userFile))) {
            // Write NEW Header
            writer.write("Username,Password,DisplayName,Age,Height,Weight,GoalWeight,StartWeight");
            writer.newLine();

            // Set defaults for new users
            goalWeight = "0";
            startWeight = weight; // Start weight is the weight they signed up with

            String csvData = String.format("%s,%s,%s,%s,%s,%s,%s,%s",
                    username, password,
                    (displayName != null ? displayName : ""),
                    age, height, weight, goalWeight, startWeight
            );

            writer.write(csvData);
            System.out.println("Profile created: " + userFile.getAbsolutePath());

        } catch (IOException e) {
            System.err.println("Error writing database file: " + e.getMessage());
        }
    }

    public static boolean authenticate(String inputUser, String inputPass) {
        String rootPath = System.getProperty("user.dir");
        File userFile = new File(rootPath, "userData/" + inputUser + "/user_data.csv");

        if (!userFile.exists()) return false;

        try (BufferedReader reader = new BufferedReader(new FileReader(userFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Username")) continue;

                String[] data = line.split(",");

                if (data.length >= 2) { // Basic check
                    if (data[0].equals(inputUser) && data[1].equals(inputPass)) {
                        UserStore.username = data[0];
                        UserStore.password = data[1];
                        UserStore.displayName = (data.length > 2) ? data[2] : "";
                        UserStore.age = (data.length > 3) ? data[3] : "";
                        UserStore.height = (data.length > 4) ? data[4] : "";
                        UserStore.weight = (data.length > 5) ? data[5] : "";

                        // LOAD NEW DATA (Check length to prevent crash on old files)
                        UserStore.goalWeight = (data.length > 6) ? data[6] : "0";
                        UserStore.startWeight = (data.length > 7) ? data[7] : UserStore.weight;

                        return true;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return false;
    }
}