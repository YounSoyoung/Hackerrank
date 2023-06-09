package org.day3;

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

class CCResult {

    /*
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    public static String caesarCipher(String s, int k) {
        // Write your code here
        //z = 122 -> b = 98     122(c) + x + 2(k) = 98,
        //Z = 90 -> B = 66
        //a = 97 -> c = 99
        String answer = "";

        for(char c : s.toCharArray()){
            if(c >= 'a' && c <= 'z'){
                int a = c - (97 - k);
                answer += (char)((a % 26) + 97);

            }else if(c >= 'A' && c <= 'Z'){
                int a = c - (65 - k);
                answer += (char)((a % 26) + 65);
            }else {
                answer += c;
            }
        }

        return answer;

    }

}

public class CaesarCipher {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = CCResult.caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
