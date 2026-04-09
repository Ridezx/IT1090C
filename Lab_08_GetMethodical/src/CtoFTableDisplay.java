public class CtoFTableDisplay {
    public static void main(String[] args) {
        System.out.println("Celsius\t\tFahrenheit");
        System.out.println("-----------------------");

        for (int c = -100; c <= 100; c++) {
            double f = CtoF(c);
            System.out.println(c + "\t\t" + f);
        }
    }
    public static double CtoF(double celsius) {
        return (celsius * 9.0 / 5.0) + 32;
    }
}