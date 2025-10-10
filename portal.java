import java.util.Scanner;

public class portal {
    public static void main(String[] args) {
        

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name :");
        String MyName = scanner.nextLine();

        System.out.print("Enter your Reg No. :"); 
        String regNo = scanner.nextLine();


        System.out.print("Enter your course :");
        String Course = scanner.nextLine();

        
        System.out.print("What is your currnet year of study? ");
        int year = scanner.nextInt();

        System.out.println("Your Name is : "+ MyName  );
        System.out.println("Your Registration is : "+ regNo  );
        System.out.println("You are currently in year " + year + " doing " + Course );

        scanner.close();
    }
   }
