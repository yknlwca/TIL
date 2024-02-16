import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        String[] numStr = bf.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(numStr[i]);
        }

        // 하나하나 루프 돌면서 확인 하면 시간 초과
        // 인덱스 이용해 top을 확인하고 바로 팝하기

        for (int i = 0; i < arr.length; i++) {
            // 스택이 비어있지 않고 현재 값이 스택의 top에 해당하는 값보다 큰 경우
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                // 현재 값이 top의 오큰수가 됨
                result[stack.pop()] = arr[i];
            }
            // 값이 아닌 인덱스 이용
            // 현재 인덱스 스택에 저장
            stack.push(i);
        }

        // 스택에 남아있는 인덱스의 오큰수는 없으므로 -1로 설정
        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int ans : result) {
            sb.append(ans).append(" ");
        }
        System.out.println(sb);
        bf.close();
    }
}
