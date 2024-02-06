import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj10828 {
	private static Stack<Integer> mainStack = new Stack<>();

	private static int orderStack(String input) {

		String[] inputString = input.split(" ");

		switch (inputString[0]) {
		case "push":
			mainStack.push(Integer.parseInt(inputString[1]));
			return -2;

		case "top":
			if (mainStack.isEmpty()) {
				return -1;
			} else {
				return mainStack.peek();
			}

		case "pop":
			if (mainStack.isEmpty()) {
				return -1;
			} else {
				return mainStack.pop();
			}

		case "empty":
			if (mainStack.isEmpty()) {
				return 1;
			} else {
				return 0;
			}

		case "size":
			return mainStack.size();
		default:
			return -2;
		}

	}

	public static void main(String[] args) {
		try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
			int test_case = Integer.parseInt(bf.readLine());
			while (test_case-- > 0) {
				String input = bf.readLine();
				int result = orderStack(input);
				if (result != -2) {
					System.out.println(result);
				}
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
}
