import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj10845 {

	private static Queue<Integer> Queue = new LinkedList<>();

	private static void orderQ(String order, StringBuilder sb) {
		if (order.startsWith("push")) {
			Queue.add(Integer.parseInt(order.substring(5)));
		} else if (order.equals("pop")) {
			if (Queue.isEmpty()) {
				sb.append(-1 + "\n");
			} else {
				sb.append(Queue.poll() + "\n");
			}
		} else if (order.equals("size")) {
			sb.append(Queue.size() + "\n");
		} else if (order.equals("empty")) {
			if (Queue.isEmpty()) {
				sb.append(1 + "\n");
			} else {
				sb.append(0 + "\n");
			}
		} else if (order.equals("front")) {
			if (Queue.isEmpty()) {
				sb.append(-1 + "\n");
			} else {
				sb.append(Queue.peek() + "\n");
			}
		} else if (order.equals("back")) {
			if (Queue.isEmpty()) {
				sb.append(-1 + "\n");
			} else {
				sb.append(((LinkedList<Integer>) Queue).peekLast() + "\n");
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < test_case; i++) {
			orderQ(bf.readLine(), sb);
		}

		System.out.print(sb.toString());
	}
}
