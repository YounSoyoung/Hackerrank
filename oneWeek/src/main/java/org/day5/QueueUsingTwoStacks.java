package org.day5;


import java.io.*;
import java.util.*;

public class QueueUsingTwoStacks {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        MyQueue q = new MyQueue<>();

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int command = sc.nextInt();
            if(command == 1){ //enqueue
                q.enqueue(sc.nextInt());
            }else if(command == 2){
                q.dequeue();
            }else if(command == 3){
                System.out.println(q.peek());
            }

        }

    }

    public static class MyQueue<Integer>{
        private Stack<Integer> stack1 = new Stack<>();
        private Stack<Integer> stack2 = new Stack<>();

        public void enqueue(Integer num){
            stack1.push(num);
        }

        public Integer dequeue(){
            if(stack2.isEmpty()){
                shiftStack();
            }

            return stack2.pop();
        }

        public Integer peek(){
            if(stack2.isEmpty()){
                shiftStack();
            }

            return stack2.peek();
        }

        public void shiftStack(){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
    }
}

