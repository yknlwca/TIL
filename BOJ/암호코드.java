package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 암호코드 {

    static final String[] secret = {
            "0001101", // 0
            "0011001", // 1
            "0010011", // 2
            "0111101", // 3
            "0100011", // 4
            "0110001", // 5
            "0101111", // 6
            "0111011", // 7
            "0110111", // 8
            "0001011"  // 9
    };

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        for (int tc = 1; tc <= T; tc++) {
            String[] input = bf.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);

            String code = "";
            int result = 0;

            for (int i = 0; i < N; i++) {
                String line = bf.readLine();
                if (line.contains("1")) {   // 1이 포함된 것 찾기
                    code = line;

                    // 56개의 암호
                    String realCode = code.substring(code.lastIndexOf('1') - 55, code.lastIndexOf('1') + 1);
                    result = checkCode(realCode);
                }
            }
            System.out.println("#" + tc + " " + result);
        }
    }

    private static int decode(String pattern) {
        for (int i = 0; i < secret.length; i++) {
            // 암호 -> 숫자로 변환
            if (secret[i].equals(pattern)) {
                return i;
            }
        }
        return -1;
    }

    private static int checkCode(String code) {
        int sumOdd = 0;
        int sumEven = 0;
        for (int i = 0; i < 8; i++) {
            int num = decode(code.substring(i * 7, (i + 1) * 7));
            // 인덱스가 짝수면 홀수
            // 인덱스가 홀수면 짝수
            if (i % 2 == 0) {
                sumOdd += num;  // 홀수 자리
            } else {
                sumEven += num; // 짝수 자리
            }
        }
        int sum = sumOdd * 3 + sumEven;
        // 10의 배수 검사
        if (sum % 10 == 0) {
            return sumOdd + sumEven;
        } else {
            return 0;
        }
    }
}
