import java.io.*;

public class BOJ_14916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        if(n%5==0) cnt = n/5;
        else {
            //2를 하나씩 빼면서 5로 나눌 수 있을 때 나감
            while (true) {
                n -= 2;
                cnt++;
                if(n%5==0) {
                    cnt += n/5;
                    break;
                }
                else if(n-2<0) {
                    cnt = -1;
                    break;
                }
            }
        }

        System.out.println(cnt);

    }
}