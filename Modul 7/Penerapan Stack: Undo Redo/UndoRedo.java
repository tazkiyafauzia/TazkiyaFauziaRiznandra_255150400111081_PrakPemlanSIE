import java.util.Scanner;
import java.util.Stack;

public class UndoRedo {
    Stack<String> undoStack = new Stack<>();
    Stack<String> redoStack = new Stack<>();

    public void action(String command) {
        System.out.println("Action: " + command);
        undoStack.push(command);
        redoStack.clear();
        UndoRedo.print(undoStack, redoStack);
    }

    public void undo() {
        if (undoStack.isEmpty())
        System.out.println("Nothing to undo.");
        else {
            String command = undoStack.pop();
            redoStack.push(command);
            System.out.println("Undo: " + command);
        }
        UndoRedo.print(undoStack, redoStack);
    }

    public void redo() {
        if (redoStack.isEmpty())
        System.out.println("Nothing to redo.");
        else {
            String command = redoStack.pop();
            undoStack.push(command);
            System.out.println("Redo: " + command);
        }
        UndoRedo.print(undoStack, redoStack);
    }

    public static void print(Stack<String> undo, Stack<String> redo) {
        System.out.print("Stack Undo: ");
        for(int i = 0; i < undo.size(); i++){
            System.out.print(undo.get(i));
            if(i < undo.size() - 1)
                System.out.print(", ");
        }
        System.out.println();

        System.out.println("Stack Redo: ");
        for(int i = 0; i < redo.size(); i++){
            System.out.print(redo.get(i));
            if(i < redo.size() - 1)
                System.out.print(", ");
        }
        System.out.println();
    }   

    public static void main(String[] args) {
        UndoRedo app = new UndoRedo();
        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {
            System.out.println("---------------------------------");
            System.out.println("Ketikkan teks sebagai command.");
            System.out.println("Ketik U untuk melakukan Undo");
            System.out.println("Ketik R untuk melakukan Redo");
            System.out.println("Ketik X untuk mengakhiri program.");
            System.out.print("Command: ");
            command = scanner.nextLine();
            if (command.equalsIgnoreCase("x")) break;
            if (command.equalsIgnoreCase("u")) { app.undo(); }
            else if (command.equalsIgnoreCase("r")) { app.redo(); }
            else app.action(command);
        }
        scanner.close();
        System.out.println("Program selesai.");
    }
}
