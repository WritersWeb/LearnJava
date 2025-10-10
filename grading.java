import java.util.Scanner;

public class grading {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in); 

        System.out.print("Enter your accumulaive marks :");
        Double marks = scanner.nextDouble();

        scanner.close();

        if(marks >= 70){
            System.out.println("You have been awarded a Fisrt Class Honours");
        }
        else if(marks <= 69 ){
            System.out.println("You have been awarded a Second Upper Honours");          
        }
        else if(marks <= 59 ){
            System.out.println("You have been awarded a Second Lower Honours");          
        }
        else if(marks <= 49 ){
            System.out.println("You have been awarded a Pass");          
        }
        else if(marks <= 39 ){
            System.out.println("You have failed! ");          
        }
        else{System.out.println("You have failed! ");}
    }
}


