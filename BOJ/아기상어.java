import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 아기상어 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static final int[] dr = { -1, 0, 1, 0 };
	static final int[] dc = { 0, 1, 0, -1 };
	static int N, ateFish, sharkRow, answer, sharkColumn, minRow, minColumn, minDistance;
	static int shark = 2;
	static int[][] board, check;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(bf.readLine());
		board = new int[N][N];
		check = new int[N][N];

		for (int i = 0; i < board.length; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 9) {
					sharkRow = i;
					sharkColumn = j;
					board[i][j] = 0;
				}
			}
		}

		ateFish = 0;
		answer = 0;
		while (true) {
			// 변수 배열 초기화
			initCheck();

			// 상어 위치
			bfs(sharkRow, sharkColumn);

			if (minRow != Integer.MAX_VALUE && minColumn != Integer.MAX_VALUE) {

				answer += check[minRow][minColumn];

				ateFish++;

				// 상어 몸집 키우기
				if (ateFish == shark) {
					shark++;
					ateFish = 0;
				}

				// 물고기 잡아먹힘
				board[minRow][minColumn] = 0;

				// 먹은 자리 상어 자리로 바꾸기
				sharkRow = minRow;
				sharkColumn = minColumn;

			} else {
				break;
			}
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
		bf.close();
	}

	// check 배열 초기화
	static void initCheck() {
		minDistance = Integer.MAX_VALUE;
		minRow = Integer.MAX_VALUE;
		minColumn = Integer.MAX_VALUE;

		for (int i = 0; i < check.length; i++) {
			for (int j = 0; j < check.length; j++) {
				check[i][j] = -1;
			}
		}
	}

	static void bfs(int row, int column) {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] { row, column });
		check[row][column] = 0;

		while (!que.isEmpty()) {
			int[] tmp = que.poll();
			int currRow = tmp[0];
			int currColumn = tmp[1];

			for (int i = 0; i < dr.length; i++) {
				int nextRow = currRow + dr[i];
				int nextColumn = currColumn + dc[i];

				// 범위 밖이면 다음
				if (0 > nextRow || nextRow >= board.length || 0 > nextColumn || nextColumn >= board[nextRow].length) {
					continue;
				}

				// 방문 했거나 상어보다 크기가 크다면 통과
				if (check[nextRow][nextColumn] != -1 || board[nextRow][nextColumn] > shark) {
					continue;
				}

				check[nextRow][nextColumn] = check[currRow][currColumn] + 1;

				// 물고기가 있고 몸집이 상어 보다 작다면
				if (board[nextRow][nextColumn] != 0 && board[nextRow][nextColumn] < shark) {
					// 최단 거리 물고기 위치로 갱신 해주기
					if (minDistance > check[nextRow][nextColumn]) {
						minRow = nextRow;
						minColumn = nextColumn;
						minDistance = check[nextRow][nextColumn];
					}
					// 거리가 같다면 가장 위 -> 가장 왼쪽
					else if (minDistance == check[nextRow][nextColumn]) {
						// 같은 행일때 가장 왼쪽으로 선택
						if (minRow == nextRow) {
							if (minColumn > nextColumn) {
								minRow = nextRow;
								minColumn = nextColumn;
							}
						}
						// 가장 위쪽으로 선택
						else if (minRow > nextRow) {
							minRow = nextRow;
							minColumn = nextColumn;
						}
					}
				}
				// 조건에 맞는 물고기의 위치
				que.offer(new int[] { nextRow, nextColumn });
			}
		}
	}
}
