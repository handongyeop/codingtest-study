package baekjoon;

import java.io.*;

public class Baekjoon10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[26];  //알파벳 개수를 저장하는 배열
        String str = br.readLine();  //단어 입력받기
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            arr[c - 97]++;  //개수 1씩 늘려주기
        }
        for (int i = 0; i < 26; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}