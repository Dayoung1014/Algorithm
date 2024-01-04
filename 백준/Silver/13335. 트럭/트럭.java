import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //트럭의 수
        int w = Integer.parseInt(st.nextToken()); //다리 길이
        int l = Integer.parseInt(st.nextToken()); //다리 최대하중
        int[] cars = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cars[i] = Integer.parseInt(st.nextToken());
        }

        int time = 0; //시간
        int next = 0; //다음 트럭의 idx
        ArrayList<int[]> on = new ArrayList<>();//다리 위에 있는 트럭 무게, 건너는데 남은 단위시간
        int sum = 0; //다리 위에 있는 트럭의 무게 합

        while (true){
            if(on.isEmpty() && next>=cars.length) break;
            time++;
            for (int i = 0; i < on.size(); i++) {
                int[] now = on.get(i);
                now[1] -= 1;
                on.set(i, now);
            }
            if (!on.isEmpty() && on.get(0)[1] == 0) {
                sum -= on.get(0)[0];
                on.remove(0);
            }
            if(next<cars.length && sum + cars[next] <= l) {
                on.add(new int[]{cars[next],w});
                sum += cars[next];
                next++;
            }
        }
        System.out.println(time);
    }
}