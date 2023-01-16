package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon12100 {
    private static int n, answer, map[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        answer = 0;
        // n * n 크기의 게임판 생성
        map = new int[n][n];

        // 게임판에 숫자값 입력
        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        game(0);
        System.out.println(answer);
    }

    private static void game(int count) {
        if(count == 5) {
            findMax();
            return;
        }
        // 게임판 복사 저장
        int copy[][] = new int[n][n];
        for(int i = 0 ; i < n ; i++) {
            // 원본과 별개의 주소를 가진 배열 생성(깊은 복사)
            copy[i] = map[i].clone();
        }
        for(int i = 0 ; i < 4; i++) {
            // 상하좌우로 이동
            move(i);
            game(count + 1);
            for(int j = 0 ; j < n ; j++) {
                map[j] = copy[j].clone();
            }
        }
    }
    private static void move(int dir) {
        switch(dir) {
            // 윗쪽으로 이동
            case 0:
                for(int i = 0 ; i < n ; i++) {
                    // 값을 넣을 위치
                    int index = 0;
                    // 최근 블록의 수
                    int block = 0;
                    for(int j = 0 ; j < n ; j++) {
                        if(map[j][i] != 0) {
                            if(block == map[j][i]) {
                                map[index - 1][i] = block * 2;
                                block = 0;
                                map[j][i] = 0;
                            }
                            else {
                                block = map[j][i];
                                map[j][i] = 0;
                                map[index][i] = block;
                                index++;
                            }
                        }
                    }
                }
                break;
            // 아래쪽으로 이동
            case 1:
                for(int i = 0; i < n; i++) {
                    int index = n - 1;
                    int block = 0;
                    for(int j = n - 1; j >= 0; j--) {
                        if(map[j][i] != 0) {
                            if(block == map[j][i]) {
                                map[index + 1][i] = block * 2;
                                block = 0;
                                map[j][i] = 0;
                            }
                            else {
                                block = map[j][i];
                                map[j][i] = 0;
                                map[index][i] = block;
                                index--;
                            }
                        }
                    }
                }
                break;
            // 왼쪽으로 이동
            case 2:
                for(int i = 0; i < n; i++) {
                    int index = 0;
                    int block = 0;
                    for(int j = 0; j < n; j++) {
                        if(map[i][j] != 0) {
                            if(block == map[i][j]) {
                                map[i][index - 1] = block * 2;
                                block = 0;
                                map[i][j] = 0;
                            }
                            else {
                                block = map[i][j];
                                map[i][j] = 0;
                                map[i][index] = block;
                                index++;
                            }
                        }
                    }
                }
                break;
            // 오른쪽으로 이동
            case 3:
                for(int i = 0; i < n; i++) {
                    int index = n - 1;
                    int block = 0;
                    for(int j = n - 1; j >= 0; j--) {
                        if(map[i][j] != 0) {
                            if(block == map[i][j]) {
                                map[i][index + 1] = block * 2;
                                block = 0;
                                map[i][j] = 0;
                            }
                            else {
                                block = map[i][j];
                                map[i][j] = 0;
                                map[i][index] = block;
                                index--;
                            }
                        }
                    }
                }
                break;
        }
    }
    private static void findMax() {
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                answer = Math.max(answer, map[i][j]);
            }
        }
    }
}
