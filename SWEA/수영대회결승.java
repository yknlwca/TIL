import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int row, column, times;

	Point(int row, int column, int times) {
		this.row = row;
		this.column = column;
		this.times = times;
	}
}

public class 수영대회결승 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[][] board;
	static boolean[][] visited;
	static int N, A, B, C, D, minTime;
	static final int[] dr = { -1, 0, 1, 0 };
	static final int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(bf.readLine());

			board = new int[N][N];
			visited = new boolean[N][N];

			for (int i = 0; i < board.length; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < board[i].length; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			st = new StringTokenizer(bf.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(bf.readLine());
			C = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());

			minTime = -1;
//			dfs(A, B, 0);

			bw.write("#" + tc + " ");

			if (A == C && B == D) {
				bw.write("0");
			}
			if (bfs()) {
				bw.write(String.valueOf(minTime));
			} else if (!bfs()) {
				bw.write("-1");
			}

			bw.newLine();
		}
//		bw.flush();
		bw.close();
		bf.close();
	}

	static boolean bfs() {
		Queue<Point> que = new LinkedList<>();
		que.offer(new Point(A, B, 0));
		visited[A][B] = true;

		while (!que.isEmpty()) {
			Point curr = que.poll();
			
//			if (curr.row == C && curr.column == D) {
//				minTime = curr.times;
//				return true;
//			}

			for (int i = 0; i < dr.length; i++) {
				int nextRow = curr.row + dr[i];
				int nextColumn = curr.column + dc[i];

				if (0 > nextRow || nextRow >= board.length || 0 > nextColumn || nextColumn >= board[nextRow].length) {
					continue;
				}
				

//				System.out.println(nextRow + " " + nextColumn);
				if(nextRow == C && nextColumn == D) {
					minTime = curr.times + 1;
					return true;
				}
				

				if (board[nextRow][nextColumn] == 1 || visited[nextRow][nextColumn]) {
					continue;
				}

				if (board[nextRow][nextColumn] == 2) {
					if (curr.times % 3 == 2) {
						visited[nextRow][nextColumn] = true;
						que.offer(new Point(nextRow, nextColumn, curr.times + 1));
					} else {
//						visited[curr.row][curr.column] = true;
						que.offer(new Point(curr.row, curr.column, curr.times + 1));
					}
				} else {
					visited[nextRow][nextColumn] = true;
					que.offer(new Point(nextRow, nextColumn, curr.times + 1));
				}
			}
		}
		return false;
	}

//	static void dfs(int row, int column, int times) {
//		
//		// 범위 넘어감
//		if (0 > row || row >= board.length || 0 > column || column >= board[row].length) {
//			return;
//		}
//
//		// 방문했음 / 못가는 곳
//		if (visited[row][column] || board[row][column] == 1) {
//			return;
//		}
//
//		// 도착
//		if (row == C && column == D) {
//			minTime = Math.min(minTime, times);
//			return;
//		}
//
//		if (board[row][column] == 2) {
//			if (times % 3 != 2) {
//				dfs(row, column, times + 1);
//				return;
//			}
//		}
//
//		visited[row][column] = true;
//
//		for (int i = 0; i < dr.length; i++) {
//			int nextRow = row + dr[i];
//			int nextColumn = column + dc[i];
//			dfs(nextRow, nextColumn, times + 1);
//		}
//
//		visited[row][column] = false;
//
//	}
}
