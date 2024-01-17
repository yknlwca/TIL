import java.util.Scanner;

public class BuildingHeightCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt(); // 테스트 케이스의 수
        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            scanner.nextLine(); // 줄바꿈 문자 무시

            char[][] newtown = new char[N][N];
            for (int i = 0; i < N; i++) {
                newtown[i] = scanner.nextLine().replace(" ", "").toCharArray();
            }

            int maxHeight = 0;

            for (int row = 0; row < N; row++) {
                for (int column = 0; column < N; column++) {
                    if (newtown[row][column] == 'B') {
                        boolean hasG = false;
                        int height = 0;

                        for (int dr = -1; dr <= 1; dr++) {
                            for (int dc = -1; dc <= 1; dc++) {
                                int nr = row + dr;
                                int nc = column + dc;
                                if (0 <= nr && nr < N && 0 <= nc && nc < N && newtown[nr][nc] == 'G') {
                                    hasG = true;
                                    break;
                                }
                            }
                            if (hasG) break;
                        }

                        if (!hasG) {
                            for (int i = 0; i < N; i++) {
                                if (newtown[i][column] == 'B') height++;
                            }

                            for (int j = 0; j < N; j++) {
                                if (newtown[row][j] == 'B') height++;
                            }

                            height--; // 중복 제거
                        } else {
                            height = 2;
                        }

                        maxHeight = Math.max(maxHeight, height);
                    }
                }
            }

            System.out.println("#" + t + " " + maxHeight);
        }
        scanner.close();
    }
}
