package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon1753 {
    private static ArrayList[] graph;
    private static int[] dist;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine()) - 1;

        graph = new ArrayList[V];
        dist = new int[V];

        for(int i = 0 ; i < V ; i++) {
            graph[i] = new ArrayList<Node>();
            dist[i] = Integer.MAX_VALUE;
        }

        for(int i = 0 ; i < E ; i++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
        }

        dijkstra(K);

        for(int i = 0 ; i < V ; i++){
            if(dist[i] == Integer.MAX_VALUE)
                sb.append("INF").append("\n");
            else
                sb.append(dist[i]).append("\n");
        }

        System.out.print(sb);
    }

    private static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            int len = graph[now.v].size();
            for(int i = 0; i < len ; i++){
                Node next = (Node)graph[now.v].get(i);

                if(dist[next.v]>now.w + next.w){
                    dist[next.v] = now.w + next.w;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }
    }
}

    class Node implements Comparable<Node>{
    int v, w;

    public Node(int v, int w){
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Node n){
        return this.w - n.w;
    }
}
