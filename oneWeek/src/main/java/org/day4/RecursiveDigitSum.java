package org.day4;

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

class SumResult {

    /*
     * Complete the 'superDigit' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING n
     *  2. INTEGER k
     */

    public static int super_digit(String n){
        if(n.length() == 1){
            return Integer.parseInt(n);
        }

        long temp = 0;
        for(int i = 0; i < n.length(); i++){
            temp += Character.getNumericValue(n.charAt(i));
        }

        return super_digit(Long.toString(temp));
    }

    public static int superDigit(String n, int k) {
        // Write your code here
        if(n.length() == 1 && k == 1){
            return Integer.parseInt(n);
        }

        long sum = 0;
        for(int i = 0; i < n.length(); i++){
            sum += Character.getNumericValue(n.charAt(i));
        }

        sum = sum*k;

        return super_digit(Long.toString(sum));


    }

}

public class RecursiveDigitSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        String n = firstMultipleInput[0];

        int k = Integer.parseInt(firstMultipleInput[1]);

        int result = SumResult.superDigit(n, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

