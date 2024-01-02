import java.util.Scanner;
public class Main {
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