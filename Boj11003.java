import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.LinkedList;

public class Boj11003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            // 현재 값이 덱의 마지막 값보다 작으면, 덱의 마지막 값이 현재 값보다 클 때까지 제거
            while (!deque.isEmpty() && A[deque.peekLast()] > A[i]) {
                deque.pollLast();
            }
            deque.offerLast(i); // 현재 인덱스 추가

            // 윈도우의 시작이 L보다 크면 가장 앞의 값을 제거 (윈도우 범위 벗어남)
            if (deque.peekFirst() <= i - L) {
                deque.pollFirst();
            }

            // 덱의 첫 번째 값이 현재 윈도우에서의 최솟값의 인덱스
            sb.append(A[deque.peekFirst()] + " ");
        }

        System.out.println(sb.toString());
    }
}
