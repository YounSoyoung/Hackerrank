package org.day1;

//Plus Minus

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        int positive = 0;
        int negative = 0;
        int zero = 0;

        for(int i = 0; i < arr.size(); i++){

            int value = arr.get(i);

            if(value > 0){
                positive++;
            }else if(value < 0){
                negative++;
            }else if(value == 0){
                zero++;
            }
        }

        System.out.printf("%.6f\n", (double)positive/arr.size());
        System.out.printf("%.6f\n", (double)negative/arr.size());
        System.out.printf("%.6f\n", (double)zero/arr.size());

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}

