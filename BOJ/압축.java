import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class 압축 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		String[] input = bf.readLine().split("");

		Stack<String> stack = new Stack<>();

		for (int i = 0; i < input.length; i++) {
			if (!input[i].equals(")")) {
				stack.push(input[i]);
			} else {
				int count = 0;
				while (!stack.peek().equals("(")) {
					String str = stack.pop();

					if (str.equals("길이계산해줄문자아무거나")) {
						count += Integer.parseInt(stack.pop());
					} else {
						count++;
					}
				}
				stack.pop();
				int k = Integer.parseInt(stack.pop());
				count = count * k;
				stack.push(String.valueOf(count));
				stack.push("길이계산해줄문자아무거나");
			}
		}

		int answer = 0;
		while (!stack.isEmpty()) {
			if (stack.peek().equals("길이계산해줄문자아무거나")) {
				stack.pop();
				answer += Integer.parseInt(stack.pop());
			} else {
				stack.pop();
				answer++;
			}
		}
		
		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
		bf.close();
	}
}
