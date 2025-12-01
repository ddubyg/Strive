package JournalPanel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JournalFileManager {
    private static final String FILE_PATH = "journal.txt";

    public static void saveEntry(JournalEntry entry) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(entry.toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    public static List<String> loadEntries() {
        List<String> entries = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
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

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
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
