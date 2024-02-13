import java.util.Scanner;
import java.util.Stack;

public class Boj4949 {
	
	static boolean Balace(String input) {
		Stack<Character> stack = new Stack<>();
		
		for(char ch : input.toCharArray()) {
			if(ch == '(' || ch == '[') {
				stack.push(ch);
			}else if (ch == ')' || ch == ']') {
				if(stack.isEmpty()) {
					return false;
				}
				char openGul = stack.pop();
				
				if ((ch == ')' && openGul != '(') || (ch == ']' && openGul != '[')) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		
		while (true) {
			String input = sc.nextLine();
			if(input.equals(".")) {
				break;
			}

			String str = Balace(input) ? "yes" : "no";
			System.out.println(str);

		}
		sc.close();
	}
}
