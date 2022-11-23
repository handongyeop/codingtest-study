package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon1926_dfs {
    // 배열 선언
    private static int arr[][];
    // 중복 방지
    private static boolean visit[][];
    // 그림 넓이
    private static int area;
    // 그림 수
    private static int cnt = 0;
    // 최대 그림 넓이
    private static int max = 0;
    // 상하좌우 확인 좌표
    private static int dx[] = new int[]{1, 0, -1, 0};
    private static int dy[] = new int[]{0, 1, 0, -1};
    private static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visit = new boolean[n][m];

        // 배열 세팅
        for(int i = 0 ; i < n ; i++ ) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < m ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ; j++) {
                if (arr[i][j] == 0 || visit[i][j]) {
                    continue;
                }
                area = 1;    // 넓이 초기화
                cnt++;    // 시작점 인식, 그림의 개수 카운팅
                dfs(i, j);
                if(area > max){
                    max = area;
                }
            }
        }
        System.out.println(cnt);
        System.out.println(max);
    }
    private static void dfs(int x, int y) {
        visit[x][y] = true;
        for(int k = 0; k < 4; k++){
            int n_x = x + dx[k];
            int n_y = y + dy[k];
            // 새 좌표가 0보다 작거나 배열을 넘어갈 경우
            if(n_x < 0 || n_x >= n || n_y < 0 || n_y >= m){
                continue;
            }
            // 배열에 해당 좌표가 1이면서 방문한 적이 없는 경우
            if(arr[n_x][n_y] == 1 && !visit[n_x][n_y]){
                area++; // 넓이 +1
                dfs(n_x, n_y);
            }
        }
    }
}
