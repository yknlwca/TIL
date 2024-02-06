import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj5397 {

    private static String cussorBack(String input) {
        Stack<Character> mainStack = new Stack<>();
        Stack<Character> subStack = new Stack<>();

        for (char c : input.toCharArray()) {
            switch (c) {
                case '<':									// 커서 왼쪽 이동
                    if (!mainStack.isEmpty()) {
                        subStack.push(mainStack.pop());	// 글자가 있으면 하나 뺴서 보관
                    }
                    break;
                case '>':									// 커서 오른쪽 이동
                    if (!subStack.isEmpty()) {
                        mainStack.push(subStack.pop());	// 뻬둔 글자가 있으면 다시 추가
                    }
                    break;
                case '-': 									// 백스페이스
                    if (!mainStack.isEmpty()) { 			
                        mainStack.pop();					// 글자 지우기
                    }
                    break;
                default:									// 기본 글자 추가
                    mainStack.push(c);
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!mainStack.isEmpty()) {			// 후입 선출 (LIFO) 때문에
            subStack.push(mainStack.pop()); 	// 빼서 (leftStack.pop) 다시 넣고 (rightStack.push)
        }
        while (!subStack.isEmpty()) {			// 가장 처음 들어간 것부터 출력
            sb.append(subStack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(bf.readLine());

        while (test_case > 0) {
            String input = bf.readLine();
            System.out.println(cussorBack(input));
            test_case--;
        }
        bf.close();
    }
}
