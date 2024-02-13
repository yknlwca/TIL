import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Boj10866 {

	private static Deque<Integer> Deque = new ArrayDeque<>();

	private static void orderDeq(String order, StringBuilder sb) {
		if (order.startsWith("push_front")) {
			Deque.addFirst(Integer.parseInt(order.substring(11)));
		} else if (order.startsWith("push_back")) {
			Deque.addLast(Integer.parseInt(order.substring(10)));
		} else if (order.equals("pop_front")) {
			if (Deque.isEmpty()) {
				sb.append(-1 + "\n");
			} else {
				sb.append(Deque.pollFirst() + "\n");
			}
		} else if (order.equals("pop_back")) {
			if (Deque.isEmpty()) {
				sb.append(-1 + "\n");
			} else {
				sb.append(Deque.pollLast() + "\n");
			}
		} else if (order.equals("size")) {
			sb.append(Deque.size() + "\n");
		} else if (order.equals("empty")) {
			if (Deque.isEmpty()) {
				sb.append(1 + "\n");
			} else {
				sb.append(0 + "\n");
			}
		} else if (order.equals("front")) {
			if (Deque.isEmpty()) {
				sb.append(-1 + "\n");
			} else {
				sb.append(Deque.peekFirst() + "\n");
			}
		} else if (order.equals("back")) {
			if (Deque.isEmpty()) {
				sb.append(-1 + "\n");
			} else {
				sb.append(Deque.peekLast() + "\n");
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < test_case; i++) {
			orderDeq(bf.readLine(), sb);
		}

		System.out.print(sb.toString());
	}
}
