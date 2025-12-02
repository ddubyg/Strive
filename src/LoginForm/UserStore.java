package LoginForm;
import java.util.*;
import java.io.*;

public class UserStore {
    public static String username;
    public static String password;
    public static String displayName;
    public static String age;
    public static String height;
    public static String weight;

    // NOT SURE, NEEDS RECHECKING
    public UserStore(){

        //useless???
        if(age == null || age.equals("0")){
            throw new IllegalArgumentException("Age cannot be negative.");
        }
        if(weight == null || weight.equals("0")){
            throw new IllegalArgumentException("Weight must be positive.");
        }
        if(height == null || height.equals("0")){
            throw new IllegalArgumentException("Height must be positive.");
        }
    }

    public static void createProfile() {
        // 1. VALIDATION
        // Ensure that both username and password are provided
        if (username == null || username.isEmpty() ||
                password == null || password.isEmpty()) {
            System.err.println("Error: Username or password is empty.");
            return;
        }

        // Validate numeric fields (logic moved from constructor)
        if (age == null || age.equals("0")) {
            System.err.println("Error: Age cannot be negative or zero.");
            return; // Stop execution
        }
        if (weight == null || weight.equals("0")) {
            System.err.println("Error: Weight must be positive.");
            return;
        }
        if (height == null || height.equals("0")) {
            System.err.println("Error: Height must be positive.");
            return;
        }

        // 2. FOLDER CREATION
        // ROOT of project (where the app runs)
        String rootPath = System.getProperty("user.dir");

        // Main 'userData' folder at project root
        File dbFolder = new File(rootPath, "userData");
        if (!dbFolder.exists()) {
            dbFolder.mkdirs();
        }

        // Unique folder for the specific user inside userData
        File userFolder = new File(dbFolder, username);
        if (!userFolder.exists()) {
            userFolder.mkdirs();
        }

        // 3. FILE CREATION (CSV)
        // File inside the user folder
        File userFile = new File(userFolder, "user_data.csv");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(userFile))) {
            // Write CSV Header
            writer.write("Username,Password,DisplayName,Age,Height,Weight");
            writer.newLine();

            // Write CSV Data Row
            // String.format helps ensure commas are placed correctly
            String csvData = String.format("%s,%s,%s,%s,%s,%s",
                    username,
                    password,
                    (displayName != null ? displayName : ""),
                    age,
                    height,
                    weight
            );

            writer.write(csvData);

            System.out.println("User profile saved successfully at: " + userFile.getAbsolutePath());

        } catch (IOException e) {
            System.err.println("Error writing database file: " + e.getMessage());
        }
    }

    //authenthicator yipeee
    public static boolean authenticate(String inputUser, String inputPass) {
        // 1. Construct the path to the specific user's file
        String rootPath = System.getProperty("user.dir");
        File userFile = new File(rootPath, "userData/" + inputUser + "/user_data.csv");
        //tracks location through username Inputted by the user

        // 2. Check if the user exists
        if (!userFile.exists()) {
            return false; // User folder/file not found
        }

        // 3. Read the file
        try (BufferedReader reader = new BufferedReader(new FileReader(userFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Skip the header row
                if (line.startsWith("Username")) continue;

                // 4. Parse the CSV data (Username,Password,DisplayName,Age...)
                String[] data = line.split(",");

                // Ensure the line has enough data to avoid errors
                if (data.length >= 2) {
                    String storedUser = data[0];
                    String storedPass = data[1];

                    // 5. Check if password matches
                    if (storedUser.equals(inputUser) && storedPass.equals(inputPass)) {
                        // LOGIN SUCCESS: Load data into memory for the session
                        UserStore.username = storedUser;
                        UserStore.password = storedPass;
                        // Check if other fields exist before assigning (avoid index out of bounds)
                        UserStore.displayName = (data.length > 2) ? data[2] : "";
                        UserStore.age = (data.length > 3) ? data[3] : "";
                        UserStore.height = (data.length > 4) ? data[4] : "";
                        UserStore.weight = (data.length > 5) ? data[5] : "";

                        return true;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading user file: " + e.getMessage());
        }

        return false; // Password incorrect or file reading failed
    }

}

