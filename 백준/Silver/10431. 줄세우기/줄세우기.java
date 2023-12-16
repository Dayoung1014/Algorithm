import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader; 
import java.util.LinkedList;
import java.util.StringTokenizer;
 
public class Main { 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int P = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int T=1; T<=P; T++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb.append(st.nextToken() + " ");

            LinkedList<Integer> list = new LinkedList<>();
            int cnt = 0;
            for(int h=0; h<20; h++)  {
                int now = Integer.parseInt(st.nextToken());
                if(h==0 || list.get(list.size()-1) < now) list.add(now);
                else {
                    for(int s=list.size()-1; s>=-1; s--) {
                        if(s==-1) {
                            list.add(0, now);
                            break;
                        }
                        if(list.get(s) > now) cnt++;
                        else {
                            list.add(s+1, now);
                            break;
                        }
                    }
                }
            }
            sb.append(cnt+"\n");
        }
        System.out.println(sb);
    }
}