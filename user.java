import java.util.Scanner;

public class user {

    public static void main(String[] args) {
       Scanner scanner = new Scanner (System.in);

       System.out.print("Enter your Course: ");
       String course = scanner.nextLine();

        System.out.println("You are doing "+ course);
       scanner.close();

    }
    
}
