import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// 질문 게시판의 피드백
// R과 D의 개수만 세고 나중에 몰아서 처리하면 안 됩니다. 
// R을 할 때마다 D를 했을 때 지워지는 원소가 달라지기 때문입니다.
// [1,2,3] 배열에서 DRD 명령을 수행하면 어떻게 되어야 할지 생각해 보세요.
public class Boj5430 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(bf.readLine()); // 테스트 케이스
		for (int i = 0; i < T; i++) {
			Deque<Integer> deq = new ArrayDeque<>(); // 이전 테스트 수가 남지 않게 새로
			StringBuilder sb = new StringBuilder();

			int popCnt = 0; // 버릴 횟수

			char[] p = bf.readLine().toCharArray(); // R,D를 확인할 것

			for (int j = 0; j < p.length; j++) {
				if (p[j] == 'D') {
					popCnt++; // 버릴 횟수 증가
				} // R을 한번에 처리 하면 안됨
			}

			int n = Integer.parseInt(bf.readLine()); // 입력 숫자 개수
			StringTokenizer st = new StringTokenizer(bf.readLine(), "[],");
			for (int j = 0; j < n; j++) {
				deq.add(Integer.parseInt(st.nextToken()));
			}

			if (popCnt > deq.size()) {
				System.out.println("error");
				continue;
			}

			boolean reverse = false; // 뒤집기 여부

			// R과 D 명령어를 입력순대로 처리
			for (char command : p) {
				if (command == 'R') {
					reverse = !reverse; // R 명령어일 때 뒤집기
				} else if (command == 'D') {
					if (reverse) {
						deq.pollLast(); // 뒤집은 상태에서는 뒤에서부터 제거
					} else {
						deq.pollFirst(); // 그 외의 경우에는 앞에서부터 제거
					}
				}
			}

			// 결과 ㄱㄱ
			if (!deq.isEmpty()) {
				if (reverse) {
					sb.append(deq.pollLast());
					while (!deq.isEmpty()) {
						sb.append(',').append(deq.pollLast());
					}
				} else {
					sb.append(deq.pollFirst());
					while (!deq.isEmpty()) {
						sb.append(',').append(deq.pollFirst());
					}
				}
			}

			System.out.println("[" + sb + "]");
		}
	}
}
