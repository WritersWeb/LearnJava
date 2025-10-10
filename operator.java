 import static java.lang.Math.*;

public class operator {

    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int c = 30;

        // Arithmetic Operators
        System.out.println( (a + b));
        System.out.println( (c - a));
        System.out.println( (a * b));
        System.out.println(  (b / a));
        System.out.println(   (b % a));

        // Relational Operators
        System.out.println("Is a equal to b? " + (a == b));
        System.out.println("Is a not equal to b? " + (a != b));
        System.out.println("Is a greater than b? " + (c > b));
        System.out.println("Is a less than b? " + (a < b));
        System.out.println("Is a greater than or equal to b? " + (a >= b));
        System.out.println("Is a less than or equal to b? " + (a <= b));

        // Logical Operators
        boolean x = true;
        boolean y = false;
        System.out.println("x AND y: " + (x && y));
        System.out.println("x OR y: " + (x || y));
        System.out.println("NOT x: " + (!x));

        System.out.println((a > b));

        
        double nom = 4;
        double nume = sqrt(nom);

        System.out.println(nume);

        

    }
}