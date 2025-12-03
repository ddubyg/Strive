package JournalPanel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import LoginForm.UserStore;

public class JournalFileManager {

    private static String getUserJournalPath() {
        String username = (UserStore.username != null) ? UserStore.username : "default_user";
        String rootPath = System.getProperty("user.dir");
        String userFolder = rootPath + "/userData/" + username;

        File folder = new File(userFolder);
        if (!folder.exists()) folder.mkdirs();

        return userFolder + "/journal.txt";
    }

    public static void saveEntry(JournalEntry entry) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(getUserJournalPath(), true))) {
            writer.write(entry.toFileString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    public static List<JournalEntry> loadEntries() {
        List<JournalEntry> entries = new ArrayList<>();
        File file = new File(getUserJournalPath());
        if (!file.exists()) return entries;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                JournalEntry entry = JournalEntry.fromFileString(line);
                if (entry != null) entries.add(0, entry); // Add to top
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return entries;
    }

    public static void deleteEntry(int indexToDelete) {
        List<JournalEntry> entries = loadEntries();
        if (indexToDelete >= 0 && indexToDelete < entries.size()) {
            entries.remove(indexToDelete);
        }
        // Rewrite file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(getUserJournalPath()))) {
            for (int i = entries.size() - 1; i >= 0; i--) {
                writer.write(entries.get(i).toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error rewriting file: " + e.getMessage());
        }
    }
}