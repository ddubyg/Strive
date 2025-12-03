package JournalPanel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import LoginForm.UserStore;

public class JournalFileManager {
//    private static final String FILE_PATH = "journal.txt";

    private static String getUserJournalPath() {
        String rootPath = System.getProperty("user.dir");
        String userFolder = rootPath + "/userData/" + UserStore.username;

        // Ensure user folder exists (should already from createProfile)
        File folder = new File(userFolder);
        if (!folder.exists()) folder.mkdirs();

        return userFolder + "/journal.txt";
    }

    public static void saveEntry(JournalEntry entry) {
        String filePath = getUserJournalPath();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(entry.toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    public static List<String> loadEntries() {
        List<String> entries = new ArrayList<>();
        String filePath = getUserJournalPath();

        File file = new File(filePath);
        if (!file.exists()) return entries; // No journal yet

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                entries.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return entries;
    }

    public static void deleteEntry(int indexToDelete) {
        List<String> entries = loadEntries();
        String filePath = getUserJournalPath();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (int i = 0; i < entries.size(); i++) {
                if (i != indexToDelete) {
                    writer.write(entries.get(i));
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error rewriting file: " + e.getMessage());
        }
    }
}
