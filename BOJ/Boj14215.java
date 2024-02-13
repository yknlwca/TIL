import java.util.Arrays;
import java.util.Scanner;

public class Boj14215 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] arr = new int[3];
		for (int i = 0; i < 3; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);

		int sum = 0;

		if (arr[2] < arr[0] + arr[1]) {
			sum = arr[2] + arr[1] + arr[0];
		} else {
			sum = (arr[0] + arr[1]) * 2 - 1;
		}
		System.out.println(sum);

	}
}
