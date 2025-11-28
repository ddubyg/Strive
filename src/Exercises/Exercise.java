package Exercises;

public abstract class Exercise {
    private final String name;
    private BodyPart bodyPart;
    private MuscleGroup muscleGroup;
    private double distance;
    private CardioType cardioExercise;

    public Exercise(String name, BodyPart bodyPart, MuscleGroup muscleGroup) {
        this.name = name;
        this.bodyPart = bodyPart;
        this.muscleGroup = muscleGroup;
    }

    public Exercise(String name, double distance, CardioType cardioExercise) {
        this.name = name;
        this.distance = distance;
        this.cardioExercise = cardioExercise;
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

    public double getDistance() {
        return distance;
    }

    public abstract String getDescription();
}
