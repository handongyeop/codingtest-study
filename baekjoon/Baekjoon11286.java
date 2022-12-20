package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baekjoon11286 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        // 절댓값이 같은 경우 그 중에서 작은 값으로 오름차순 정렬하고, 아닌 경우 절댓값이 작은 순서로 오름차순 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) ->
                Math.abs(o1) == Math.abs(o2) ? Integer.compare(o1, o2) : Integer.compare(Math.abs(o1), Math.abs(o2))
        );


        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x == 0) {
                if(pq.isEmpty()) sb.append("0").append("\n");
                else sb.append(pq.poll()).append("\n");
            }else {
                pq.offer(x);
            }
        }
        System.out.println(sb);
    }
}