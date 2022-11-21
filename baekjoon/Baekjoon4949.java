package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        while(true) {
            String str = br.readLine();

            if (str.equals(".")) {
                break;
            }
            sb.append(check(str)).append("\n");
        }
        System.out.println(sb);
    }

    public static String check(String s) {
        Stack<Character> stk = new Stack<>();

        for (int i = 0 ; i < s.length() ; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[') {
                stk.push(c);
            } else if (c == ')') {
                if (stk.empty() || stk.peek() != '(') {
                    return "no";
                } else {
                    stk.pop();
                }
            } else if (c == ']') {
                if (stk.empty() || stk.peek() != '[') {
                    return "no";
                } else {
                    stk.pop();
                }
            }
        }
        if (!stk.empty()) return "no";
        else return "yes";
    }
}
