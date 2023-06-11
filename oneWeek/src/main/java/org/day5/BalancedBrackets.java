package org.day5;

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

class Result {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
        // Write your code here
        Stack<String> stack = new Stack<>();


        for(int i = 0; i < s.length(); i++){
            String bra = s.substring(i, i+1);

            if(bra.equals("{") || bra.equals("[") || bra.equals("(")){
                stack.push(bra);
            }else{
                if(!stack.isEmpty()){
                    String partner = stack.pop();

                    if(bra.equals("}")){
                        if(!partner.equals("{")){
                            stack.empty();
                            return "NO";
                        }
                    }
                    if(bra.equals("]")){
                        if(!partner.equals("[")){
                            stack.empty();
                            return "NO";
                        }
                    }
                    if(bra.equals(")")){
                        if(!partner.equals("(")){
                            stack.empty();
                            return "NO";
                        }
                    }
                }
                else{
                    return "NO";
                }
            }
        }


        if(!stack.isEmpty()){
            return "NO";
        }
        else return "YES";


    }

}

public class BalancedBrackets {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

