import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj11899X {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String str = bf.readLine();
		Stack<Character> stack = new Stack<>();
		int cntClose = 0;
		int cntOpen = 0;
		boolean bal = true;
		
		for (int i = 0; i < str.length(); i++) {
			int balance = 0;
			if (i == '(') {
				balance++;
			}else {
				balance--;
			}
			if (balance < 0) {
				bal = false;
			}
			stack.push(str.charAt(i));
			
		}
		while (!stack.isEmpty()) {
			if(stack.pop() == ')') {
				cntClose++;
			}else if (stack.pop() == '(') {
				cntOpen--;
			}
		}
		
		if (bal) System.out.println(cntOpen);
		else System.out.println(cntOpen + cntClose);
	}
}
