import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 불불 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int R, C, escapeTime;
	static char[][] board;
	static boolean[][] visited;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static Queue<int[]> personQue, fireQue;

	// # 벽 / . 공간 / J 초기위치 / F 불
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(bf.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		visited = new boolean[R][C];

		personQue = new LinkedList<>();
		fireQue = new LinkedList<>();

		for (int i = 0; i < board.length; i++) {
			String input = bf.readLine();
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = input.charAt(j);
			}
		}

//		for(char[] c : board) {
//			System.out.println(Arrays.toString(c));
//		}

		escapeTime = 0;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 'J') {
					personQue.offer(new int[] { i, j });
				} else if (board[i][j] == 'F') {
					fireQue.offer(new int[] { i, j });
				}
			}
		}

		if (bfs()) {
			bw.write(String.valueOf(escapeTime));
		} else {
			bw.write("IMPOSSIBLE");
		}
		bw.flush();
		bw.close();
		bf.close();
	}

	static boolean bfs() {
		while (!personQue.isEmpty()) {
			// 불을 먼저 퍼트리기
			int fireSize = fireQue.size();
			for (int f = 0; f < fireSize; f++) {
				int[] fireTmp = fireQue.poll();
				for (int i = 0; i < dr.length; i++) {
					int nextRow = fireTmp[0] + dr[i];
					int nextColumn = fireTmp[1] + dc[i];

					if (0 <= nextRow && nextRow < board.length && 0 <= nextColumn
							&& nextColumn < board[nextRow].length) {
						if (board[nextRow][nextColumn] == '.') {
							board[nextRow][nextColumn] = 'F';
							fireQue.offer(new int[] { nextRow, nextColumn });
						}
					}
				}
			}

			// 불 퍼트린 후 사람 이동
			int personSize = personQue.size();
			for (int p = 0; p < personSize; p++) {
				int[] personTmp = personQue.poll();
				int currRow = personTmp[0];
				int currColumn = personTmp[1];

				// 탈출 조건
				if (0 == currRow || currRow == (board.length - 1) || 0 == currColumn
						|| currColumn == (board[currRow].length - 1)) {
					// 1분 후 무조건 탈출
					escapeTime++;
					return true;
				}

				for (int i = 0; i < dr.length; i++) {
					int nextRow = currRow + dr[i];
					int nextColumn = currColumn + dc[i];

					if (0 <= nextRow && nextRow < board.length && 0 <= nextColumn
							&& nextColumn < board[nextRow].length) {
						if (board[nextRow][nextColumn] == '.') {
							if (!visited[nextRow][nextColumn]) {
								visited[nextRow][nextColumn] = true;
								personQue.offer(new int[] { nextRow, nextColumn });
							}
						}
					}
				}
			}
			// 여기가 한 턴 끝
			escapeTime++;
		}
		return false;
	}
}
