import java.util.Scanner;

public class input {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

       

        System.out.println("Hello "+ name);
        System.out.println("A'm "+ age);


        scanner.close();
    }
}
