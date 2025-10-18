import java.util.Scanner;

public class calculator{

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your first no. :");
        double firstNo = scanner.nextDouble();

        System.out.print("Choose an operator (+, - , / , *):");
        String operator = scanner.next();

        System.out.print("Enter your second no. :");
        double secondNo = scanner.nextDouble();

        double result = 0.0;

        scanner.close();

        switch(operator){
            case "+":
            result = firstNo + secondNo;
            break;
            case "-":  
            result = firstNo - secondNo;
            break;
            case "*":
            result = firstNo * secondNo;
            break;
            case "/":           
            if(secondNo != 0){
                result = firstNo / secondNo ;

            }else{
                System.out.println("Error ");
                
                return; 
            }
           
                break;
            default: System.out.println("Invalid operator");
                return;

        }
        System.out.println("The operation of "+ firstNo +"" + operator +"" + secondNo +" is : " +result);

    }
}