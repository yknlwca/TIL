import java.util.Scanner;

public class Boj10808 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char[] s = sc.nextLine().toCharArray(); // 문자 배열로 입력 받기
        int[] arr = new int[26]; // 알파벳 빈도 수를 담을 배열 생성

        for(char alpha : s){    // 아스키 코드 이용    'a' = 97 부터 'z' 122?였나
            arr[alpha - 'a']++;  // 97을 뺴주어서 'a'~'z'는 0 ~ 25 인덱스에 카운트
        }

        for(int num : arr){
            System.out.print(num + " ");
        }
    }
}
