import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //리스트에 있는 점수 개수
        int score = Integer.parseInt(st.nextToken()); //새로운 점수
        int P = Integer.parseInt(st.nextToken()); //랭킹에 올라갈 수 있는 점수 개수
        int rank = 1;
        int[] list = new int[N];

        if(N==0) rank = 1;
        else {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                list[i] = Integer.parseInt(st.nextToken());
            }

            //랭킹에 진입하지 못하는 경우
            if(N==P && score <= list[N-1]) rank = -1;
            //랭킹에 진입 가능한 경우
            else {
                for (int i = 0; i < N; i++) {
                    if(score < list[i]) rank++;
                    else break;
                }
            }
        }

        System.out.println(rank); 
    }
}