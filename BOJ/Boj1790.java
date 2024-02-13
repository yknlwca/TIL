import java.util.Scanner;

public class Boj1790 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long k = sc.nextLong(); // k가 큰 값일 수 있으므로 long 타입 사용
        sc.close();

        long numLength = 0;
        long current = 1;
        long digit = 1;

        
        while (numLength + digit * 9 * current < k) {
            numLength += digit * 9 * current; // 1 2 3 4 5 6 쭉 연결
            current *= 10;
            digit++;
        }

        // k가 속하는 숫자 찾기
        long number = current + (k - numLength - 1) / digit;

        if (number > N) {
            System.out.println(-1);
        } else {
            String strNumber = Long.toString(number);
            long indexInNumber = (k - numLength - 1) % digit;
            System.out.println(strNumber.charAt((int) indexInNumber));
        }
    }
}