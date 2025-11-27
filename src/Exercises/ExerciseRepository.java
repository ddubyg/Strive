package Exercises;

import java.util.ArrayList;
import java.util.List;

public class ExerciseRepository {
    //this holds all possible exercises
    private List<Exercise> exerciseList;

    public ExerciseRepository() {
        exerciseList = new ArrayList<>();
        initializeExercises();
    }

    private void initializeExercises() {
        //UPPER BODY

        //Chest
        exerciseList.add(new StrengthExercise("Flat Bench Press", BodyPart.UPPER_BODY, MuscleGroup.CHEST));
        exerciseList.add(new StrengthExercise("Incline Dumbbell Press", BodyPart.UPPER_BODY, MuscleGroup.CHEST));
        exerciseList.add(new StrengthExercise("Machine Flies", BodyPart.UPPER_BODY, MuscleGroup.CHEST));

        //Shoulder
        exerciseList.add(new StrengthExercise("Dumbbell Shoulder Press", BodyPart.UPPER_BODY, MuscleGroup.SHOULDERS));
        exerciseList.add(new StrengthExercise("Cable Lateral Raises", BodyPart.UPPER_BODY, MuscleGroup.SHOULDERS));
        exerciseList.add(new StrengthExercise("Face Pulls", BodyPart.UPPER_BODY, MuscleGroup.SHOULDERS));

        //Triceps
        exerciseList.add(new StrengthExercise("Bar Cable Pushdowns", BodyPart.UPPER_BODY, MuscleGroup.TRICEPS));
        exerciseList.add(new StrengthExercise("Single Arm Cable Extensions", BodyPart.UPPER_BODY, MuscleGroup.TRICEPS));

        //Back
        exerciseList.add(new StrengthExercise("Pulldowns", BodyPart.UPPER_BODY, MuscleGroup.BACK));
        exerciseList.add(new StrengthExercise("Cable Rows", BodyPart.UPPER_BODY, MuscleGroup.BACK));
        exerciseList.add(new StrengthExercise("Dumbbell Shrugs", BodyPart.UPPER_BODY, MuscleGroup.BACK));

        //Biceps
        exerciseList.add(new StrengthExercise("Dumbbell Curls", BodyPart.UPPER_BODY, MuscleGroup.BICEPS));

        //Forearm
        exerciseList.add(new StrengthExercise("Sulek Cable Curls", BodyPart.UPPER_BODY, MuscleGroup.FOREARMS));

        //LOWER BODY

        //Legs
        exerciseList.add(new StrengthExercise("Squats", BodyPart.LOWER_BODY, MuscleGroup.LEGS));
        exerciseList.add(new StrengthExercise("RDLs", BodyPart.LOWER_BODY, MuscleGroup.LEGS));
        exerciseList.add(new StrengthExercise("Leg Press", BodyPart.LOWER_BODY, MuscleGroup.LEGS));
        exerciseList.add(new StrengthExercise("Leg Extensions", BodyPart.LOWER_BODY, MuscleGroup.LEGS));
        exerciseList.add(new StrengthExercise("Leg Curls", BodyPart.LOWER_BODY, MuscleGroup.LEGS));
        exerciseList.add(new StrengthExercise("Calf Raises", BodyPart.LOWER_BODY, MuscleGroup.LEGS));

        //CORE

        //Abs
        exerciseList.add(new StrengthExercise("Cable Crunches", BodyPart.CORE, MuscleGroup.ABS));
        exerciseList.add(new StrengthExercise("Squats", BodyPart.CORE, MuscleGroup.ABS));
    }

    //Filter by category
    public List<Exercise> getExercisesByBodyPart(BodyPart part) {
        List<Exercise> result = new ArrayList<>();
        for(Exercise ex : exerciseList) {
            if(ex.getBodyPart() == part) {
                result.add(ex);
            }
        }

        return result;
    }

    //Filter by muscle
    public List<Exercise> getExercisByMuscleGroup(MuscleGroup group) {
        List<Exercise> result = new ArrayList<>();
        for(Exercise ex : exerciseList) {
            if(ex.getMuscleGroup() == group) {
                result.add(ex);
            }
        }

        return result;
    }

    //TO DO: make a method that shows the exercises in the UI
}
