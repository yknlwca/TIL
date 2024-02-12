package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj3273 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 배열을 두개로 돌면서 원하는 값이 되는 쌍을 찾아 개수 세기
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] arr = new int[n];
        int x = Integer.parseInt(bf.readLine());

        // 배열 만들기
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); // 제일 큰 값과 작은 값 더하기 위해 정렬

        int cnt = 0; // 부합하는 쌍의 개수
        int start = 0; // 시작
        int end = n - 1; // 끝

        while (start < end) {
            int sum = arr[start] + arr[end];
            if (sum == x) { // 맞는 조건일때 변경 카운트
                cnt++;
                start++;
                end--;
            } else if (sum < x) {
                start++;
            } else {
                end--;
            }
        }
        bf.close();
        System.out.println(cnt);
    }
}
