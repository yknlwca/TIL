import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Boj28279 {

	private static Deque<Integer> Deque = new ArrayDeque<>();

	private static void orderDeq(String order, StringBuilder sb) {
		if (order.startsWith("1")) {
			Deque.addFirst(Integer.parseInt(order.substring(2)));
		} else if (order.startsWith("2")) {
			Deque.addLast(Integer.parseInt(order.substring(2)));
		} else if (order.equals("3")) {
			if (Deque.isEmpty()) {
				sb.append(-1 + "\n");
			} else {
				sb.append(Deque.pollFirst() + "\n");
			}
		} else if (order.equals("4")) {
			if (Deque.isEmpty()) {
				sb.append(-1 + "\n");
			} else {
				sb.append(Deque.pollLast() + "\n");
			}
		} else if (order.equals("5")) {
			sb.append(Deque.size() + "\n");
		} else if (order.equals("6")) {
			if (Deque.isEmpty()) {
				sb.append(1 + "\n");
			} else {
				sb.append(0 + "\n");
			}
		} else if (order.equals("7")) {
			if (Deque.isEmpty()) {
				sb.append(-1 + "\n");
			} else {
				sb.append(Deque.peekFirst() + "\n");
			}
		} else if (order.equals("8")) {
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
