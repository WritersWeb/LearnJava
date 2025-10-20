public class Person {
    // 1. Data is made PRIVATE - It can't be changed directly from outside.
    private int age;

    // 2. Public Setter method is provided for controlled access.
    public void setAge(int newAge) {
        // Validation Logic: This is the CONTROL!
        if (newAge >= 0 && newAge <= 120) {
            this.age = newAge; // Only set the age if it is valid.
            System.out.println("Age updated successfully.");
        } else {
            System.out.println("Error: Invalid age value provided.");
        }
    }

    // 3. Public Getter method to read the value.
    public int getAge() {
        return age;
    }

public static void main (String [] args){

        // Setting age using the setter method
        Person person = new Person();
        person.setAge(25); // Valid age
        System.out.println("Person's Age: " + person.getAge());

        person.setAge(-5); // Invalid age
        System.out.println("Person's Age: " + person.getAge());
    }
}