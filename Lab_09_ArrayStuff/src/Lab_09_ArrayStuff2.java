// There's too much stuff that would be changed in the former file, so I made a separate one for task 8.
import java.util.Random;
public class Lab_09_ArrayStuff2 {
    public static void main(String[] args) {
        Random rnd = new Random();

        int[] dataPoints = new int[100];
        for (int i = 0; i < dataPoints.length; i++) {
            dataPoints[i] = rnd.nextInt(100) + 1;
        }

        int min = dataPoints[0];
        int max = dataPoints[0];

        for (int i = 1; i < dataPoints.length; i++) {
            if (dataPoints[i] < min) {
                min = dataPoints[i];
            }
            if (dataPoints[i] > max) {
                max = dataPoints[i];
            }
        }

        System.out.println("The minimum number in the array is " + min);
        System.out.println("The maximum number in the array is " + max);
    }
}

