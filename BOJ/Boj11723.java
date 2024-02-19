package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj11723 {
    //    static int[] Array = new int[20]; // 크기가 20인 정수 배열 선언. 1부터 20까지의 숫자를 저장하기 위한 용도입니다.
    // 시간 초과로 인한 비트 연산 필요
    static int bitSet = 0; // 비트 마스크를 사용한 집합 표현 해보기

    // 처음에는 모든 원소가 없는 상태 0
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(bf.readLine());

        StringBuilder sb = new StringBuilder(); // 시간 초과 줄이기 위한 스트링빌더

        for (int i = 0; i < M; i++) {
            String command = bf.readLine();
            String[] arr = command.split(" ");
            switch (arr[0]) {
                case "add":
                    add(Integer.parseInt(arr[1]));
                    break;
                case "remove":
                    remove(Integer.parseInt(arr[1]));
                    break;
                case "check":
                    sb.append(check(Integer.parseInt(arr[1])) ? "1\n" : "0\n");
                    break;
                case "toggle":
                    toggle(Integer.parseInt(arr[1]));
                    break;
                case "all":
                    all();
                    break;
                case "empty":
                    empty();
                    break;
            }
        }
        System.out.println(sb);
    }

    private static void add(int x) {
        bitSet |= (1 << (x - 1));
        // 1 << (x - 1) : 1을 왼쪽으로 (x - 1)번 이동시켜 1로 만듬
        // |= 는 OR연산 이미 있다면 변경없음
    }

    private static void remove(int x) {
        bitSet &= ~(1 << (x - 1));
        // ~ (x - 1)에 x 번째 위치를 제외하고 모든 위치를 1로 만듬
        // &= and x 번째 원소를 제거
    }

    private static boolean check(int x) {
        return (bitSet & (1 << (x - 1))) != 0;
        // x 번째 원소가 존재하면 0(false)이 아니다
    }

    private static void toggle(int x) {
        bitSet ^= (1 << (x - 1));
        // ^= XOR연산
        // 베타적 논리합
        // 다르다면 true
        // 1 ^ 0 = 1
        // 0 ^ 1 = 1
    }
    private static void all(){
        bitSet = (1 << 20) - 1; // 20개 모두 포함한 상태
    }
    private static void empty() {
        bitSet = 0; // 모든 원소를 제거
    }
}
