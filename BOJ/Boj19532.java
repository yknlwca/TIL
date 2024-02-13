import java.util.Scanner;

public class Boj19532 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt(), d = sc.nextInt(), e = sc.nextInt(), f = sc.nextInt();

		System.out.println(((c * e) - (f * b)) / ((a * e) - (d * b)) + " " + ((c * d) - (a * f)) / ((b * d) - (a * e)));
		sc.close();
	}
}
