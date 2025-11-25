package forGit;

import java.util.InputMismatchException;
import java.util.*;

public class Streak {

    int weeklyStreak = 0;
    int targetDays = 0;
    int completedDays = 0;

    Scanner scan = new Scanner(System.in);

    public Streak(int targetDays){
        this.targetDays = targetDays;
        this.weeklyStreak = 0;
        this.completedDays = 0;
    }

// Checker (FOR DEBUGGING PURPOSES)
    public void setTargetDays(int days){
        try{
//            FOR DEBUGGING
//            System.out.println("Enter target days: ");
//            targetDays = scan.nextInt();
            targetDays = days;
            if(targetDays <= 0){
                throw new InputMismatchException("Input cannot be negative!");
            }

        }catch (InputMismatchException e){
            System.err.println("ERROR: " + e.getMessage());
        }
    }

    //On invoke records current day
    public void recordDayComplete(){
        if(targetDays > 0){
            completedDays++;
            System.out.println("Day completed! " + completedDays + "/" + targetDays + " for this week.");
            verifyWeeklyCompletion();
        }else{
            System.out.println("Target days not set yet! " +
                    "please set your target days."); // needs to be changed to proper app updater. (currently for checker purposes)
        }

    }

    //On invoke checks progress completion (Updates status bar for progress)
    public void verifyWeeklyCompletion(){
//        int completionProgress = (completedDays / targetDays) * 100;
        if (completedDays >= targetDays) {
            // Only increment streak if we haven't already finished the week
            // (You'd need extra logic to reset this weekly, usually using Dates)
            System.out.println("Weekly Goal Met! Streak +1");
            weeklyStreak++;
        }

        System.out.println("Your current progress is " + completedDays + "/ " + targetDays);
    }

    // On invoke, resets every user set streak.
    public void resetStreak(boolean metTargetLastWeek){
        if (!metTargetLastWeek) {
            weeklyStreak = 0; // Reset to 0 if user failed
        }
        completedDays = 0; // Reset day counter
    }

}

