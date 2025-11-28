package Profile.backend;

public class userProfile {
    private String name;
    private int age;
    private double weight, height;
    private goalSettings goals;
    private Journal history;

    //for debugging and testing purposes; and for the first object creation.
    public userProfile(String name, int age, double weight, double height) {
        // added some throw news for lesson compliance purposes
        if(age < 0){
            throw new IllegalArgumentException("Age cannot be negative.");
        }
        if(weight <= 0){
            throw new IllegalArgumentException("Weight must be positive.");
        }
        if(height <= 0){
            throw new IllegalArgumentException("Height must be positive.");
        }

        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;


        this.goals = new goalSettings();
        this.history = new Journal();
    }

    //for updating already created object
    public void updateProfile(String newName, int newAge, double newWeight, double newHeight){
        // still needs improvements

        if(newAge < 0) return;
        if(newWeight <= 0) return;
        if(newHeight <= 0) return;

        this.name = newName;
        this.age = newAge;
        this.weight = newWeight;
        this.height = newHeight;

    }

    //subject for review and change;
    // changed void to String, but will be changed if front end is in
    public String viewProfile(){
        return "name: " + name + " // age: " + age + "// weight: " + weight + " // height: " + height;
    }

    public void setGoals(){

    }

    //getters for the swing display
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }
}
