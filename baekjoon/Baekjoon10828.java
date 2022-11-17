package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        // 스택형 인스턴스 선언
        Stack<String> pro = new Stack<String>();

        for (int i = 0 ; i < N ; i++) {
            String cmd[] = br.readLine().split(" ");
            if (cmd[0].equals("push")) {
                pro.push(cmd[1]);
            } else if (cmd[0].equals("pop")) {
                if (pro.empty()) {
                    sb.append("-1").append('\n');
                } else {
                    sb.append(pro.pop()).append('\n');
                }
            } else if (cmd[0].equals("size")) {
                sb.append(pro.size()).append('\n');
            } else if (cmd[0].equals("empty")) {
                if (pro.empty()) {
                    sb.append("1").append('\n');
                } else {
                    sb.append("0").append('\n');
                }
            } else if (cmd[0].equals("top")) {
                if (pro.empty()) {
                    sb.append("-1").append('\n');
                } else {
                    sb.append(pro.peek()).append('\n');;
                }
            }
        }
        System.out.println(sb);
    }
}