package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj1966 {

    // 인덱스 정보와 우선순위를 포함하는 클래스
    private static class Important {
        int index;
        int priority;

        public Important(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test_case = sc.nextInt();

        for (int t = 0; t < test_case; t++) {
            int N = sc.nextInt();   // 문서 개수
            int M = sc.nextInt();   // 문서 인덱스 0 부터

            Queue<Important> que = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                que.add(new Important(i, sc.nextInt()));    // 입력받은 초기 문서 넣기
            }

            int printer = 0;        // 몇 번째인지 세기
            while (!que.isEmpty()) {
                Important xianZai = que.poll();             // 하나 빼와서 비교
                boolean mostPriority = true;

                for (Important q : que) {
                    if (q.priority > xianZai.priority) {    // 꺼낸게 우선순위가 낮으면 컷
                        mostPriority = false;
                        break;
                    }
                }

                if (mostPriority) {
                    printer++;
                    if (xianZai.index == M) {               // 주어진 인덱스번째 것 출력
                        System.out.println(printer);
                        break;
                    }
                } else {
                    que.add(xianZai);
                }
            }
        }
    }
}
