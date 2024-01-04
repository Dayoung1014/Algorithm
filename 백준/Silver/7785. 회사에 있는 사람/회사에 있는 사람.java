import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            if(set.contains(name)) set.remove(name);
            else set.add(name);
        }
        List<String> list = set.stream().collect(Collectors.toList());
        list.sort(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(String s : list) sb.append(s+"\n");
        System.out.println(sb);
    }
}