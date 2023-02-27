package solving.baekjoon;

import java.util.Scanner;

/*
* 10 12 12
* 100 12 4
* 1000 12 4
* 10000 12 4
*
*
*
* 5 3 2
* 25 3 1
* 125 2
*A를 B번 곱한 수를 다 계산하지 말고 C로 나눈 나머지에서 A를 곱해줌 (어차피 나누어 떨어지는 부분은 동이랗기 때문에 잘라내고 감)
* */

public class Main_1629_곱셈 {
    static int A, B, C, result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();


        System.out.println(cur(A, B));
    }

    static long cur(int now, int count) {
        if (count == 0)
            return 1;

        long n = cur(now, count/2);
        if (count % 2 == 0)
            return n * n % C;
        else
            return (n * n % C) * now % C;
    }
}
