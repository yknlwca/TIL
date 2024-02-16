import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj20923 {
	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 각자 가지고 있는 덱
		Deque<Integer> dodo = new ArrayDeque<>();
		Deque<Integer> su = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());

			// 각자 덱 만들기
			dodo.addFirst(Integer.parseInt(st.nextToken()));
			su.addFirst(Integer.parseInt(st.nextToken()));

		}

		// 그라운드 덱
		Deque<Integer> doGround = new ArrayDeque<>();
		Deque<Integer> suGround = new ArrayDeque<>();

		for (int i = 0; i < M; i++) {

			// 도도가 시작
			// 0번 부터 짝수 : 도도 턴
			// 홀수 : 수연 턴
			int currentCard;
			if (i % 2 == 0) {
				currentCard = dodo.poll();
				doGround.addFirst(currentCard);
			} else {
				currentCard = su.poll();
				suGround.addFirst(currentCard);
			}

			// 덱에 카드가 0이 되면 상대방의 승리
			if (dodo.isEmpty()) {
				System.out.println("su");
				return;
			} else if (su.isEmpty()) {
				System.out.println("do");
				return;
			}

			// 수연이가 종을 칠 때 어느쪽의 그라운드도 비어있으면 안된다
			// 도도가 종을 칠때는 그라운드 엠띠 조건이 없음
			// 낸 카드가 5일 때 도도가 종을 친다
			
			// 도도 승리 조건 검사
			// 도도의 덱으로 아래서부터 수연 그라운드 덱을 넣고 다음 자신의 그라운드 덱
			if (!doGround.isEmpty() && doGround.peekFirst() == 5 || 
					!suGround.isEmpty() && suGround.peekFirst() == 5) {
				dodo.addAll(suGround);
				dodo.addAll(doGround);
				doGround.clear();
				suGround.clear();
			}
			
			// 수연 승리 조건 검사
			// 수연 종 치고 도도 그라운드덱 아래로 넣은 후 자신의 그라운드 덱 아래로
			else if (!doGround.isEmpty() && !suGround.isEmpty() && 
					(doGround.peekFirst() + suGround.peekFirst() == 5)) {
				su.addAll(doGround);
				su.addAll(suGround);
				doGround.clear();
				suGround.clear();
			}

		}

		// 남은 덱에서 카드가 많은 사람 승리
		// 같다면 비김
		if (dodo.size() > su.size()) {
			System.out.println("do");
		} else if (dodo.size() == su.size()) {
			System.out.println("dosu");
		} else if (dodo.size() < su.size()) {
			System.out.println("su");
		}

	}
}
