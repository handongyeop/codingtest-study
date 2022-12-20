package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon11725 {
    private static int N;
    private static int[] parents;
    private static ArrayList<Integer>[] graph;
    private static boolean[] visit;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        parents = new int[N + 1];
        graph = new ArrayList[N + 1];
        visit = new boolean[N + 1];

        for(int i = 1 ; i <= N ; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(1);

        for(int i = 2 ; i <= N ; i++) {
            sb.append(parents[i]).append("\n");
        }

        System.out.println(sb);
    }
    private static void dfs(int start) {
        visit[start] = true;

        for(int i = 0 ; i < graph[start].size() ; i++) {
            int temp = graph[start].get(i);

            if(visit[temp] == false) {
                parents[temp] = start;
                dfs(temp);
            }
        }
    }
}
