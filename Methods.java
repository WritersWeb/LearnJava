public class Methods {
    
    public static void main(String[] args){

        // method =  a block of reusable code that is executed when called ()

        happyBirthday("Spongebob", 30);
        System.out.println("square of 5 is: " + square(5));
        System.out.println("cube of 3 is: " + cube(3));
        System.out.println("Full name: " + getFullName("John", "Doe"));
        
    }
    static void happyBirthday(String name, int age){
        System.out.println("Happy Birthday to you!");
        System.out.printf("Happy Birthday dear %s!\n", name);
        System.out.printf("You are %d years old!\n", age);
        System.out.println("Happy Birthday to you!\n");
    }
    static double square(double number){
        return number * number;
    }
    static double cube(double number){
        return number * number * number;
    }
    static String getFullName(String first, String last){
        return first + " " + last;
    }
}


