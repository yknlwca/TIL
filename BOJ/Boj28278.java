import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj28278 {
	private static Stack<Integer> mainStack = new Stack<>();

	private static void orderStack(String input, StringBuilder sb) {

		String[] inputString = input.split(" ");

		switch (inputString[0]) {

		case "1":
			mainStack.push(Integer.parseInt(inputString[1]));
			break;
		case "2":
			if (mainStack.isEmpty()) {
				sb.append(-1).append("\n");
			} else {
				sb.append(mainStack.pop()).append("\n");
			}
			break;

		case "3":
			sb.append(mainStack.size()).append("\n");
			break;
		case "4":
			if (mainStack.isEmpty()) {
				sb.append(1).append("\n");
			} else {
				sb.append(0).append("\n");
			}
			break;
		case "5":
			if (mainStack.isEmpty()) {
				sb.append(-1).append("\n");
			} else {
				sb.append(mainStack.peek()).append("\n");
			}
			break;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(bf.readLine());
		
		StringBuilder sb = new StringBuilder();
		while (test_case-- > 0) {
			String input = bf.readLine();
			orderStack(input, sb);
		}
		System.out.println(sb.toString());
		bf.close();
	}
}
