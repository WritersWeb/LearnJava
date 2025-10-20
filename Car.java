public class Car {
    // ===================================================
    // 1. INSTANCE VARIABLES (Fields/Attributes)
    // These define the STATE of every Car object.
    // Each object (like myCar or anotherCar) will have its own unique copy.
    // ===================================================
    String model;
    String color;
    int currentSpeed;

    // ===================================================
    // 2. CONSTRUCTOR (Special Method)
    // Used to INITIALIZE a new object when it is created.
    // It runs only once when 'new Car(...)' is called.
    // 'this.model' refers to the instance variable, while 'model' refers to the parameter.
    // ===================================================
    public Car(String model, String color) {
        this.model = model;
        this.color = color;
        this.currentSpeed = 0; // Initialize speed to 0 for all new cars
        System.out.println("✅ New " + this.color + " " + this.model + " has been created!");
    }

    // ===================================================
    // 3. METHODS (Behavior/Actions)
    // These define what a Car object CAN DO.
    // They operate on the object's instance variables.
    // ===================================================

    // Method to increase the car's speed
    public void accelerate(int speedIncrease) {
        this.currentSpeed += speedIncrease; // Update the object's state
        System.out.println(this.model + " accelerated by " + speedIncrease + " mph.");
        System.out.println("Current Speed: " + this.currentSpeed + " mph.");
    }

    // Method to display the car's current state
    public void displayState() {
        System.out.println("--- Car State ---");
        System.out.println("Model: " + this.model);
        System.out.println("Color: " + this.color);
        System.out.println("Speed: " + this.currentSpeed + " mph");
        System.out.println("-----------------");
    }

    // ===================================================
    // 4. MAIN METHOD (Used to create and test the objects)
    // This is where the program execution begins.
    // ===================================================
    public static void main(String[] args) {
        // 5. OBJECT CREATION (Instantiation)
        // Creating the first object, 'myCar', from the Car class blueprint.
        // The 'new Car(...)' part calls the constructor.
        Car myCar = new Car("Ford Mustang", "Red");

        // Creating the second independent object, 'anotherCar'.
        Car anotherCar = new Car("Tesla Model S", "White");

        // 6. METHOD CALLS (Invoking Object Behavior)
        // Calling methods on the first object:
        System.out.println("\n*** myCar Actions ***");
        myCar.accelerate(30);
        myCar.accelerate(25);

        // Calling methods on the second object:
        System.out.println("\n*** anotherCar Actions ***");
        anotherCar.accelerate(70);

        // 7. DISPLAYING INDEPENDENT STATE
        // Displaying the final state of each object.
        System.out.println("\n--- FINAL STATES ---");
        myCar.displayState();      // Output: Mustang is 55 mph
        anotherCar.displayState(); // Output: Tesla is 70 mph
    }
}