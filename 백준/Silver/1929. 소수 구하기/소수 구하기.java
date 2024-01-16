import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] notPrime;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());


        notPrime = new boolean[N+1];
        getPrime();
        StringBuilder sb = new StringBuilder();
        for (int i = M; i <= N ; i++) {
            if(!notPrime[i]) sb.append(i+"\n");
        }
        System.out.println(sb);
    }
    static void getPrime() {
        notPrime[0] = notPrime[1] = true;

        for (int i = 2; i <=Math.sqrt(notPrime.length) ; i++) {
            for(int j = 2; j<=N/i; j++) {
                if(notPrime[i*j]==true) continue;
                else notPrime[i*j] = true;
            }
        }
    }
}