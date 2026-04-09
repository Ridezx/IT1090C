public class Part2Task3 {
    public static void main(String[] args) {
        double startingbalance = 5000.00;
        double annualinterestrate = 0.17;
        double monthlyinterestrate = annualinterestrate / 12;
        double balanceafteronemonth = startingbalance + (startingbalance * monthlyinterestrate);
        double balanceaftertwomonths = balanceafteronemonth + (balanceafteronemonth * monthlyinterestrate);

        System.out.println("Starting credit card balance is " + startingbalance);
        System.out.println("Annual interest rate is " + (annualinterestrate * 100));
        System.out.println("Monthly interest rate is " + (monthlyinterestrate * 100));
        System.out.println("Balance after one month is " + balanceafteronemonth);
        System.out.println("Balance after two months is " + balanceaftertwomonths);
    }
}
