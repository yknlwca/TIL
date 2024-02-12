package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RoomNumber {

    /*
     *  - 세트 수가 많아 지는 조건
     *      1. '6'과 '9'는 같이 처리
     *      2. 같은 수가 있을 때마다 ++;
     *
     *
     */
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] N = bf.readLine().toCharArray();
        int[] counts = new int[10];

        for (char number : N) {
            switch (number) {
                case '0':
                    counts[0]++;
                    break;
                case '1':
                    counts[1]++;
                    break;
                case '2':
                    counts[2]++;
                    break;
                case '3':
                    counts[3]++;
                    break;
                case '4':
                    counts[4]++;
                    break;
                case '5':
                    counts[5]++;
                    break;
                case '6':
                    counts[6]++;
                    break;
                case '7':
                    counts[7]++;
                    break;
                case '8':
                    counts[8]++;
                    break;
                case '9':
                    counts[9]++;
                    break;
            }

        }

        // 6과 9 함께 처리하기
        int sixNine = counts[6] + counts[9];
        counts[6] = counts[9] = (sixNine + 1) / 2;

        // 같은 수가 가장 많은 것 == 세트의 개수
        int sets = 0;
        for(int count : counts){
            sets = Math.max(sets, count);
        }

        System.out.println(sets);

    }
}

