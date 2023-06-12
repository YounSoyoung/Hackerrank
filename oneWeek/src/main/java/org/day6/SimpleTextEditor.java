package org.day6;

import java.io.*;
import java.util.*;

public class SimpleTextEditor {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        TextEditor tx = new TextEditor("");

        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            int command = sc.nextInt();

            switch(command){
                case 1 : tx.append(sc.next()); break;
                case 2 : tx.delete(sc.nextInt()); break;
                case 3 : tx.print(sc.nextInt()); break;
                case 4 : tx.undo(); break;
                default : break;
            }
        }

    }

    public static class TextEditor {

        private Stack<String> stack = new Stack<>();



        public TextEditor(String text){
            stack.push(text);
        }

        public void append(String w){
            stack.push(stack.peek() + w);
        }

        public void delete(int k){
            String s = stack.peek();
            int len = s.length();
            if(len < k){
                stack.push("");
            }else{
                stack.push(s.substring(0, len - k));
            }
        }

        public void print(int k){
            String s = stack.peek();
            System.out.println(s.charAt(k-1));
        }

        public void undo(){
            if(!stack.isEmpty()){
                stack.pop();
            }
        }
    }
}
