import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 치즈도둑 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[][] board;
	static boolean[][] visited;
	static int maxCnt;
	static final int[] dr = { -1, 0, 1, 0 };
	static final int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= T; tc++) {
			bw.write("#" + tc + " ");
			int N = Integer.parseInt(bf.readLine());
			board = new int[N][N];
			maxCnt = 0;

			for (int i = 0; i < board.length; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < board[i].length; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int day = 0; day <= 100; day++) {
				visited = new boolean[N][N];
				int today = 0;

				for (int row = 0; row < board.length; row++) {
					for (int column = 0; column < board[row].length; column++) {
						if (board[row][column] == day) {
							// 같은 날짜 치즈 먹음
							board[row][column] = 0;
						}
					}
				}

				for (int row = 0; row < board.length; row++) {
					for (int column = 0; column < board[row].length; column++) {
						if (board[row][column] != 0) {
							if (!visited[row][column]) {
								// 방문하지 않고 먹지 않은 곳
								bfs(row, column);
//								dfs(row, column);
								// 지나면 한 덩이 끝
								today++;
							}
						}
					}
				}
				maxCnt = Math.max(today, maxCnt);

			}

			bw.write(String.valueOf(maxCnt));
			bw.newLine();
			bw.flush();
		}

		bw.close();
		bf.close();
	}

	static void bfs(int row, int column) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] { row, column });
		visited[row][column] = true;

		while (!que.isEmpty()) {

			int[] curr = que.poll();
			for (int i = 0; i < dr.length; i++) {
				int nextRow = curr[0] + dr[i];
				int nextColumn = curr[1] + dc[i];
				if (0 <= nextRow && nextRow < board.length && 0 <= nextColumn && nextColumn < board.length) {
					// 아직 방문하지 않고 먹지 않았음
					if (!visited[nextRow][nextColumn]) {
						if (board[nextRow][nextColumn] != 0) {
							visited[nextRow][nextColumn] = true;
							que.add(new int[] { nextRow, nextColumn });
						}
					}
				}
			}
		}
	}

	static void dfs(int row, int column) {
		visited[row][column] = true;

		for (int i = 0; i < dr.length; i++) {
			int nextRow = row + dr[i];
			int nextColumn = column + dc[i];
			if (0 <= nextRow && nextRow < board.length && 0 <= nextColumn && nextColumn < board.length) {
				if(!visited[nextRow][nextColumn]) {
					if(board[nextRow][nextColumn] != 0) {
						dfs(nextRow, nextColumn);
					}
				}
			}
		}
	}
}
