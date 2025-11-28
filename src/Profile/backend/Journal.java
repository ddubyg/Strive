package Profile.backend;
import java.util.*;

public class Journal {
    private List<String> entries;

    public Journal() {
        this.entries = new ArrayList<>();
    }

    public void addEntry(String entry){
        entries.add(entry);
    }

    public List<String> viewEntry(){
        return new ArrayList<>(entries);
    }

    public List<String> searchEntry(String word){
        List<String> findings = new ArrayList<>();
        for(String lookUp : entries){
            // if statement checks if the word inputted can be found within the journal entries
            //returns false if not found, otherwise returns true. Boolean
            if(lookUp.toLowerCase().contains(word.toLowerCase())){
                findings.add(lookUp);
            }
        }
        return  findings;
    }


}
