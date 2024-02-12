package boj;

import java.util.LinkedList;
import java.util.Scanner;

public class Boj1158 {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // 사람의 수 N
        int K = scanner.nextInt(); // K번째 사람을 제거

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i); // 1부터 N까지 리스트에 추가
        }

        StringBuilder sb = new StringBuilder();
        sb.append('<');

        int index = 0;
        while (list.size() > 1) {
            index = (index + K - 1) % list.size(); // K번째 찾기
            sb.append(list.remove(index)).append(", "); // K번째 제거 + 결과에 추가
        }

        sb.append(list.remove()).append('>'); // 마지막 요소 추가

        System.out.println(sb);
        scanner.close();
    }
}
