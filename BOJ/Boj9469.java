import java.util.Scanner;

public class Boj9469 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		for(int i = 0 ; i < tc; i ++) {
			int N = sc.nextInt();
			double D = sc.nextDouble();
			double A = sc.nextDouble();
			double B = sc.nextDouble();
			double F = sc.nextDouble();
			
			double time = D / (A + B);
			double flyDis = F * time;
			
			System.out.printf("%d %.6f\n", N, flyDis);
		}
		sc.close();
	}
}

