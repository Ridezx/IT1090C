import java.util.Scanner;
public class Reggie {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String ssn = SafeInput.getRegExString(in, "Enter SSN: ", "^\\d{3}-\\d{2}-\\d{4}$");
        System.out.println("SSN accepted: " + ssn);

        String mnum = SafeInput.getRegExString(in, "Enter UC Student M-number: ", "^(M)\\d{7}$");
        System.out.println("M-number accepted: " + mnum);

        String menu = SafeInput.getRegExString(in, "Enter menu choice (O S V Q)", "^[OoSsVvQq]$");
        System.out.println("Menu option: " + menu.toUpperCase());
    }
}

