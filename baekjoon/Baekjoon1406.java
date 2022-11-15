package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        LinkedList<String> editer = new LinkedList<String>();
        String str[] = br.readLine().split("");

        for (String s : str) {
            editer.add(s);
        }

        ListIterator<String> iter = editer.listIterator(str.length);

        int m = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < m ; i++) {
            String command[] = br.readLine().split(" ");
            if (command[0].equals("P")) {
                iter.add(command[1]);
            } else if (command[0].equals("L")) {
                if (iter.hasPrevious()) {
                    iter.previous();
                } else {
                    continue;
                }
            } else if (command[0].equals("D")) {
                if (iter.hasNext()) {
                    iter.next();
                } else {
                    continue;
                }
            } else if (command[0].equals("B")) {
                if (iter.hasPrevious()) {
                    iter.previous();
                    iter.remove();
                } else {
                    continue;
                }
            }
        }

        System.out.println(String.join("", editer));
    }
}