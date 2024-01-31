import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 18870
// 16236
public class CoordinateZip {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		String[] bornCoor = bf.readLine().split(" ");
		int[] coor = new int[N];
		for(int i = 0 ; i < coor.length; i++) {
			coor[i] = Integer.parseInt(bornCoor[i]);
		}
		
	}
}
