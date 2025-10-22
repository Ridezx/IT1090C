import java.util.Scanner;

public class DevTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Past A: GetNonZero
        String name = SafeInput.getNonZeroLenString(in, "Enter your name");
        System.out.println("Hello," + name + ". That better be your name or there will be consequences.");

        // Part B: getInt
        int age = SafeInput.getInt(in, "Enter your age: ");
        System.out.println("You are " + age + " years old.");

        // C: getDouble
        double salary = SafeInput.getDouble(in, "Enter your desired salary");
        System.out.println("You want to make $" + salary + ". Unfortunately, you are likely to get 0.");

        // D: getRangedInt
        int month = SafeInput.getRangedInt(in, "Enter a month number: ", 1, 12);
        System.out.println("Month chosen: " + month);

        // E: getRangedDouble
        double percent = SafeInput.getRangedDouble(in, "Enter a number.", 0.0, 100.0);
        System.out.println("number entered: " + percent);

        // F: getYNConfirm
        boolean goAgain = SafeInput.getYNConfirm(in, "Do you want to continue?");
        System.out.println("Continue = " + goAgain);

        // G: getRegExString
        String studentID = SafeInput.getRegExString(in, "Enter your UC Student ID. ", "M\\d{7}");
        System.out.println("Student ID: " + studentID);
    }
}