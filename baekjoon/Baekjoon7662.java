package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon7662 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 테스트케이스 개수
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> que = new TreeMap<>();

            // 한 케이스당 몇번 반복할 지 결정
            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char cmd = st.nextToken().charAt(0);
                int n = Integer.parseInt(st.nextToken());

                // cmd가 I면 que의 키 n에 기본값 +1
                if (cmd == 'I') {
                    que.put(n, que.getOrDefault(n, 0) + 1);

                } else {
                    // cmd가 I면 que의 키 n에 기본값 +1
                    if (que.size() == 0) continue;


                    // 정수 n이 1이면 최댓값, -1면 최솟값 num에 설정
                    int num = n == 1 ? que.lastKey() : que.firstKey();
                    // cmd가 I면 que의 키 num 에 기본값 -1
                    // num의 value가 1이면 remove()
                    que.put(num, que.get(num) - 1);
                    if (que.get(num) == 0) que.remove(num);
                }
            }

            System.out.println(que.size() == 0 ? "EMPTY" : que.lastKey() + " " + que.firstKey());
        }
    }
}