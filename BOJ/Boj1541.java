package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // - 뒤로 괄호를 묶으면 +된 값이 커짐 => 최솟값
        String[] numString = bf.readLine().split("-");

        int total = 0;
        for (int i = 0; i < numString.length; i++) {
            int temp = 0;
            String[] addNum = numString[i].split("\\+"); // 정규 표현 +는 이스케이프 문자

            for (String num : addNum) {
                temp += Integer.parseInt(num);
            }

            if (i == 0) { // 첫 번째 수 더하고
                total += temp;
            } else { // 괄호 안쪽 숫자 빼기
                total -= temp;
            }
        }
        System.out.println(total);
        bf.close();
    }
}
