package Profile.backend;

import LoginForm.UserStore;

public class userProfile {
    private String name;
    private int age;
    // Commented this out due to the creation of userStore.java
//    private double weight, height;
    private goalSettings goals;
    private Journal history;

    //for debugging and testing purposes; and for the first object creation.
    public userProfile(String name, int age, double weight, double height) {
        // added some throw news for lesson compliance purposes
        //COMMENTED OUT, REPLACEMENT FOUND IN USERSTORE
//        if(age < 0){
//            throw new IllegalArgumentException("Age cannot be negative.");
//        }
//        if(weight <= 0){
//            throw new IllegalArgumentException("Weight must be positive.");
//        }
//        if(height <= 0){
//            throw new IllegalArgumentException("Height must be positive.");
//        }

        // Commented this out due to the creation of userStore.java
//        this.name = name;
//        this.age = age;
//        this.weight = weight;
//        this.height = height;


        this.goals = new goalSettings();
        this.history = new Journal();
    }

    //for updating already created object
    public void updateProfile(String newName, int newAge, double newWeight, double newHeight){
        // still needs improvements

        if(newAge < 0) return;
        if(newWeight <= 0) return;
        if(newHeight <= 0) return;

    }



    public void setGoals(){

    }


    // Basic BMI calculator for the profile
    public static String getBMI(){
        double parsedWeight = Double.parseDouble(UserStore.weight);
        double parsedHeight = Double.parseDouble(UserStore.height);
        double preFormattedBMI = (parsedWeight / (parsedHeight * parsedHeight));

        return String.format("%.2f", preFormattedBMI);
    }



}
