package JournalPanel;

public class JournalEntry {
    private String mood;
    private String text;
    private String timestamp;

    public JournalEntry(String mood, String text, String timestamp) {
        this.mood = mood;
        this.text = text;
        this.timestamp = timestamp;
    }

    // --- 1. Format for SAVING to .txt file (Uses ;;; as separator) ---
    public String toFileString() {
        // Replace "Enter" key with {nl} so the file stays on one line
        String safeText = text.replace("\n", "{nl}");
        return mood + ";;;" + timestamp + ";;;" + safeText;
    }

    // --- 2. Format for READING from .txt file ---
    public static JournalEntry fromFileString(String line) {
        if (line == null || line.trim().isEmpty()) return null;

        String[] parts = line.split(";;;");
        if (parts.length < 3) return null; // Invalid line

        String mood = parts[0];
        String time = parts[1];
        // Restore the "Enter" key
        String text = parts[2].replace("{nl}", "\n");

        return new JournalEntry(mood, text, time);
    }

    // --- 3. Format for DISPLAYING on the Screen (HTML) ---
    public String toHtmlDisplay() {
        String htmlText = text.replace("\n", "<br>");
        String orangeColor = "rgb(255, 87, 34)";

        return "<html>" +
                "<div style='width: 280px;'>" +
                "<b style='color:" + orangeColor + "; font-size:10px;'>" + mood.toUpperCase() + "</b>" +
                "&nbsp;&nbsp;" +
                "<span style='color:gray; font-size:9px;'>" + timestamp + "</span>" +
                "</div>" +
                "<div style='margin-top: 4px; font-weight:normal;'>" + htmlText + "</div>" +
                "</html>";
    }

    @Override
    public String toString() {
        return toFileString();
    }
}