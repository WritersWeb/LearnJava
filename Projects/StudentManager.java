import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// --- Day 1: Classes, Objects, and Methods & Day 3: Inheritance ---
class Person {
    private String name;
    private int age;

    // --- Day 2: Constructor ---
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // --- Day 1: Methods (Getter) ---
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // --- Day 1: Method to display basic info ---
    public String getBaseInfo() {
        return "Name: " + name + ", Age: " + age;
    }
}

// --- Day 3: Inheritance & Polymorphism ---
class Student extends Person {
    // --- Day 2: Encapsulation (Private fields) ---
    private String studentId;
    private double gpa;

    // --- Day 2: Constructor (Calling parent constructor for Inheritance) ---
    public Student(String name, int age, String studentId, double gpa) {
        super(name, age);
        // Ensure initial GPA is validated
        setGpa(gpa); 
        this.studentId = studentId;
    }

    // --- Day 2: Encapsulation (Getters) ---
    public String getStudentId() {
        return studentId;
    }

    public double getGpa() {
        return gpa;
    }

    // --- Day 2 & Day 4: Encapsulation (Setter with Exception Handling) ---
    public void setGpa(double newGpa) {
        if (newGpa >= 0.0 && newGpa <= 4.0) {
            this.gpa = newGpa;
        } else {
            // Day 4: Exception Handling for data integrity
            throw new IllegalArgumentException("GPA must be between 0.0 and 4.0.");
        }
    }

    // --- Day 3: Polymorphism (Overriding the standard Object method) ---
    @Override
    public String toString() {
        // Uses the base method from Person and appends specific details
        return super.getBaseInfo() + ", ID: " + studentId + ", GPA: " + String.format("%.2f", gpa);
    }
    
    // Helper method for file storage (simulating JSON structure with a string)
    public String toFileString() {
        return String.format("%s,%d,%s,%.2f", getName(), getAge(), studentId, gpa);
    }
}

// --- Day 5: File I/O & Weekend: Console Management ---
public class StudentManager {
    private List<Student> students;
    private static final String FILE_NAME = "student_data.txt";
    private Scanner scanner;

    public StudentManager() {
        this.students = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        loadData();
    }

    // --- Day 5: File I/O (Reading) ---
    private void loadData() {
        File file = new File(FILE_NAME);
        // Day 4: Exception Handling for File I/O
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    try {
                        // Day 4: Exception Handling for data parsing
                        String name = parts[0].trim();
                        int age = Integer.parseInt(parts[1].trim());
                        String id = parts[2].trim();
                        double gpa = Double.parseDouble(parts[3].trim());
                        
                        // Student constructor can throw IllegalArgumentException if GPA is bad
                        students.add(new Student(name, age, id, gpa));
                        
                    // FIX: Catching IllegalArgumentException covers both NFE (subclass) 
                    // and IAE (superclass) thrown by the Student constructor's setGpa().
                    } catch (IllegalArgumentException e) { 
                        System.out.println("Warning: Skipping malformed record in file due to data error or invalid GPA: " + line);
                    }
                }
            }
            System.out.println("Successfully loaded " + students.size() + " student records.");
        } catch (FileNotFoundException e) {
            System.out.println("File '" + FILE_NAME + "' not found. Starting with an empty record.");
        } catch (IOException e) {
            System.out.println("An I/O error occurred during file loading: " + e.getMessage());
        }
    }

    // --- Day 5: File I/O (Writing) ---
    private void saveData() {
        // Day 4: Exception Handling for File I/O
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) {
                writer.write(s.toFileString());
                writer.newLine();
            }
            System.out.println("Records saved successfully.");
        } catch (IOException e) {
            System.out.println("Error: Could not write data to file: " + e.getMessage());
        }
    }

    public void addStudent() {
        System.out.println("\n--- ADD STUDENT ---");
        
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        int age = 0;
        // Day 4: Exception Handling for user input
        try {
            System.out.print("Enter age: ");
            age = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid age. Must be a whole number.");
            return;
        }

        System.out.print("Enter unique Student ID: ");
        String studentId = scanner.nextLine();
        if (findStudent(studentId) != null) {
            System.out.println("Error: A student with this ID already exists.");
            return;
        }

        double gpa = 0.0;
        try {
            System.out.print("Enter initial GPA (0.0 - 4.0): ");
            gpa = Double.parseDouble(scanner.nextLine());
            
            // The Student constructor will use the setter, triggering validation
            Student newStudent = new Student(name, age, studentId, gpa);
            students.add(newStudent);
            saveData();
            System.out.println("Student '" + name + "' added successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid GPA format. Please enter a decimal number (e.g., 3.5).");
        } catch (IllegalArgumentException e) {
            // Catches the exception thrown by the Student setter (Encapsulation + Exception Handling)
            System.out.println("Error: " + e.getMessage());
            System.out.println("Student not added.");
        }
    }

    public Student findStudent(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        System.out.println("\n--- ALL STUDENT RECORDS ---");
        for (int i = 0; i < students.size(); i++) {
            // Day 3: Polymorphism in action: calling the specialized toString()
            System.out.println((i + 1) + ". " + students.get(i).toString());
        }
        System.out.println("---------------------------\n");
    }

    public void updateGpa() {
        System.out.println("\n--- UPDATE GPA ---");
        System.out.print("Enter Student ID to update: ");
        String studentId = scanner.nextLine();
        Student student = findStudent(studentId);

        if (student != null) {
            System.out.println("Current GPA for " + student.getName() + ": " + String.format("%.2f", student.getGpa()));
            try {
                System.out.print("Enter new GPA (0.0 - 4.0): ");
                double newGpa = Double.parseDouble(scanner.nextLine());
                
                // Day 2/4: This calls the setter method with validation (Encapsulation)
                student.setGpa(newGpa); 
                saveData(); // Save after successful update
                System.out.println("GPA for " + student.getName() + " updated to " + String.format("%.2f", newGpa) + ".");
            } catch (NumberFormatException e) {
                System.out.println("Update failed: Invalid GPA format.");
            } catch (IllegalArgumentException e) {
                // Catches the validation exception from the setGpa method
                System.out.println("Update failed: " + e.getMessage());
            }
        } else {
            System.out.println("Error: Student ID not found.");
        }
    }

    public void run() {
        while (true) {
            System.out.println("\n===== Student Record Manager (JAVA) =====");
            System.out.println("1. Add New Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student GPA");
            System.out.println("4. Exit and Save");
            System.out.print("Enter your choice (1-4): ");

            String choiceInput = scanner.nextLine();
            
            try {
                int choice = Integer.parseInt(choiceInput);
                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        displayAllStudents();
                        break;
                    case 3:
                        updateGpa();
                        break;
                    case 4:
                        System.out.println("Exiting the application. All changes have been saved.");
                        saveData(); // Final save upon exit
                        return;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                }
            } catch (NumberFormatException e) {
                // Day 4: Catch general non-numeric input errors
                System.out.println("Input error: Choice must be a number. Please try again.");
            } catch (Exception e) {
                System.out.println("An unexpected application error occurred: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        manager.run();
    }
}
