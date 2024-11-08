import javax.swing.*;
import java.util.LinkedList;
import java.util.Stack;

class JavaApplication1 {

    private LinkedList<String> tasks = new LinkedList<>();
    private LinkedList<String> cow = new LinkedList<>();
    private Stack<String> undo = new Stack<>();

    // Add a new task to the to-do list
    public void addTask() {
        String add = JOptionPane.showInputDialog(null, "Enter Task to add:", "Add Task", JOptionPane.INFORMATION_MESSAGE);
        if (add != null && !add.trim().isEmpty()) {
            tasks.add(add);
            undo.push("add: " + add);
        } else {
            JOptionPane.showMessageDialog(null, "Task cannot be empty.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Mark a task as completed
    public void completeTask() {
        if (!tasks.isEmpty()) {
            StringBuilder taskList = new StringBuilder("To-Do List:\n");
            for (int i = 0; i < tasks.size(); i++) {
                taskList.append((i + 1)).append(". ").append(tasks.get(i)).append("\n");
            }
            JOptionPane.showMessageDialog(null, taskList.toString(), "Mark as Done", JOptionPane.INFORMATION_MESSAGE);
            String wow = JOptionPane.showInputDialog(null, "Enter the Number of the Task to Mark as Done.", "Mark as Done", JOptionPane.INFORMATION_MESSAGE);
            if (wow != null) {
                try {
                    int num = Integer.parseInt(wow);
                    if (num > 0 && num <= tasks.size()) {
                        String completedTask = tasks.remove(num - 1);
                        cow.add(completedTask);
                        undo.push("done: " + completedTask);
                        JOptionPane.showMessageDialog(null, "Task marked as done: " + completedTask, "Mark as Done", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid task number.", "Error", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number.", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "To-Do List is empty. Nothing to mark as done.");
        }
    }

    // View all tasks (both pending and completed tasks)
    public void viewTasks() {
        StringBuilder taskList = new StringBuilder("\nTo-Do List: \n");
        if (tasks.isEmpty()) {
            taskList.append("No tasks available.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                taskList.append((i + 1)).append(". ").append(tasks.get(i)).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, taskList.toString(), "View Tasks", JOptionPane.INFORMATION_MESSAGE);
    }

    // View completed tasks
    public void viewCompletedTasks() {
        StringBuilder taskList = new StringBuilder("\nCompleted Tasks: \n");
        if (cow.isEmpty()) {
            taskList.append("No tasks completed yet.");
        } else {
            for (int i = 0; i < cow.size(); i++) {
                taskList.append((i + 1)).append(". ").append(cow.get(i)).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, taskList.toString(), "View Completed Tasks", JOptionPane.INFORMATION_MESSAGE);
    }

    // View pending tasks (tasks that are not completed)
    public void viewPendingTasks() {
        StringBuilder taskList = new StringBuilder("\nPending Tasks: \n");
        if (tasks.isEmpty()) {
            taskList.append("No tasks pending.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                taskList.append((i + 1)).append(". ").append(tasks.get(i)).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, taskList.toString(), "View Pending Tasks", JOptionPane.INFORMATION_MESSAGE);
    }

    // Undo the last action (add or done)
    public void undo() {
        if (!undo.isEmpty()) {
            String lastAction = undo.pop();
            String[] part = lastAction.split(": ");
            String type = part[0];
            String task = part[1];

            if (type.equals("add")) {
                tasks.removeLast();
                JOptionPane.showMessageDialog(null, "Undid adding task: " + task, "Undo Task", JOptionPane.INFORMATION_MESSAGE);
            } else if (type.equals("done")) {
                cow.removeLast();
                tasks.add(task);
                JOptionPane.showMessageDialog(null, "Undid marking task as done: " + task, "Undo Task", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error! Nothing to undo.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Main application
    public static void main(String[] args) {
        JavaApplication1 todoList = new  JavaApplication1 ();

        while (true) {
            String[] options = {"Add Task", "Complete Task", "View Tasks", "View Completed Tasks", "View Pending Tasks", "Undo Last Action", "Exit"};
            int choice = JOptionPane.showOptionDialog(
                    null,
                    "Choose an action:",
                    "To-Do List",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    options,
                    options[0] // Default selection
            );

            if (choice == -1 || choice == options.length - 1) {
                JOptionPane.showMessageDialog(null, "Exiting.");
                break;
            }

            switch (choice) {
                case 0: // Add Task
                    todoList.addTask();            
                    break;
                case 1: // Complete Task
                    todoList.completeTask();
                    break;
                case 2: // View Tasks
                    todoList.viewTasks();
                    break;
                case 3: // View Completed Tasks
                    todoList.viewCompletedTasks();
                    break;
                case 4: // View Pending Tasks
                    todoList.viewPendingTasks();
                    break;
                case 5: // Undo Last Action
                    todoList.undo();
                    break;
            }
        }
    }
}
