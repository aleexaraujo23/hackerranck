import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the balancedSums function below.
    static String solve(List<Integer> arr) {
        int x = 0;
        int sum = 0;
        for (int a : arr) {
            sum += a;
        }

        for (int y : arr) {
            if (2 * x == sum - y) {
                return "YES";
            }
            x = x + y;
        }
        return "NO";

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    
        int T = Integer.parseInt(bufferedReader.readLine().trim());


        if (T >= 1 && T <= 10) {

        IntStream.range(0, T).forEach(TItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                int max = (int) Math.pow(10, 5);

                if (n >= 1 && n <= max) {  // Verificando N

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                String result = solve(arr);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
                } else {
                    System.out.println("O Numero de N tem que ser >=1 e <=10^5.");

                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

             
        });

        }else{
             System.out.println(" O Numero de Consultas tem que ser >=1 e <=10.");

        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
