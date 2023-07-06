import java.io.*;
public class BOJ_2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        boolean[] arr = new boolean[10_000+1];
        int[] cnt = new int[10_000+1];
        for(int i=0; i<N; i++) {
            int now = Integer.parseInt(br.readLine());
            arr[now] = true;
            cnt[now]++;
        }
        for(int i=0; i<arr.length; i++) {
            if(arr[i]) {
                for(int j=0; j<cnt[i]; j++) {
                    sb.append(i).append('\n');
                }
            }
        }
        System.out.println(sb);
    }
}