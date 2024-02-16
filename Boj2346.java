import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Boj2346 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 풍선의 개수
        // 덱 <- 배열

        Deque<int[]> deque = new ArrayDeque<>(); 

        for (int i = 1; i <= N; i++) {
            deque.add(new int[]{i, sc.nextInt()}); // [번호, 이동거리]
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            int[] current = deque.poll(); // 현재 풍선을 제거하고 정보를 가져옴
            sb.append(current[0]).append(' '); // 풍선 번호 출력

            if (deque.isEmpty()) {
                break;
            }

            int step = current[1]; // 이동 거리
            if (step > 0) {
                // 양수일 경우 오른쪽으로 이동
                for (int i = 0; i < step - 1; i++) {
                    deque.offerLast(deque.pollFirst());
                }
            } else {
                // 음수일 경우 왼쪽으로 이동
                for (int i = 0; i < Math.abs(step); i++) {
                    deque.offerFirst(deque.pollLast());
                }
            }
        }

        System.out.println(sb.toString());
        sc.close();
    }
}
