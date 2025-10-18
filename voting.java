import java.util.Scanner;
public class voting {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter the number of voters  :");
        int RegVoters = scanner.nextInt();

        String Abel = null;
        String Gore = null;
        String Beckham = null;

        while (RegVoters < 100) {
           

            System.out.print("1. Candidate 1 = Abel");
            System.out.print("2. Candidate 2 = Gore");
            System.out.print("3. Candidate 3 = Beckham");

             System.out.print("Cast your vote :");
            int vote = scanner.nextInt();
            RegVoters++;

            switch (vote) {
                case 1:
                    System.out.println("You have voted for " + Abel );
                    
                    break;
                    case 2:
                    System.out.println("You have voted for " + Gore );
                    case 3:
                    System.out.println("You have voted for " + Beckham );
            
                default:
                    break;
            }
        }
    scanner.close();
    }
}
