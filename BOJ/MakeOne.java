import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MakeOne {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());
        int[] dpX = new int[X + 1];
        int[] howMake = new int[X + 1];

        for (int i = 2; i <= X; i++) {
            dpX[i] = dpX[i - 1] + 1;
            howMake[i] = i - 1;

            if (i % 2 == 0 && dpX[i] > dpX[i / 2] + 1) {
                dpX[i] = dpX[i / 2] + 1;
                howMake[i] = i / 2;
            }
            if (i % 3 == 0 && dpX[i] > dpX[i / 3] + 1) {
                dpX[i] = dpX[i / 3] + 1;
                howMake[i] = i / 3;
            }
        }
        System.out.println(dpX[X]);

        ArrayList<Integer> lst = new ArrayList<>();
        for (int i = X; i != 0; i = howMake[i]) {
            lst.add(i);
        }
        

        for(int i = 0 ; i < lst.size() ; i++) {
        	System.out.print(lst.get(i));
        	if(i < lst.size() - 1) {
        		System.out.print(" ");
        	}
        }
    }
}
