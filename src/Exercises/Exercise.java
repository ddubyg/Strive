package Exercises;

public abstract class Exercise {
    private final String name;
    private final BodyPart bodyPart;
    private final MuscleGroup muscleGroup;

    public Exercise(String name, BodyPart bodyPart, MuscleGroup muscleGroup) {
        this.name = name;
        this.bodyPart = bodyPart;
        this.muscleGroup = muscleGroup;
    }

    public String getName() {
        return name;
    }

    public BodyPart getBodyPart() {
        return bodyPart;
    }

    public MuscleGroup getMuscleGroup() {
        return muscleGroup;
    }

    public abstract String getDescription();
}
