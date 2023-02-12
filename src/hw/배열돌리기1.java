package hw;

import java.util.*;
import java.io.*;

public class 배열돌리기1 {

    static int N, M, R;
    static int min;
    static int[][] map;

    static int[] dx = {0, 1, 0, -1}; // 왼쪽으로 넣는, 위로 넣는, 오른쪽으로 넣는, 아래로 넣는
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 행 크기
        M = Integer.parseInt(st.nextToken()); // 열 크기
        R = Integer.parseInt(st.nextToken()); // 회전 횟수

        map = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        min = Math.min(N, M); // 행, 열 중 더 작은 것 구함

        for(int i=1; i<=R; i++) { // 회전 횟수만큼 회전시킴
            rotate();
        }

        // 결과 출력
        print();
    }

    // 회전 시키는 메소드
    static void rotate() {

        for(int t=0; t<min/2; t++) { // 회전 시킬 그룹의 갯수 구하기
            int x = t;
            int y = t;

            int temp = map[x][y]; // 마지막에 넣을 값 미리 빼놓음

            int idx = 0; // 우, 하, 좌, 상 방향으로 이동하며 반시계 방향으로 값 넣을 인덱스
            while(idx < 4) { // 왼쪽으로 넣는, 위로 넣는, 오른쪽으로 넣는, 아래로 넣는 연산을 차례로 수행
                int nx = x + dx[idx];
                int ny = y + dy[idx];

                // 범위 안이라면
                if(nx < N-t && ny < M-t && nx >= t && ny >= t) {
                    map[x][y] = map[nx][ny];
                    x = nx;
                    y = ny;
                }
                // 범위를 벗어났다면 다음 방향으로 어감
                else {
                    idx++;
                }

            }

            map[t+1][t] = temp; // 빼 놓은 값 넣어 줌
        }

    }

    // 출력 함수
    static void print() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}