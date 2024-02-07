import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Boj1874 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Stack<Integer> stack = new Stack<>(); 		// 배열 저장 공간
		Queue<Character> que = new LinkedList<>();  // + , - 저장 공간

		int cnt = 1;
		boolean makeArr = true;

		for (int i = 0; i < N; i++) {
			if (cnt <= arr[i]) {
				while (cnt <= arr[i]) { 		// 입력받은 숫자가 나올때 까지
					stack.push(cnt); 			// 푸쉬 + 추가
					cnt++;
					que.add('+');
				}
				stack.pop(); 					// 숫자 찾고 팝 - 추가
				que.add('-');
			} else { 							// 입력 숫자가 크면
				int x = stack.pop(); 			// 꺼내기
				if (x > arr[i]) { 				// 꺼낸 숫자가 입력 숫자보다 크면 수열 성립이 안됨
					System.out.println("NO");
					makeArr = false; 			// 못 만들어요
					break;
				}
				que.add('-'); 					// 성립되면 - 추가

			}
		}
		if (makeArr) {
			while (!que.isEmpty()) {
				System.out.println(que.poll());
			}
		}
	}
}
