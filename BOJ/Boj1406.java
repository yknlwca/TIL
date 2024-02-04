import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String startString = bf.readLine(); // 처음 문자열
        int howMany = Integer.parseInt(bf.readLine()); // 명령어 개수

        // 커서 이동을 위해 두 개의 Stack 활용
        Stack<Character> startStack = new Stack<>();
        Stack<Character> subStack = new Stack<>();

        // 초기 문자열 배열 만들기
        for (char c : startString.toCharArray()) {
            startStack.push(c);
        }

        for (int i = 0; i < howMany; i++) {
            String[] command = bf.readLine().split(" ");

            if (command[0].equals("L")) { // 커서 왼쪽 이동
                if (!startStack.isEmpty()) {
                    subStack.push(startStack.pop());
                }
            } else if (command[0].equals("D")) { // 커서 오른쪽 이동
                if (!subStack.isEmpty()) {
                    startStack.push(subStack.pop());
                }
            } else if (command[0].equals("B")) { // 왼쪽 문자 삭제
                if (!startStack.isEmpty()) {
                    startStack.pop();
                }
            } else if (command[0].equals("P")) { // 왼쪽 문자 추가
                startStack.push(command[1].charAt(0));
            }
        }

        // 결과 문자열 만들기
        StringBuilder sb = new StringBuilder();
        while (!startStack.isEmpty()) {
            subStack.push(startStack.pop());
        }
        while (!subStack.isEmpty()) {
            sb.append(subStack.pop());
        }

        System.out.println(sb.toString());
    }
}