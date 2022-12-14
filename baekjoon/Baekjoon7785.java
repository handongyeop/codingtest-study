package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon7785 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        HashSet<String> hs = new HashSet<>();

        for (int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String state = st.nextToken();

            if (state.equals("enter")) {
                hs.add(name);
            } else if (state.equals("leave")) {
                hs.remove(name);
            }
        }
        ArrayList<String> al = new ArrayList<>(hs);
        al.sort(Comparator.reverseOrder());

        for (String i : al) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}

