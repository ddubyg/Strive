package Exercises;

public class CardioExercise extends Exercise {

    public CardioExercise(String name, double distance, CardioType cardioType) {
        super(name, distance, cardioType);
    }

    @Override
    public String getDescription() {
        return getName() + " for " + getDistance();
    }
}
