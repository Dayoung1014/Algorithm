import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashSet<String> set =  new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }
        ArrayList<String> list = new ArrayList<>(set);
        Collections.sort(list, new wordCompare());
        StringBuilder sb = new StringBuilder();
        for(String l : list) sb.append(l+"\n");
        System.out.println(sb);
    } 
    static class wordCompare implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2); // 길이가 같으면 사전순으로 비교
            } else {
                return o1.length() - o2.length(); // 길이를 기준으로 비교
            }
        }
    } 
}