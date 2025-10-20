import java.util.Scanner;

public class bank {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balance = 200;
        
        boolean autheticated  = false;

       int NewPIN , enterdPin;
       System.out.print("Create a 4 digit : ");
       NewPIN = scanner.nextInt();

       System.out.print("Re enter a 4 digit :");
       enterdPin = scanner.nextInt();
      

       if (NewPIN == enterdPin) {
        System.out.println("You can now login");
       }else{
        System.out.println("The PIN did not match");
        autheticated = false;
        
        return;
        
       }
       
       System.out.print("Provide your PIN : ");
       int loginPIN = scanner.nextInt();
       if (loginPIN == NewPIN) {
        System.out.println("Login successfull");
        autheticated = true;
       }else{
            System.out.println("Incorrect PIN");
       }

       while (autheticated) {
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
             autheticated = false;
        }
        else{
            System.out.println("Invalid choice please try again!");
        }
       } 
      
    }
}