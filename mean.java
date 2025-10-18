import java.util.Scanner;

public class mean { 
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter you Maths marks (In percentage) :");
        int mathMarks = scanner.nextInt();
        
        System.out.print("Enter you English marks (In percentage) : ");
        int englishMarks = scanner.nextInt();
        
        System.out.print("Enter you Kiswahili marks (In percentage) : ");
        int KisMarks = scanner.nextInt();

        
        System.out.print("Enter you Science marks (In percentage) :");
        int scihMarks = scanner.nextInt();
        
        System.out.print("Enter you CRE marks (In percentage) :");
        int creMarks = scanner.nextInt();

        double mean;

        double totalMarks;
        totalMarks = (mathMarks + englishMarks + KisMarks + scihMarks + creMarks);
        mean =(totalMarks) / 5;

        scanner.close();

        System.out.println("Your mean marks is " + mean);
      
if (mean >= 80) {
    System.out.println("Your mean of "+ mean + " equals to an A ");
    System.out.println("Congratulations");
}else if (mean >= 70) {
    System.out.println("Your mean of "+ mean + " equals to a B ");
    System.out.println("You can do better");
}else if (mean >= 60) {
    System.out.println("Your mean of "+ mean + " equals to a C ");
    System.out.println("Keep trying");
}else if (mean >= 50) {
    System.out.println("Your mean of "+ mean + " equals to a D ");
    System.out.println("You need to do better");
}else if (mean >= 50) {
    System.out.println("Your mean of "+ mean + " equals to an E ");
    System.out.println("You need to work hard!");
}else {
    System.out.println("You have failed!!");
}


    }
}



