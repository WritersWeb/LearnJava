import java.util.Scanner;

public class miniBank {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        double balance = 200;
        int PIN = 1234;
        boolean login  = false;

        System.out.print("Enter your PIN (4 Character PIN) : ");
        int thePIN = scanner.nextInt();

        if(thePIN == PIN){
            login = true;
            
        }else{
            System.out.println("You enterd the wrong PIN");
        }
       while (login) {
        System.out.println("==== ATM   MENU ====");
        System.out.println("1. Check your Bank balance");
        System.out.println("2. Deposit into your account" );
        System.out.println("3. Withdraw some cash");
        System.out.println("4. Exitr");

        System.out.print("Enter you choice :");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.println("Your Bank balance is Ksh. :" + balance);

        }else if (choice == 2) {
             System.out.println("Enter the amount in Ksh. ");

            double deposit = scanner.nextDouble();
            if (deposit > 0) {
                balance += deposit;
                System.out.println("Your deposit of amount "+ deposit +" was succcessfull. Your new Bank balance is : "+ balance );
            }else{
                System.out.println("Inavlid Deposit amount . Please try again later !!!");
            }
        
        }else if (choice == 3) {
             System.out.println("Enter the amount in Ksh. ");
             double withdraw = scanner.nextDouble();
             if (withdraw > 0 && withdraw <= balance) {
                balance -= withdraw;
                System.out.println("Your withdrawal of amount "+ withdraw +" was succcessfull. Your new Bank balance is : "+ balance );                
             }else{
                System.out.println("Insufficient money in your Bank or Invalid Choice");
             }
        }
        else if (choice == 4) {
             System.out.println("Thanks for visiting us. Welcome back again");
             login = false;
        }
        else{
            System.out.println("Invalid choice please try again!");
        }
       } 
         scanner.close();
    }
}