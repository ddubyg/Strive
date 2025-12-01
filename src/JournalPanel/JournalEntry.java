package JournalPanel;

public class JournalEntry {
    private String mood;
    private String text;
    private String timestamp;

    public JournalEntry(String mood, String text, String timestamp){
        this.mood = mood;
        this.text = text;
        this.timestamp = timestamp;

    }
    public String toString() {
        return timestamp + " | " + mood + " | " + text;
    }
}

