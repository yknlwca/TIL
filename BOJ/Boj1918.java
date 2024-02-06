import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj1918 {

	private static int priority(char yeonSanJa) {
		switch (yeonSanJa) {
		case '/':
		case '*':
			return 2;
		case '+':
		case '-':
			return 1;
		case '(':
		case ')':
			return 0;
		default:
			return -1;
		}
	}

	private static String toPostfix(String infix) {
		StringBuilder sb = new StringBuilder();
		Stack<Character> opStack = new Stack<>();

		for (int i = 0; i < infix.length(); i++) {
			char c = infix.charAt(i);

			// 연산자가 아니라면
			if (priority(c) == -1) {
				sb.append(c);
			}
			// '(' 푸쉬
			else if (c == '(') {
				opStack.push(c);
			}
			// ')'이라면 '('을 만나기 전까지 팝
			else if (c == ')') {
				while (!opStack.isEmpty() && opStack.peek() != '(') {
					sb.append(opStack.pop());
				}
				opStack.pop(); // '(' 제거
			} else {
				// 비어있지 않고 연산자 우선순위가 스택보다 작다면
				while (!opStack.isEmpty() && priority(c) <= priority(opStack.peek())) {
					sb.append(opStack.pop());
				}
				opStack.push(c);
			}
		}
		while (!opStack.isEmpty()) {
			sb.append(opStack.pop());
		}
		return sb.toString();
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String infix = bf.readLine();

		System.out.println(toPostfix(infix));
	}
}
