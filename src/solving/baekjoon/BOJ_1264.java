import java.io.*;

public class BOJ_1264 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt;
        StringBuilder sb = new StringBuilder();

        while(true){
            String line = br.readLine();
            if(line.charAt(0)=='#') break;
            line = line.toLowerCase();
            cnt = 0;
            for(int i=0; i<line.length(); i++) {
                char token = line.charAt(i);
                if(token == 'a'| token == 'e'|
                        token == 'i'| token == 'o'|
                        token == 'u') cnt++;
            }
            sb.append(cnt + "\n");
        }
        System.out.println(sb);
    }
}