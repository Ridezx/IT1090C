import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class DataSaver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> records = new ArrayList<>();

        boolean keepGoing = true;

        while (keepGoing) {
            String first = SafeInput.getNonZeroLenString(in, "First name? ");
            String last = SafeInput.getNonZeroLenString(in, "Last name? ");

            int idNum = SafeInput.getRangedInt(in, "Enter ID number with zero security backing whatsoever. ", 1, 999999);
            String id = String.format("%06d", idNum);

            String email = SafeInput.getNonZeroLenString(in, "Email: ");

            int year = SafeInput.getRangedInt(in, "In what year were you given life, " + first + " " + last + "?", 1910, 2025);

            String record = first + ", " + last + ", " + id + ", " + email + ", " + year;
            records.add(record);

            keepGoing = SafeInput.getYNConfirm(in, "One person should absolutely have more than one ID. In fact, you should have everyone's ID because principle of least privilege is crime to you. Do you have more than one?");
        }

        String filename = SafeInput.getNonZeroLenString(in, "What would you like this .csv security risk to be called?");
        filename = filename + ".csv";

        try {
            File workingDirectory = new File(System.getProperty("user.dir"));
            Path file = Paths.get(workingDirectory.getPath() + "/src/" + filename);

            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(
                            new BufferedOutputStream(Files.newOutputStream(file, CREATE))
                    )
            );
            for (String rec : records) {
                writer.write(rec);
                writer.newLine();
            }
            writer.close();
            System.out.println("CSV file written: " + filename + ". \nGood luck. You'll need it.");

        } catch (IOException e) {
            System.out.println("I suck at my job.");
        }
    }
}