package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1978 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int cnt = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());


        for (int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            boolean isPrime = true;

            if (arr[i] == 1) continue;

            for (int j = 2 ; j <= Math.sqrt(arr[i]) ; j++) {
                if (arr[i] % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) cnt++;
        }

        System.out.println(cnt);
    }
}

