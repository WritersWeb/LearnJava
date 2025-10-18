public class Newmethod {

 public static void Hello() {
 System.out.println("Hello");
 }

 
 public static void threeLine() {
 Hello();
 Hello();
 Hello();
 }
 public static void main(String[] args) {
 System.out.println("First line.");
 threeLine();
 System.out.println("Second line.");
 }
 }