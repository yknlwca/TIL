import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 회의실배정 {
    static class meeting implements Comparable<meeting> {
        int start;
        int end;
        meeting(){}

        meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(meeting meeting) {
            if (this.end == meeting.end) {
                return this.start - meeting.end;
            }
            return this.end - meeting.end;
        }
    }

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(bf.readLine());
        meeting[] meet = new meeting[N];


        for (int i = 0; i < N; i++) {
            meet[i] = new meeting();
            StringTokenizer st = new StringTokenizer(bf.readLine());
            meet[i].start = Integer.parseInt(st.nextToken());
            meet[i].end = Integer.parseInt(st.nextToken());
        }

        // 끝나는 시간 기준 오름차순 정렬
        Arrays.sort(meet);
        int count = 0;
        int endTime = 0;

        // 바로 전 회의 종료시간이 다음 회의 시작 시간보다 작거나 같다면 가능
        // 이때 전 회의 종료시간 갱신
        // 회의 종료시간이 같은 회의가 여러개 일때....
        // 시작 시간 역시 오름차순으로 정렬 해줘야함
        for (int i = 0; i < N; i++) {
            if (endTime <= meet[i].start) {
                count++;
                endTime = meet[i].end;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        bf.close();
    }
}
