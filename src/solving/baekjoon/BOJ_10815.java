import java.io.*;
import java.util.*;

public class BOJ_10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //숫자 카드의 개수
        boolean[] arr = new boolean[10_000_000*2 + 1]; //소지 유무 저장
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            arr[Integer.parseInt(st.nextToken())+10_000_000] = true;
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++) {
            if(arr[Integer.parseInt(st.nextToken()) + 10_000_000]) sb.append(1 + " ");
            else sb.append(0 + " ");
        }
        System.out.println(sb);

    }
}