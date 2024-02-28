package swea;

// O(nlogn)
// pivot 정하기
// 아무거나 가능 중간 값이 좋긴함
// partitioning
// start , end 포인터
// start 는 pivot보다 작은 값을 무시하며 뒤로
// end 는 pivot보다 큰 값을 무시하며 앞으로
// 서로 지나지면 끝

import java.io.IOException;
import java.util.Scanner;

public class 퀵정렬구현 {
    static int[] arr;

    // 호어파티션
    // 초기 호출 메소드
    private static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }


    private static void quickSort(int[] arr, int start, int end) {
        int part2 = partition(arr, start, end);
        if (start < part2 - 1) {
            quickSort(arr, start, part2 - 1);
        }
        if (part2 < end) {
            quickSort(arr, part2, end);
        }
    }

    // pivot기준으로 두 부분으로 분할
    // 배열의 중간 값을 pivot으로 start는 pivot보다 작은 값을 무시하며 오른쪽으로
    // end는 pivot보다 큰 값을 무시하며 왼쪽으로 이동
    // start <= end 조건 하에서 start와 end의 값을 교환
    // start++ && end--
    // 분할이 완료되면 start위치를 반환. 다음 분할을 위한 시작점
    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[(start + end) / 2];
        while (start <= end) {
            while(arr[start] < pivot) start++;
            while(arr[end] > pivot) end--;
            if (start <= end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    // 스왑 메소드
    private static void swap(int[] arr, int start, int end) {
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
    }

// 출력 메서드 필요음슴
//    private static void printArray(int[] arr) {
//        for (int data : arr) {
//            System.out.print(data + " ");
//        }
//        System.out.println();
//    }



    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        arr = new int[1000000];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        quickSort(arr);
        System.out.println(arr[500000]);
    }
}