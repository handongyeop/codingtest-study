package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon1197 {
    static int E, V, sum;
    static int[] parent;
    static List<node> list = new ArrayList();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        parent = new int[V + 1];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.add(new node(s,e,v));
        }

        // 1. 간선의 크기로 오름차순 정렬
        Collections.sort(list);

        int size = list.size();
        // 2. 정렬된 순서대로 간선 탐색
        for (int i = 0 ; i < size ; i++) {
            node n = list.get(i);
            // 만약 두 노드의 부모가 다르다면
            if(!isSameParent(n.s, n.e)) {
                // sum에 간선 크기 저장
                sum += n.v;
                // 두 노드 연결
                union(n.s, n.e);
            }

        }

        System.out.println(sum);
    }

    // 간선 연결
    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[b] = a;
        }
    }

    // 부모 노드 찾기
    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    // 부모가 같은지를 판별해주는 method
    private static boolean isSameParent(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b)
            return true;
        else
            return false;
    }

}

class node implements Comparable<node>{
    int s, e, v;

    public node(int s, int e, int v) {
        super();
        this.s = s;
        this.e = e;
        this.v = v;
    }

    // 간선의 크기로 오름차순하기 위한 compareTo()메서드
    @Override
    public int compareTo(node o) {
        return this.v - o.v;
    }

}
