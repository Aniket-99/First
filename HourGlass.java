import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {

        int rows = arr.length;
        int columns = arr[0].length;

        int max_hourglass_sum = -63;

        for (int i = 0; i < rows-2 ; i++) {
            for (int j = 0; j < columns-2 ; j++) {
                
                int current_hourglass_sum = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1] + arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];

                max_hourglass_sum = Math.max(max_hourglass_sum, current_hourglass_sum);

            }
            
        }
        return max_hourglass_sum;



    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

            for (int i = 0; i < 6; i++){

                for (int j = 0; j < 6; j++){
                    arr[i][j] = scanner.nextInt();
            }

        }

        int result = hourglassSum(arr);

        System.out.println(result);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}