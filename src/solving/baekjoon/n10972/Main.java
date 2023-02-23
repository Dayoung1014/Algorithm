package solving.baekjoon.n10972;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nArr = new int[N];
        for(int i=1;i<=N;i++) {
            nArr[i] = i;
        }
        int[] arr = new int[N];
        for(int i =0; i<N; i++) {
            arr[i] = sc.nextInt();
        }

    }
}
