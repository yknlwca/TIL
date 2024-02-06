import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj9935 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String String = bf.readLine();
		String boom = bf.readLine();

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < String.length(); i++) {
			stack.push(String.charAt(i));
			
			// 스택안에 하나씩 쌓일때마다 boom과 비교
			if (stack.size() >= boom.length()) {
				boolean isBoom = true;
				for (int j = 0; j < boom.length(); j++) {
					
					// 스택에서 boom과 같은 문자가 없으면 끝
					// 있으면 true
					if (stack.get(stack.size() - boom.length() + j) != boom.charAt(j)) {
						isBoom = false;
						break;
					}
				}
				// 같은 것이 있을 때 팝
				if (isBoom) {
					for (int j = 0; j < boom.length(); j++) {
						stack.pop();
					}
				}
			}
		}
		StringBuilder result = new StringBuilder();
		for (Character c : stack) {
			result.append(c);
		}
		if (result.length() > 0) {
			System.out.println(result.toString());
		} else {
			System.out.println("FRULA");
		}
		bf.close();
	}
}
