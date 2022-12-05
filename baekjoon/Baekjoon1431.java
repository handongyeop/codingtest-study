package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon1431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];

        for(int i = 0 ; i<N ; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr,new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()){
                    if(getSum(o1) == getSum(o2)){
                        return o1.compareTo(o2);
                    }
                    else {
                        return getSum(o1) - getSum(o2);
                    }
                }else {
                    return o1.length() - o2.length();
                }
            }
        });

        for(String i: arr) {
            System.out.println(i);
        }


    }
    public static int getSum(String s) {
        int sum = 0;
        for(int i = 0 ; i < s.length() ; i++) {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                sum += s.charAt(i) - '0';
            }
        }
        return sum;
    }
}