package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon2178 {
    private static int N, M;
    private static int[][] map;
    private static boolean[][] visit;
    private static int dx[] = new int[]{1, 0, -1, 0};
    private static int dy[] = new int[]{0, 1, 0, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0 ; i < N ; i++) {
            String s = br.readLine();
            for (int j = 0 ; j < M ; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        visit[0][0] = true;
        bfs(0, 0);

        System.out.println(map[N-1][M-1]);
    }
    public static void bfs(int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));

        while(!q.isEmpty()) {
            Pair p = q.poll();

            for(int i=0; i<4; i++) {
                int n_x = p.x + dx[i];
                int n_y = p.y + dy[i];

                if (n_x < 0 || n_y < 0 || n_x >= N || n_y >= M)
                    continue;
                if (visit[n_x][n_y] || map[n_x][n_y] == 0)
                    continue;

                q.add(new Pair(n_x, n_y));
                map[n_x][n_y] = map[p.x][p.y] + 1;
                visit[n_x][n_y] = true;
            }
        }
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
