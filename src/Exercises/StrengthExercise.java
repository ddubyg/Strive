package Exercises;

public class StrengthExercise extends Exercise {

    public StrengthExercise(String name, BodyPart bodyPart, MuscleGroup muscleGroup) {
        super(name, bodyPart, muscleGroup);
    }

    @Override
    public String getDescription(){
        return getName() + " targets the " + getMuscleGroup();
    }
}
