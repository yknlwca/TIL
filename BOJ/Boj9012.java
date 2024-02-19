package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());


        for (int i = 0; i < T; i++) {
            String str = bf.readLine();
            Stack<Character> stack = new Stack<>();
            boolean isVPS = true;

            for (char c : str.toCharArray()) {
                if (c == '(') {
                    stack.push(c);
                } else if (c == ')') {  // )일때 스택에 (이 없으면 뽈스
                    if (!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        isVPS = false;
                        break;
                    }
                }
            }
            if (!isVPS || !stack.isEmpty()) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}
