package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class simple {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String initialString = br.readLine(); // 초기 문자열
        int commandCount = Integer.parseInt(br.readLine()); // 명령어 개수

        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        // 초기 문자열을 왼쪽 스택에 넣기
        for (char c : initialString.toCharArray()) {
            leftStack.push(c);
        }

        for (int i = 0; i < commandCount; i++) {
            String[] command = br.readLine().split(" ");
            switch (command[0]) {
                case "L": // 커서를 왼쪽으로 이동
                    if (!leftStack.isEmpty()) {
                        rightStack.push(leftStack.pop());
                    }
                    break;
                case "D": // 커서를 오른쪽으로 이동
                    if (!rightStack.isEmpty()) {
                        leftStack.push(rightStack.pop());
                    }
                    break;
                case "B": // 왼쪽 문자 삭제
                    if (!leftStack.isEmpty()) {
                        leftStack.pop();
                    }
                    break;
                case "P": // 왼쪽에 문자 추가
                    leftStack.push(command[1].charAt(0));
                    break;
            }
        }

        // 결과 문자열 만들기
        StringBuilder sb = new StringBuilder();
        while (!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }
        while (!rightStack.isEmpty()) {
            sb.append(rightStack.pop());
        }

        System.out.println(sb.toString());
    }
}
