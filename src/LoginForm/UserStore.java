package LoginForm;

public class UserStore {
    public static String username;
    public static String password;
    public static String displayName;
    public static String age;
    public static String height;
    public static String weight;

    // NOT SURE, NEEDS RECHECKING
    public UserStore(){
        if(age == null || age.equals("0")){
            throw new IllegalArgumentException("Age cannot be negative.");
        }
        if(weight == null || weight.equals("0")){
            throw new IllegalArgumentException("Weight must be positive.");
        }
        if(height == null || height.equals("0")){
            throw new IllegalArgumentException("Height must be positive.");
        }
    }

}

