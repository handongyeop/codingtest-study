package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());
        long ans = pow(A, B, C);

        System.out.println(ans);
    }
    private static long pow(long base, long expo, long mod) {
        // 지수가 1이면 그대로 리턴
        if (expo == 1) {
            return base % mod;
        }
        
        // 지수가 너무 클 경우 long으로도 출력이 안되니 반으로 나눠줌
        long temp = pow(base, expo / 2, mod);

        // 지수가 홀수일 경우 밑을 한번 더 곱해줌
        if (expo % 2 == 1) {
            return (temp * temp % mod) * base % mod;
        }

        return temp * temp % mod;

    }
}
