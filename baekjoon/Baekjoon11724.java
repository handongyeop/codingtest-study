package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11724 {

    private static int N, M;
    private static boolean[][] arr;
    private static boolean[] visit;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int cnt = 0;
        arr = new boolean[N + 1][N + 1];
        visit = new boolean[N + 1];

        for(int i = 1 ; i <= M ; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[u][v] = true;
            arr[v][u] = true;
        }

        for(int i = 1 ; i <= N ; i++) {
            if(!visit[i]) {
                dfs(i);
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    private static void dfs(int start) {
        visit[start] = true;

        for(int i = 1 ; i <= N ; i++) {
            if(arr[start][i] && !visit[i]) {
                dfs(i);
            }
        }
    }
}
