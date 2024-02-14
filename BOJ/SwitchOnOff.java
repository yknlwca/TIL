import java.util.Scanner;

public class SwitchOnOff {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] switches = new int[N];
		for (int i = 0; i < N; i++) {
			switches[i] = sc.nextInt();
		}

		int personCount = sc.nextInt();

		for (int i = 0; i < personCount; i++) {
			int gender = sc.nextInt();
			int switchNumber = sc.nextInt();

			if (gender == 1) {
				for (int j = 1; j <= (switches.length / switchNumber); j++) {
					if (switches[(j * switchNumber) - 1] == 0) {
						switches[(j * switchNumber) - 1] = 1;
					} else {
						switches[(j * switchNumber) - 1] = 0;
					}
				}
			}
//			System.out.println(Arrays.toString(switches));

			if (gender == 2) {
				int index = switchNumber - 1;
				if (switches[index] == 0) {
					switches[index] = 1;
				} else {
					switches[index] = 0;
				}
				int left = switchNumber - 2;
				int right = switchNumber;
				while (left >= 0 && right < N && switches[left] == switches[right]) {
					if (switches[left] == 0) {
						switches[left] = 1;
						switches[right] = 1;
						left--;
						right++;
					} else {
						switches[left] = 0;
						switches[right] = 0;
						left--;
						right++;
					}
				}

			}
		}
//		System.out.println(Arrays.toString(switches));
		int cnt = 0;
		for (int i = 0; i < switches.length; i++) {
			System.out.print(switches[i] + " ");
			cnt++;
			if(cnt % 20 == 0) System.out.println();
		}
		sc.close();
	}
}