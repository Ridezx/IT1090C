import java.util.ArrayList;
import java.util.Scanner;

public class Lab11ListMaker {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        boolean done = false;

        while (!done) {
            displayMenu();
            String choice = SafeInput.getRegExString(in, "Enter your choice {A/D/I/P/Q]: ", "[AaDdIiPpQq]");
            choice = choice.toUpperCase();

            switch (choice) {
                case "A":
                    addItem(list);
                    break;
                case "D":
                    deleteItem(list, in);
                    break;
                case "I":
                    insertItem(list, in);
                    break;
                case "P":
                    displayList(list);
                    break;
                case "Q":
                    boolean confirmQuit = SafeInput.getYNConfirm(in, "You leaving me? You better not...I'll be sad.");
                    if (confirmQuit) {
                        done = true;
                    }
                    break;
            }
        }
    }

    private static void displayMenu() {
        System.out.println("------------------------");
        System.out.println("A - Add item");
        System.out.println("D - Delete item");
        System.out.println("I - Insert item");
        System.out.println("P - Print list");
        System.out.println("Q - Quit");
        System.out.println("------------------------");
    }

    private static void displayList(ArrayList<String> list) {
        System.out.println("\n--- Current List ---");
        if (list.isEmpty()) {
            System.out.println("(You have done nothing, or this broke. One of them.)");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + ": " + list.get(i));
            }
        }
    }

    private static void addItem(ArrayList<String> list) {
        Scanner in = new Scanner(System.in);
        String item = SafeInput.getNonZeroLenString(in, "What are you adding? ");
        list.add(item);
        System.out.println("It is added. Go do something else now.");
    }

    private static void deleteItem(ArrayList<String> list, Scanner in) {
        if (list.isEmpty()) {
            System.out.println("Trying to delete nothing, are we? Absolutely genius idea. ");
            return;
        }
        displayList(list);
        int deleteIndex = SafeInput.getRangedInt(in, "Number you want to delete?: ", 1, list.size());
        String removedItem = list.remove(deleteIndex - 1);
        System.out.println(removedItem + "was wiped from the plane of existence");
    }

    private static void insertItem(ArrayList<String> list, Scanner in) {
        displayList(list);
        int position = SafeInput.getRangedInt(in, "What number do you want to add at? ", 1, list.size() + 1);
        String item = SafeInput.getNonZeroLenString(in, "What are you adding that so desperately needed to be at this slot? ");
        list.add(position - 1, item);
        System.out.println("Well, it's in there now.");
    }
}
