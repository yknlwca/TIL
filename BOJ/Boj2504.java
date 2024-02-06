import java.util.Scanner;
import java.util.Stack;

public class Boj2504 {

	private static int countMakDaeGi(String inputString) {
		Stack<Character> stack = new Stack<>();
		int cnt = 0;
		for (int i = 0; i < inputString.length(); i++) {
			char c = inputString.charAt(i);
			if (c == '(') {
				stack.push(c);
			} else {
				stack.pop();
				if (inputString.charAt(i - 1) == '(') { // 레이저 였다면
					cnt += stack.size();
				} else { // 하나의 쇠막대기 끝
					cnt++;
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inputString = sc.nextLine();
		
		int count = countMakDaeGi(inputString);
		
		System.out.println(count);
		
		sc.close();
	}
}
