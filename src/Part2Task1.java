public class Part2Task1 {
    public static void main(String[] args) {
        double purchasePrice = 50.00;
        double salesTaxRate = 0.05;
        double salesTaxAmount = 0.0;

        salesTaxAmount = purchasePrice * salesTaxRate;

        System.out.println("The price of the purchase is: " + purchasePrice);
        System.out.println("The sales tax rate is: " + (salesTaxRate * 100));
        System.out.println("The computed sales tax is: " + salesTaxAmount);
    }
}
