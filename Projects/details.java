// Project Complexity and Object-Oriented Design Explanation (Java)

// The Student Record Management system in Java is designed to be complex and robust by enforcing strict adherence to Object-Oriented Programming (OOP) principles and robust error handling.

// The project structure is organized around three main classes: Person, Student, and StudentManager.

// Monday: Classes, Objects, and Methods

// Classes and Objects: The system uses two main blueprints: Person (a base class) and Student (a specialized class). When the user adds a student, a Student Object is instantiated, holding its own distinct set of data (name, age, ID, GPA).

// Methods: Actions are implemented as methods. For example, getBaseInfo() is a method of the Person class, encapsulating the logic for formatting that information.

// Tuesday: Constructors and Encapsulation

// Constructors: The public Student(String name, int age, String studentId, double gpa) method is the constructor. It ensures that no Student object can exist without the required data fields being initialized, guaranteeing data integrity from the start.

// Encapsulation: All data fields (name, age, studentId, gpa) are declared private. Access and modification are strictly controlled:

// Getters (e.g., getGpa()) allow reading the data.

// Setters (e.g., setGpa()) allow controlled writing. Crucially, the setGpa() method contains the validation logic, meaning the Student object manages its own data integrity, preventing invalid GPAs from ever being set, regardless of where in the application the update is attempted.

// Wednesday: Inheritance and Polymorphism

// Inheritance: The Student class uses extends Person. This allows Student to automatically inherit all the properties and methods of Person (like name, age, and getBaseInfo()). This reuses code and establishes a clear "is-a" relationship (A Student is a Person).

// Polymorphism: This is shown through the toString() method in the Student class.

// The Student class overrides the default toString() method inherited from the base Object class (and expands upon the Person data).

// When the StudentManager loops through the students list to display records, calling students.get(i).toString() automatically executes the specialized Student version of the method, displaying the ID and GPA in addition to the base info. This is "many forms" (polymorphism) of the same method call.

// Thursday: Exception Handling

// Implementation: Robustness is achieved through try-catch blocks throughout the application, preventing crashes and guiding the user.

// Input Validation: try-catch handles NumberFormatException when parsing user input for age or GPA, preventing the application from terminating if the user types text instead of numbers.

// Data Integrity: The setGpa() setter method throws an IllegalArgumentException if the GPA is outside the 0.0-4.0 range. The main program's update logic catches this specific exception and prints a clean error message, ensuring the object's state remains valid.

// File I/O: try-catch blocks are mandatory to handle potential IOException or FileNotFoundException during file loading and saving.

// Friday: File Input/Output (Reading, Writing)

// Implementation: The StudentManager uses BufferedReader and BufferedWriter to handle File I/O.

// loadData(): Reads student records line-by-line from the student_data.txt file and converts each line into a new Student object.

// saveData(): Iterates through the list of Student objects and writes their data (formatted via toFileString()) back to the file, ensuring persistence between sessions.

// Sunday/Saturday: Console-based Student Record Management

// The run() method ties all these components together into a user-friendly console loop, making the application functional and executable. The continuous loop allows for interaction, and all data operations immediately trigger the file saving logic (saveData()) to ensure the records are up-to-date and persistent.