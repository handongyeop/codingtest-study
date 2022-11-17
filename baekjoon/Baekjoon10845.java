package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue<Integer> pro = new LinkedList<Integer>();

        int N = Integer.parseInt(br.readLine());
        int last = 0;

        for (int i = 0 ; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch (cmd) {
                case "push":
                    last = Integer.parseInt(st.nextToken());
                    pro.add(last);
                    break;

                case "pop":
                    if (pro.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(pro.remove()).append("\n");
                    break;

                case "size":
                    sb.append(pro.size()).append("\n");
                    break;

                case "empty":
                    if (pro.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;

                case "front":
                    if (pro.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(pro.peek()).append("\n");
                    break;

                case "back":
                    if (pro.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(last).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}

