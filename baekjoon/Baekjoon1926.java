package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon1926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 배열 선언
        int arr[][] = new int[n][m];
        // 중복 방지
        boolean visit[][] = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        int cnt = 0;
        int area;
        int max = 0;
        int dx[] = new int[]{1, 0, -1, 0};
        int dy[] = new int[]{0, 1, 0, -1};

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
                cnt++;    // 시작점 인식, 그림의 개수 카운팅
                q.offer(new Pair(i, j));   // 큐에 좌표를 넣어준다.
                visit[i][j] = true;     // 중복 처리!
                area = 0;    // 넓이 초기화
                while(!q.isEmpty()){
                    Pair p = q.poll();
                    area++; // 넓이 +1
                    for(int k = 0; k < 4; k++){
                        int n_x = p.x + dx[k];
                        int n_y = p.y + dy[k];
                        // 새 좌표가 0보다 작거나 배열을 넘어갈 경우
                        if(n_x < 0 || n_x >= n || n_y < 0 || n_y >= m){
                            continue;
                        }
                        // 배열에 해당 좌표가 1이면서 방문한 적이 없는 경우
                        if(arr[n_x][n_y] == 1 && !visit[n_x][n_y]){
                            q.offer(new Pair(n_x, n_y));
                            visit[n_x][n_y] = true;
                        }
                    }
                }
                if(area > max){
                    max = area;
                }
            }
        }
        System.out.println(cnt);
        System.out.println(max);
    }
    public static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
