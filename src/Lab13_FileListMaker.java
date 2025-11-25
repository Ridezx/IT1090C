import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
import static java.nio.file.StandardOpenOption.CREATE;

public class Lab13_FileListMaker {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        boolean done = false;
        boolean needsToBeSaved = false;
        String currentFileName = "";

        while (!done) {
            displaymenu();
            String choice = SafeInput.getRegExString(in, "Enter your choice {A/D/I/M/O/S/C/V/Q]: ", "[AaDdIiMmOoSsCcVvQq]");
            choice = choice.toUpperCase();

            switch (choice) {
                case "A":
                    additem(list);
                    needsToBeSaved = true;
                    break;

                case "D":
                    deleteitem(list, in);
                    needsToBeSaved = true;
                    break;

                case "I":
                    insertitem(list, in);
                    needsToBeSaved = true;
                    break;

                case "V":
                    displaylist(list);
                    break;

                case "M":
                    moveitem(list, in);
                    needsToBeSaved = true;
                    break;

                case "C":
                    if (!list.isEmpty()) {
                        boolean confirm = SafeInput.getYNConfirm(in, "Wiping the whole list into oblivion.");
                        if (confirm) {
                            list.clear();
                            System.out.println("The void has claimed all list items.");
                            needsToBeSaved = true;
                        }
                    }
                    break;

                case "O":
                    try {
                        if (needsToBeSaved && !list.isEmpty()) {
                            boolean saveFirst = SafeInput.getYNConfirm(in, "You did some work, why let that go to waste? Save?");
                            if (saveFirst) {
                                if (currentFileName.isEmpty()) {
                                    currentFileName = SafeInput.getNonZeroLenString(in, "Enter filename (with .txt): ");
                                }
                                savefile(list, currentFileName);
                                needsToBeSaved = false;
                            }
                        }

                        list = openfile();
                        currentFileName = "";
                        needsToBeSaved = false;

                    } catch (IOException e) {
                        System.out.println("I suck at my job.");
                    }
                    break;

                case "S":
                    try {
                        if (currentFileName.isEmpty()) {
                            currentFileName = SafeInput.getNonZeroLenString(in, "Enter filename (with .txt): ");
                        }
                        savefile(list, currentFileName);
                        needsToBeSaved = false;
                    } catch (IOException e) {
                        System.out.println("I suck at my job.");
                    }
                    break;

                case "Q":
                    boolean confirmQuit = SafeInput.getYNConfirm(in, "You leaving me? You better not...I'll be sad.");
                    if (confirmQuit) {
                        if (needsToBeSaved && !list.isEmpty()) {
                            boolean delete = SafeInput.getYNConfirm(in, "Do you wish to send your unsaved items to oblivion?");

                            if (!delete) {
                                try {
                                    if (currentFileName.isEmpty()) {
                                        currentFileName = SafeInput.getNonZeroLenString(in, "What shall I call this abomination? ");
                                    }
                                    savefile(list, currentFileName);
                                } catch (IOException e) {
                                    System.out.println("I suck at my job.");
                                }
                            }
                        }
                        done = true;
                    }
                    break;
            }
        }
    }

    private static void displaymenu() {
        System.out.println("------------------------");
        System.out.println("A - Add item");
        System.out.println("D - Delete item");
        System.out.println("I - Insert item");
        System.out.println("V - View list");
        System.out.println("M - Move Item");
        System.out.println("O - Open file");
        System.out.println("S - Save Current List");
        System.out.println("C - Clear List");
        System.out.println("Q - Quit");
        System.out.println("------------------------");
    }

    private static void displaylist(ArrayList<String> list) {
        System.out.println("\n--- Current List ---");
        if (list.isEmpty()) {
            System.out.println("(You have done nothing, or this broke. One of them.)");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + ": " + list.get(i));
            }
        }
    }

    private static void additem(ArrayList<String> list) {
        Scanner in = new Scanner(System.in);
        String item = SafeInput.getNonZeroLenString(in, "What are you adding? ");
        list.add(item);
        System.out.println("It is added. Go do something else now.");
    }

    private static void deleteitem(ArrayList<String> list, Scanner in) {
        if (list.isEmpty()) {
            System.out.println("Trying to delete nothing, are we? Absolutely genius idea. ");
            return;
        }
        displaylist(list);
        int deleteIndex = SafeInput.getRangedInt(in, "Number you want to delete?: ", 1, list.size());
        String removedItem = list.remove(deleteIndex - 1);
        System.out.println(removedItem + " was wiped from the plane of existence");
    }

    private static void insertitem(ArrayList<String> list, Scanner in) {
        displaylist(list);
        int position = SafeInput.getRangedInt(in, "What number do you want to add at? ", 1, list.size() + 1);
        String item = SafeInput.getNonZeroLenString(in, "What are you adding that so desperately needed to be at this slot? ");
        list.add(position - 1, item);
        System.out.println("Well, it's in there now.");
    }

    private static void moveitem(ArrayList<String> list, Scanner in) {
        if (list.isEmpty()) {
            System.out.println("There is nothing to move. Your list is as empty as my soul.");
            return;
        }
        displaylist(list);
        int from = SafeInput.getRangedInt(in,
                "Which item number do you want to move? ",
                1, list.size());

        int to = SafeInput.getRangedInt(in,
                "Where should it go? ",
                1, list.size());

        String item = list.remove(from - 1);
        list.add(to - 1, item);
        System.out.printf("The item has been subdued and kidnapped to position %d in the list", to);
    }

    // Help me god.

    private static ArrayList<String> openfile() throws IOException {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        ArrayList<String> newList = new ArrayList<>();

        int result = chooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            BufferedReader reader = new BufferedReader(new FileReader(selectedFile));

            String line;
            while ((line = reader.readLine()) != null) {
                newList.add(line);
            }
            reader.close();
            System.out.println("Loaded: " + selectedFile.getName());
        } else {
            System.out.println("You have deprived me of my sole purpose. You are my 13th reason why.");
        }
        return newList;
    }

    private static void savefile(ArrayList<String> list, String fileName) throws IOException {
        Path file = new File(System.getProperty("user.dir") + "/src/" + fileName).toPath();
        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(
                        new BufferedOutputStream(Files.newOutputStream(file, CREATE))
                )
        );

        for (String item : list) {
            writer.write(item);
            writer.newLine();
        }
        writer.close();
        System.out.println("Saved to: " + fileName);
    }
}