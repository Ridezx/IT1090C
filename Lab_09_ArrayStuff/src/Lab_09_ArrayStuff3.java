// I should have just created a new file for each task, but it's too late now and I don't feel like rewriting the code from the other tasks.
import java.util.Random;
public class Lab_09_ArrayStuff3 {
    public static void main(String[] args) {
        Random rnd = new Random();

        int[] dataPoints = new int[100];
        for (int i = 0; i < dataPoints.length; i++) {
            dataPoints[i] = rnd.nextInt(100) + 1;
        }

        System.out.println("Average of dataPoints is: " + getAverage(dataPoints));
    }

    public static double getAverage(int[] values) {
        int sum = 0;
        for (int val : values) {
            sum += val;
        }
        return (double) sum / values.length;
    }
}