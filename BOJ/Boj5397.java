package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj5397 {

    private static String proInput(String input) {
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        for (char c : input.toCharArray()) {
            switch (c) {
                case '<':
                    if (!leftStack.isEmpty()) {
                        rightStack.push(leftStack.pop());
                    }
                    break;
                case '>':
                    if (!rightStack.isEmpty()) {
                        leftStack.push(rightStack.pop());
                    }
                    break;
                case '-':
                    if (!leftStack.isEmpty()) {
                        leftStack.pop();
                    }
                    break;
                default:
                    leftStack.push(c);
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }
        while (!rightStack.isEmpty()) {
            sb.append(rightStack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(bf.readLine());

        while (test_case > 0) {
            String input = bf.readLine();
            System.out.println(proInput(input));
            test_case--;
        }
        bf.close();
    }
}
