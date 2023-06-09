package org.java_mediumLevel;


import java.io.*;
        import java.util.*;
        import java.text.*;
        import java.math.*;
        import java.util.regex.*;

public class TagContentExtractor{
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases>0){
            String line = in.nextLine();

            //Write your code here
            boolean matchFound = false;
            //<(.+)>([^<]+)</\\1>
            // \\1 means the same value like first group (ex: (.+))
            Pattern p = Pattern.compile("<(.+)>([^<]+)</\\1>");
            Matcher m = p.matcher(line);

            while(m.find()){
                System.out.println(m.group(2));
                matchFound = true;
            }

            if(matchFound == false){
                System.out.println("None");
            }

            testCases--;
        }
    }
}
