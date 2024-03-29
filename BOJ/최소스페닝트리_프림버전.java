import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 최소스페닝트리_프림버전 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int[][] adjArr = new int[V + 1][V + 1];
        for (int i = 1; i <= V; i++) {
            Arrays.fill(adjArr[i], INF);
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adjArr[a][b] = adjArr[b][a] = w;
        }

        boolean[] visited = new boolean[V + 1];
        int[] distance = new int[V + 1];
        Arrays.fill(distance, INF);
        distance[1] = 0;

        int answer = 0;
        for (int i = 1; i <= V; i++) {
            int min = INF, idx = -1;
            for (int j = 1; j <= V; j++) {
                if (!visited[j] && distance[j] < min) {
                    min = distance[j];
                    idx = j;
                }
            }
            
            if (idx == -1) break; // 모든 정점이 연결되지 않은 경우

            visited[idx] = true;
            answer += min;

            for (int j = 1; j <= V; j++) {
                if (!visited[j] && adjArr[idx][j] != 0 && adjArr[idx][j] < distance[j]) {
                    distance[j] = adjArr[idx][j];
                }
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        bf.close();
    }
}
