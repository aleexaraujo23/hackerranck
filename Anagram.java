import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



public class Solution {

    // Complete the sherlockAndAnagrams function below.
    static boolean isAnagrams(String s1, String s2) {

      if(s1.length() != s2.length()) return false;
        
        int cnt = 0;
        boolean[] visit = new boolean[s2.length()];
        for(int i = 0; i < s1.length(); i++) {
            for(int j = 0; j < s2.length(); j++) {
                if(s1.charAt(i) == s2.charAt(j) && !visit[j]) {
                    cnt++; visit[j] = true; break;
                }
            }
        }
        return cnt == s2.length()? true : false;
    }

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        int cnt = 0;
        for (int i = 1, n = s.length(); i < n; i++) {
            List<String> subsetList = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (i + j <= n) {
                    subsetList.add(s.substring(j, i + j));
                }
            }

            for (int k = 0, size = subsetList.size(); k < size; k++) {
                for (int l = k + 1; l < size; l++) {
                    if (isAnagrams(subsetList.get(k), subsetList.get(l))) {
                        cnt++;
                    }
                }
            }
        }


        return cnt;
    }

    public static boolean isCampoValido(String texto) {
        Pattern p = Pattern.compile("[a-z]+");
        Matcher m = p.matcher(texto);
        return m.matches();
    }
   
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    if (q >= 1 && q <= 10) {  // Verificando Q

        for (int qItr = 0; qItr < q; qItr++) {

            String s = scanner.nextLine();

            if (isCampoValido(s)) {  // Verificando String [a-z]
                int qtdstring = s.length();

                if (qtdstring >= 2 && qtdstring <= 100) {

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
            } else {

                   System.out.println("O Numero de Caracteres tem que ser >=2 e <=100.");
                   }
             } else {
                    System.out.println("As letras tem de ser minusculas.");
                }

           }

        bufferedWriter.close();

        scanner.close();

          } else {

            System.out.println(" O Numero de Consultas tem que ser >=1 e <=10.");
        }

       
    }
}
