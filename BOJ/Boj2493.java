import java.util.Scanner;
import java.util.Stack;

public class Boj2493 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] top = new int[N];
		int[] answer = new int[N];

		for (int i = 0; i < N; i++) {
			top[i] = sc.nextInt();
		}

		Stack<Integer> heightStack = new Stack<>(); // 탑 높이 스택
		Stack<Integer> indexStack = new Stack<>(); // 탑 위치 인덱스 스택

		for (int i = 0; i < N; i++) {

			while (!heightStack.isEmpty() && heightStack.peek() < top[i]) { // 스택이 비지않고 스택의 마지막 배열의 첫번째 원소가 top 배열의 i 번째보다
																			// 작다면
				// 스택에 있는 것 중 왼쪽 탑이 더 작으면 제거
				heightStack.pop();
				indexStack.pop();
			}
			if (heightStack.isEmpty()) {
				answer[i] = 0; // 스택이 비어있으면 수신 받지 못함
			} else {
				answer[i] = indexStack.peek() + 1; // 인덱스 번호 + 1 ==> 탑의 위치
			}
			// 탑의 높이, 인덱스 번호
			heightStack.push(top[i]);
			indexStack.push(i);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(answer[i]).append(" ");
		}
		System.out.print(sb);
		sc.close();
	}
}
