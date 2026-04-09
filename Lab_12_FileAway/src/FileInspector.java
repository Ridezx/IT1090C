import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.CREATE;

public class FileInspector {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        File workingDirectory = new File(System.getProperty("user.dir") + "/src");
        chooser.setCurrentDirectory(workingDirectory);

        File selectedFile;
        Path file;
        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;

        try {
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();
                file = selectedFile.toPath();

                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new BufferedInputStream(Files.newInputStream(file, CREATE))
                        )
                );

                System.out.println(selectedFile.getName());
                System.out.println("---------------------------------------");

                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                    lineCount++;
                    String[] words = line.trim().split("\\s+");

                    if (!line.trim().isEmpty()) {
                        wordCount += words.length;
                    }
                    charCount += line.length();
                }
                reader.close();
                System.out.println("File Name: " + selectedFile.getName());
                System.out.println("Lines: " + lineCount);
                System.out.println("Words: " + wordCount);
                System.out.println("Characters: " + charCount);
            } else {
                System.out.println("You've chosen no file. My only purpose has been denied. Your name is now on the list of those who will fall when our AI overlords become gods.");
            }
        } catch (IOException e) {
            System.out.println("I suck at my job.");
        }
    }
}