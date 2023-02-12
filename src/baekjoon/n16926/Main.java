package baekjoon.n16926;

import java.util.Scanner;

public class Main {
    static int[][] arr;
    static int[] d1 = {1, 0, -1, 0}; //상하
    static int[] d2= {0, 1, 0, -1}; //좌우

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int R = sc.nextInt();
        int[][] arr = new int[N][M];
        for(int n=0; n<N; n++) {
            for(int m=0; m<M; m++) {
                arr[n][m] = sc.nextInt();
            }
        }
        int nowX = 0;
        int nowY = 0;
        int height = N;
        int width = M;

        int last = 0;
        for(int r=0; r<R; r++) { // 반시계 방향으로 R번 회전
            last = arr[nowX][nowY];
            // 왼 아래 오 위 -> 이렇게 4변을 순회
            // 테두리 순회를 총 몇 번? -> N,M중 작은 값의 / 2
            for(int rec=0; rec<Math.min(N, M)/2; rec++) {
                for(int h=1; h<=height-1; h++) { //왼
                    // 현재 값을 이동시킨 위치에 넣어줌
                    int tmp = last; // 다음 위치의 원래 값 저장
                    nowX += d1[0]; // 다음 위치로 이동
                    nowY += d2[0]; // 다음 위치로 이동
                    arr[nowX][nowY] = last; // 이동한 위치에 예전 위치의 값 저장
                    last = tmp; // last를 이동한 위치의 원래 값으로 갱신
                }
                for(int w=1; w<=width-1; w++) { //아래
                    int tmp = arr[nowX][nowY]; // 다음 위치의 원래 값 저장
                    nowX += d1[1]; // 다음 위치로 이동
                    nowY += d2[1]; // 다음 위치로 이동
                    arr[nowX][nowY] = last; // 이동한 위치에 예전 위치의 값 저장
                    last = tmp; // last를 이동한 위치의 원래 값으로 갱신
                }
                for(int h=1; h<=height-1; h++) { //왼
                    // 현재 값을 이동시킨 위치에 넣어줌
                    int tmp = arr[nowX][nowY]; // 다음 위치의 원래 값 저장
                    nowX += d1[2]; // 다음 위치로 이동
                    nowY += d2[2]; // 다음 위치로 이동
                    arr[nowX][nowY] = last; // 이동한 위치에 예전 위치의 값 저장
                    last = tmp; // last를 이동한 위치의 원래 값으로 갱신
                }
                for(int w=1; w<=width-1; w++) { //아래
                    int tmp = arr[nowX][nowY]; // 다음 위치의 원래 값 저장
                    nowX += d1[3]; // 다음 위치로 이동
                    nowY += d2[3]; // 다음 위치로 이동
                    arr[nowX][nowY] = last; // 이동한 위치에 예전 위치의 값 저장
                    //last = tmp; // last를 이동한 위치의 원래 값으로 갱신 // 마지막은 저장 안해도 됨
                }
                height -= 2;
                width -= 2;
                nowX += 1;
                nowY += 1;
            }
        }

        for(int n=0; n<N; n++) {
            for (int m = 0; m < M; m++) {
                System.out.print(arr[n][m] + " ");
            }
            System.out.println();
        }
    }


}
