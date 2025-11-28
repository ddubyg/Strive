package Exercises;

import java.util.ArrayList;
import java.util.List;

public class ExerciseRepository {
    //this holds all possible exercises
    private List<Exercise> strengthList;
    private List<Exercise> cardioList;

    public ExerciseRepository() {
        strengthList = new ArrayList<>();
        cardioList = new ArrayList<>();
        initializeExercises();
    }

    private void initializeExercises() {
        //UPPER BODY

        //Chest
        strengthList.add(new StrengthExercise("Flat Bench Press", BodyPart.UPPER_BODY, MuscleGroup.CHEST));
        strengthList.add(new StrengthExercise("Incline Dumbbell Press", BodyPart.UPPER_BODY, MuscleGroup.CHEST));
        strengthList.add(new StrengthExercise("Machine Flies", BodyPart.UPPER_BODY, MuscleGroup.CHEST));

        //Shoulder
        strengthList.add(new StrengthExercise("Dumbbell Shoulder Press", BodyPart.UPPER_BODY, MuscleGroup.SHOULDERS));
        strengthList.add(new StrengthExercise("Cable Lateral Raises", BodyPart.UPPER_BODY, MuscleGroup.SHOULDERS));
        strengthList.add(new StrengthExercise("Face Pulls", BodyPart.UPPER_BODY, MuscleGroup.SHOULDERS));

        //Triceps
        strengthList.add(new StrengthExercise("Bar Cable Pushdowns", BodyPart.UPPER_BODY, MuscleGroup.TRICEPS));
        strengthList.add(new StrengthExercise("Single Arm Cable Extensions", BodyPart.UPPER_BODY, MuscleGroup.TRICEPS));

        //Back
        strengthList.add(new StrengthExercise("Pulldowns", BodyPart.UPPER_BODY, MuscleGroup.BACK));
        strengthList.add(new StrengthExercise("Cable Rows", BodyPart.UPPER_BODY, MuscleGroup.BACK));
        strengthList.add(new StrengthExercise("Dumbbell Shrugs", BodyPart.UPPER_BODY, MuscleGroup.BACK));

        //Biceps
        strengthList.add(new StrengthExercise("Dumbbell Curls", BodyPart.UPPER_BODY, MuscleGroup.BICEPS));

        //Forearm
        strengthList.add(new StrengthExercise("Sulek Cable Curls", BodyPart.UPPER_BODY, MuscleGroup.FOREARMS));

        //LOWER BODY

        //Legs
        strengthList.add(new StrengthExercise("Squats", BodyPart.LOWER_BODY, MuscleGroup.LEGS));
        strengthList.add(new StrengthExercise("RDLs", BodyPart.LOWER_BODY, MuscleGroup.LEGS));
        strengthList.add(new StrengthExercise("Leg Press", BodyPart.LOWER_BODY, MuscleGroup.LEGS));
        strengthList.add(new StrengthExercise("Leg Extensions", BodyPart.LOWER_BODY, MuscleGroup.LEGS));
        strengthList.add(new StrengthExercise("Leg Curls", BodyPart.LOWER_BODY, MuscleGroup.LEGS));
        strengthList.add(new StrengthExercise("Calf Raises", BodyPart.LOWER_BODY, MuscleGroup.LEGS));

        //CORE

        //Abs
        strengthList.add(new StrengthExercise("Cable Crunches", BodyPart.CORE, MuscleGroup.ABS));
        strengthList.add(new StrengthExercise("Squats", BodyPart.CORE, MuscleGroup.ABS));

        //CARDIO

        //WALK
        cardioList.add(new CardioExercise("Walk 1K", 1, CardioType.WALK));
        cardioList.add(new CardioExercise("Walk 2K", 2, CardioType.WALK));
        cardioList.add(new CardioExercise("Walk 5K", 5, CardioType.WALK));

        //RUN
        cardioList.add(new CardioExercise("Run 3K", 3, CardioType.RUN));
        cardioList.add(new CardioExercise("Run 5K", 5, CardioType.RUN));
        cardioList.add(new CardioExercise("Run 10K", 10, CardioType.RUN));
    }

    //Filter by category
    public List<Exercise> getExercisesByBodyPart(BodyPart part) {
        List<Exercise> result = new ArrayList<>();
        for(Exercise ex : strengthList) {
            if(ex.getBodyPart() == part) {
                result.add(ex);
            }
        }

        return result;
    }

    //Filter by muscle
    public List<Exercise> getExercisByMuscleGroup(MuscleGroup group) {
        List<Exercise> result = new ArrayList<>();
        for(Exercise ex : strengthList) {
            if(ex.getMuscleGroup() == group) {
                result.add(ex);
            }
        }

        return result;
    }

    //MUST-READ!!!
    //TO DO: make a method that shows the exercises in the UI
}
