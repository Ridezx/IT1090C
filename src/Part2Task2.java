public class Part2Task2 {
    public static void main(String[] args) {
        double springcost = 250.00;
        double summercost = 300.00;
        double fallcost = 200.00;
        double wintercost = 275.00;
        double totalyearlycost = 0.0;

        totalyearlycost = springcost + summercost + fallcost + wintercost;

        System.out.println("Home maintenance cost by season is");
        System.out.println("Spring costs " + springcost);
        System.out.println("Summer costs " + summercost);
        System.out.println("Fall costs " + fallcost);
        System.out.println("Winter costs " + wintercost);
        System.out.println("Total yearly maintenance cost is " + totalyearlycost);
    }
}
