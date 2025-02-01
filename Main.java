import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class Todo {
    Scanner scan = new Scanner(System.in);
    ArrayList<String> tasks = new ArrayList<String>();
    File file = new File("C:\\Users\\Moeez\\Desktop\\java\\Project4\\todo.txt");

    // lines seperator
    public void seperator() {
        System.out.println("*********************");
    }

    // Add Task method
    public void addTask() {
        seperator();
        System.out.print("Enter Task: ");
        tasks.add(scan.nextLine());
        try (FileWriter filewriter = new FileWriter("todo.txt")) {

            for (String t : tasks) {
                filewriter.write(t + System.lineSeparator());
            }

            filewriter.close();

        } catch (IOException e) {
            System.out.println("Something went wrong while writing to the file");
        }
        System.out.println("Task added successfully");
        seperator();
    }

    // Delete Task method
    public void deleteTask(int index) {
        seperator();
        System.out.println("Task removed at index: " + index + " " + tasks.remove(index));
        seperator();
    }

    // ViewTask method
    public void viewTask() {
        seperator();

        // try catch is used to read data from the file
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) { // hasNextLine() reads a full line in a file
                String line = scan.nextLine();
                System.out.println(line); // Print each line to the console
            }
            scan.close();
        } catch (IOException e) {
            System.out.println("File not found: " + e.getMessage());
        }
        seperator(); // this is a function used for styling
    }

    // if you don't want to print data manually from the arraylist then comment the
    // try catch part and uncomment it

    // if (tasks.isEmpty()) {
    // System.out.println("No Tasks Found, First Add a Task");
    // } else {
    // for (int i = 0; i < tasks.size(); i++) {
    // System.out.println(i + ". " + tasks.get(i));
    // }
    // seperator();
    // }
}

class Main {
    public static void main(String[] args) {
        Todo t = new Todo();
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to todolist app");

        boolean keepRunning = true;
        while (keepRunning) {
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. View Task");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int n = scan.nextInt();

            switch (n) {
                case 1:
                    t.addTask();
                    break;

                case 2:
                    System.out.println("Enter task number");
                    t.deleteTask(scan.nextInt());
                    break;

                case 3:
                    t.viewTask();
                    break;

                case 4:
                    System.out.println("Exiting... Thank you for using todo");
                    keepRunning = false;
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
        scan.close();
    }
}