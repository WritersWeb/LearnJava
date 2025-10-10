import java.util.Scanner;

public class grading {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in); 

        System.out.print("Enter your accumulative marks: ");
        double marks = scanner.nextDouble();
        scanner.close();

        if (marks >= 70) {
            System.out.println("You have been awarded a First Class Honours");
        } else if (marks >= 60) {
            System.out.println("You have been awarded a Second Upper Honours");          
        } else if (marks >= 50) {
            System.out.println("You have been awarded a Second Lower Honours");          
        } else if (marks >= 40) {
            System.out.println("You have been awarded a Pass");          
        }else {
    System.out.println("You have failed!");
        }
    }
}
