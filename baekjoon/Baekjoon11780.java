package baekjoon;

import java.util.*;
import java.io.*;

public class Baekjoon11780 {
    public static final int INF = 1000000;
    public static final int NIL = -1;
    public static int N, M;
    public static int[][] dist;
    public static int[][] next;
    public static Stack<Integer> path;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        dist = new int[N + 1][N + 1];
        next = new int[N + 1][N + 1];

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                next[i][j] = NIL;
                if(i == j) continue;
                dist[i][j] = INF;
            }
        }

        M = Integer.parseInt(br.readLine());
        while (M > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            dist[u][v] = Math.min(dist[u][v], cost);
            next[u][v] = u;

            M--;
        }

        // 플로이드 와샬 알고리즘
        floydWarshall();

        // 정답출력
        printAnswer();
    }

    public static void floydWarshall() {
        // 중간에 거쳐가는 정점 (k)
        for(int k = 1; k <= N; k++) {
            // 출발 정점 (i)
            for(int i=1; i <= N; i++) {
                // 도착 정점 (j)
                for(int j=1; j <= N; j++) {
                    if(dist[i][j] > dist[i][k] + dist[k][j]) {
                        // 기존에 저장된 최단 거리와 정점 k를 거쳐가는 (i → k) + (k → j) 경로 중 최소값
                        dist[i][j] = dist[i][k] + dist[k][j];
                        // 중간 경로로 정점 k를 거쳐가도록 갱신
                        next[i][j] = next[k][j];
                    }
                }
            }
        }
    }

    public static void printAnswer() {
        StringBuilder sb = new StringBuilder();
        // 최단 거리 비용
        for(int i=1; i <= N; i++) {
            for(int j=1; j <= N; j++) {
                if(dist[i][j] >= INF) sb.append("0 ");
                else sb.append(dist[i][j] + " ");
            }
            sb.append("\n");
        }

        // 최단 거리 경로
        for(int i=1; i <= N; i++) {
            for(int j=1; j <= N; j++) {
                // i == j로 자기자신이거나 i → j 가는 경로가 전혀 없는 경우
                if(next[i][j] == NIL) sb.append("0\n");
                else {
                    path = new Stack<>();
                    int pre = j;
                    path.add(j); // 거쳐가는 정점
                    while(i != next[i][pre]) { // 도착 정점까지
                        pre = next[i][pre];
                        path.push(pre);
                    }
                    // 최단 거리 경로 크기 (출발 정점까지 포함)
                    sb.append(path.size()+1 + " ");
                    sb.append(i + " ");
                    while(!path.empty()) {
                        sb.append(path.pop() + " ");
                    }
                    sb.append("\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}
