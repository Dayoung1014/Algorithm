import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader; 

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N+1][N+1];
        int[] heartPos = new int[2];
        int[] arm = new int[2];
        int[] leg = new int[2];
        int waist = 0;

        boolean findHead = false;
        boolean findWaist = false;
        boolean findLeg = false;

        for (int i = 1; i < N+1; i++) {
            String str = br.readLine();
            int cnt = 0;
            for (int j = 1; j < N+1; j++) {
                map[i][j] = str.charAt(j-1);
                if(map[i][j]=='*') cnt++;

                // 머리 위치를 통해 심장 위치 구하기
                if(!findHead && map[i][j]=='*') {
                    heartPos[0] = i+1; heartPos[1] = j;
                    findHead = true;
                }

                // 심장 양 옆에 있는 팔의 길이 구하기
                if(i==heartPos[0] && map[i][j]=='*') {
                    if(j < heartPos[1]) arm[0]++;
                    else if(j > heartPos[1]) arm[1]++;
                }

                // 다리 길이 구하기
                if(findLeg && map[i][j]=='*'){
                    if(j==heartPos[1]-1) leg[0]++;
                    else if(j==heartPos[1]+1) leg[1]++;
                }
            }
            // 허리 길이 구하기
            if(!findWaist && i>heartPos[0] && cnt==1) waist++;
            // 허리 종료, 다리 시작 위치 구하기
            else if(!findLeg && i>heartPos[0] && cnt==2) {
                leg[0] = 1; leg[1] = 1;
                findWaist = true;
                findLeg = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(heartPos[0] + " " + heartPos[1]+"\n");
        sb.append(arm[0] + " " +arm[1] + " " + waist + " " + leg[0] + " " + leg[1]);
        System.out.println(sb);
    }
}