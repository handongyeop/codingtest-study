package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> pro = new ArrayDeque<Integer>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch (cmd) {
                case "push_front":
                    pro.addFirst(Integer.parseInt(st.nextToken()));
                    break;

                case "push_back":
                    pro.addLast(Integer.parseInt(st.nextToken()));
                    break;

                case "pop_front":
                    if (pro.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(pro.pollFirst()).append("\n");
                    break;

                case "pop_back":
                    if (pro.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(pro.pollLast()).append("\n");
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
                    else sb.append(pro.peekLast()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}

