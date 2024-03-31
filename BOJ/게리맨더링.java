import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 게리맨더링 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<Integer>[] adjacent;
    static int[] population;
    static int totalPopulation, N, minPop;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(bf.readLine()) + 1;
        adjacent = new ArrayList[N];
        population = new int[N];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 1; i < N; i++) {
            int people = Integer.parseInt(st.nextToken());
            population[i] = people;
            totalPopulation += people;
            adjacent[i] = new ArrayList<>();
        }
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                int node = Integer.parseInt(st.nextToken());
                adjacent[i].add(node);
                adjacent[node].add(i);
            }
        }

        minPop = totalPopulation;

        check(1, new boolean[N + 1]);
        if (minPop == totalPopulation) {
            bw.write(String.valueOf(-1));
        } else {
            bw.write(String.valueOf(minPop));
        }
        bw.flush();
        bw.close();
        bf.close();
    }

    static void check(int cnt, boolean[] Selected) {
        if (cnt == N) {
            boolean[] visited = new boolean[cnt];
            int checker = 0;
            for (int i = 1; i < cnt; i++) {
                if (!visited[i]) {
                    dfs(i, visited, Selected);
                    checker++;
                }
            }
            if (checker == 2) {
                int sum1 = 0;
                int sum2 = 0;
                for (int i = 0; i < cnt; i++) {
                    if (Selected[i]) {
                        sum1 += population[i];
                    } else {
                        sum2 += population[i];
                    }
                }
                int diff = Math.abs(sum1 - sum2);
                minPop = Math.min(minPop, diff);
            }
            return;
        }

        Selected[cnt] = true;
        check(cnt + 1, Selected);
        Selected[cnt] = false;
        check(cnt + 1, Selected);
    }

    static void dfs(int idx, boolean[] visited, boolean[] Selected) {
        if (idx > N) {
            return;
        }

        visited[idx] = true;
        for (int next : adjacent[idx]) {
            if (!visited[next] && Selected[next] == Selected[idx]) {
                dfs(next, visited, Selected);
            }
        }
    }
}
