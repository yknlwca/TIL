package boj;

import java.io.*;
import java.util.HashMap;

public class 패션왕신해빈 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bf.readLine());
        for (int tc = 0; tc < T; tc++) {
            // N개의 옷 입력 받기
            int N = Integer.parseInt(bf.readLine());
            HashMap<String, Integer> hash = new HashMap<>();

            for (int i = 0; i < N; i++) {
                String[] cloth = bf.readLine().split(" ");
                String type = cloth[1];
                // 같은 이름 처리 방법
                hash.put(type, hash.getOrDefault(type, 0) + 1);
            }

            // 전체 경우의 수 계산
            int answer = 1;
            for (int val : hash.values()) {
                answer *= val + 1;
            }
            // 아무것도 입지 않았을 때 -1
            bw.write(String.valueOf(answer - 1));
            bw.newLine();

        }
        bw.flush();
        bw.close();
        bf.close();
    }
}
