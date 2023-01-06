package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon9663 {
    private static int cnt;
    private static int N;
    private static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        cnt = 0;
        arr = new int[N];

        dfs(0);

        System.out.println(cnt);
    }

    private static void dfs(int depth) {
        if(depth == N) {
            cnt++;
            return;
        }

        for(int i = 0 ; i < N ; i++) {
            arr[depth] = i;

            if(canPut(depth)) {
                dfs(depth + 1);
            }
        }
    }

    private static boolean canPut(int depth) {
        for(int i = 0 ; i < depth ; i++) {
            if(arr[depth] == arr[i]) {
                return false;
            } else if(Math.abs(depth - i) == Math.abs(arr[depth] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}
