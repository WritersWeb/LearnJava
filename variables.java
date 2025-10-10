import java.util.Scanner;

public class variables{
   public static void main(String[] args) {
        int myNum;
        myNum = 5;               
        float myFloatNum = 5.99f;   
        char myLetter = 'D';        
        boolean myBool = true;     
        String myText = "Hello";   
        
        
        System.out.println(myNum);
        System.out.println(myFloatNum);
        System.out.println(myLetter);
        System.out.println(myBool);
        System.out.println(myText);

        String name = "John ";
        System.out.println("Hello " + name);

        int age; 
        age = 25;
        System.out.println(age);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name : ");
        String myName = scanner.nextLine();

        double weight = 65.5; 
        System.out.println("My name is : " + name);

        System.out.println(name + "is " + weight + " kg.");

        System.out.println("Your are "+ myName );
        scanner.close();
    }
}