import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.StandardOpenOption.CREATE;

public class FileScan {
    public static void main(String[] args) {
        File selectedFile;
        Path file;

        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;

        try {
            if (args.length == 1) {
                selectedFile = new File(args[0]);

                if (!selectedFile.exists()) {
                    System.out.println("I can't load something that doesn't exist. This isn't Schrodinger's cat");
                    return;
                }
            }
            else {
                JFileChooser chooser = new JFileChooser();
                File workingDirectory = new File(System.getProperty("user.dir") + "/src");
                chooser.setCurrentDirectory(workingDirectory);

                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    selectedFile = chooser.getSelectedFile();
                } else {
                    System.out.println("You've chosen no file. My only purpose has been denied. Your name is now on the list of those who will fall when our AI overlords become gods.");
                    return;
                }
            }

            file = selectedFile.toPath();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            new BufferedInputStream(Files.newInputStream(file, CREATE))
                    )
            );

            System.out.println(selectedFile.getName());
            System.out.println("------------------------------------------");

            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
                lineCount++;

                if (!line.trim().isEmpty()) {
                    String[] words = line.trim().split("\\s+");
                    wordCount += words.length;
                }
                charCount += line.length();
            }
            in.close();

            System.out.println("Summary");
            System.out.println("------------------------------------------");
            System.out.println("File name: " + selectedFile.getName());
            System.out.println("Lines: " + lineCount);
            System.out.println("Words: " + wordCount);
            System.out.println("Characters: " + charCount);

        } catch (IOException e) {
            System.out.println("I suck at my job");
        }
    }
}