import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SnailArray {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int want = Integer.parseInt(bf.readLine());
        int[][] snailArr = new int[N][N];

        int num = 1;
        int x = N / 2, y = N / 2; 
        int steps = 1; 
        int wantX = 0, wantY = 0;

        while (num <= N * N) {
            // 위
            for (int i = 0; i < steps; i++) {
                if (x >= 0 && y >= 0 && x < N && y < N) {
                    snailArr[x][y] = num;
                    if (num == want) {
                    	wantX = x + 1;
                    	wantY = y + 1;
                    }
                }
                num++;
                x--;
            }

            // 오른쪽
            for (int i = 0; i < steps; i++) {
                if (x >= 0 && y >= 0 && x < N && y < N) {
                    snailArr[x][y] = num;
                    if (num == want) {
                    	wantX = x + 1;
                    	wantY = y + 1;
                    }
                }
                num++;
                y++;
            }

            steps++; 

            // 아래
            for (int i = 0; i < steps; i++) {
                if (x >= 0 && y >= 0 && x < N && y < N) {
                    snailArr[x][y] = num;
                    if (num == want) {
                    	wantX = x + 1;
                    	wantY = y + 1;
                    }
                }
                num++;
                x++;
            }

            // 왼쪽
            for (int i = 0; i < steps; i++) {
                if (x >= 0 && y >= 0 && x < N && y < N) {
                    snailArr[x][y] = num;
                    if (num == want) {
                    	wantX = x + 1;
                    	wantY = y + 1;
                    }
                }
                num++;
                y--;
            }

            steps++;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
        	for(int j = 0; j < N; j++) {
        		sb.append(snailArr[i][j]).append(" ");
        	}
        	sb.append("\n");
        }
        
        System.out.print(sb.toString());
        System.out.println(wantX + " " + wantY);
    }
}
