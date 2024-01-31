import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TemperatureSum {
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] inputNums = bf.readLine().split(" ");
		int N = Integer.parseInt(inputNums[0]);
		int M = Integer.parseInt(inputNums[1]);
		int[] tempArr = new int[N];
		String[] temps = bf.readLine().split(" ");
		
		for(int i = 0; i < N ; i++) {
			tempArr[i] = Integer.parseInt(temps[i]);
		}
		
		int maxSum = Integer.MIN_VALUE;
		int currentSum = 0;
		
		for(int i = 0; i < M; i++) {
			currentSum += tempArr[i];
		}
		maxSum = currentSum;
		
		for(int i = M; i < N; i++) {
			currentSum += tempArr[i] - tempArr[i - M];
			maxSum = Math.max(maxSum, currentSum);
		}
		System.out.println(maxSum);
	}
}