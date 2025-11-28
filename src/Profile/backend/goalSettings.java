package Profile.backend;
import java.util.*;

public class goalSettings {
    private String monthLyGoal;
    private double targetWeight;
    private Map<String, Integer> strengthTarget;

    // Hashmap is still experimental and is very much a massive subject for review and change
    public goalSettings(){
        this.monthLyGoal = "";
        this.targetWeight = 0;
        this.strengthTarget = new HashMap<>(); // <<<< Hashmap
    }

    public void setGoal(String monthLyGoal, double targetWeight){
        this.monthLyGoal = monthLyGoal;
        this.targetWeight = targetWeight;
    }

    public String viewGoals(){
        return "Monthly goal: " + monthLyGoal + " // Target weight: " + targetWeight + " // Strength targets: "+  strengthTarget.toString();
    }

    //Hashmap in action
    public void updateTargets(String exercise, int targetValue){
        strengthTarget.put(exercise, targetValue);
    }


    // for data retrieval purposes for gui display
    public String getMonthLyGoal() {
        return monthLyGoal;
    }

    public double getTargetWeight() {
        return targetWeight;
    }

    public Map<String, Integer> getStrengthTarget() {
        return strengthTarget;
    }
}
