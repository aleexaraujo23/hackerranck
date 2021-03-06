import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    // Complete the solve function below.
    static String solve(int[] a) {

        int g = a[0];
        for (int i = 1; i < a.length; i++) {
            g = gcd(g, a[i]);
        }

         if(g == 1){
             return "YES";
         }else{
            return "NO";    
         }
     
    }

    static int gcd(int x, int y) {
         while(y>0){
            int tmp = y;
            y = x % y;
            x = tmp;
        }
        return x;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");


        for (int tItr = 0; tItr < t; tItr++) {
            int aCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] a = new int[aCount];

            String[] aItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int aItr = 0; aItr < aCount; aItr++) {
                int aItem = Integer.parseInt(aItems[aItr]);
                a[aItr] = aItem;
            }

            String result = solve(a);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

       
        bufferedWriter.close();

        scanner.close();
    }
}
