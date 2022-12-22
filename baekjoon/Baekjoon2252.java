package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon2252 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] indegree = new int[N+1];
        ArrayList<Integer>[] list = new ArrayList[N+1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            list[A].add(B);
            indegree[B]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1 ; i <= N ; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        while(!q.isEmpty()) {
            int num = q.poll();

            bw.write(num+" ");

            for(int i = 0 ; i < list[num].size() ; i++){
                int next = list[num].get(i);
                indegree[next]--;
                if(indegree[next] == 0){
                    q.add(next);
                }
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
