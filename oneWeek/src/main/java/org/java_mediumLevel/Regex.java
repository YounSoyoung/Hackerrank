package org.java_mediumLevel;

import java.util.regex.Matcher;
        import java.util.regex.Pattern;
        import java.util.Scanner;

class Regex{

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }

    }
}

//Write your code here
class MyRegex {
    //0   //0 ~ 9//0~9
    //0~1 //0~9  //0~9
    //2 // 0~4 //0~9
    //2 // 5 // 0~5
    String zeroTo255 = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0~5])";
    String pattern = zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255;
}

