package swea;

import java.util.Stack;

public class 스택응용 {
    public static void main(String[] args) {

        String text = "()()((())))";
        Stack<Character> stack = new Stack<>();

        boolean isOk = true;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (c == '(') {
                stack.add(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    System.out.println("닫는 괄호가 많습니다.");
                    isOk = false;
                    break;
                }
                stack.pop();
            }
            if (isOk){
                if (stack.isEmpty()) {
                    System.out.println("짝이 맞다");
                } else {
                    System.out.println("여는 괄호가 많다");
                }
        }
    }
}
}
