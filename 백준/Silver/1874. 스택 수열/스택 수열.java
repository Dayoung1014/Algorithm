import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] seq = new int[n]; //수열
        int next = 0;

        Stack<Integer> stack = new Stack<>();
        int cur = 1;

        boolean result = true;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(br.readLine());
        }

        while(next < seq.length) {
            //스택의 맨 위가 현재 수열 값보다 작은 경우, 해당 수열 값까지 숫자를 푸시
            while (cur <= seq[next]) {
                stack.push(cur++);
                sb.append("+\n");
            }
            //스택의 맨 위가 현재 수열 값과 같은 경우에만 팝
            if(stack.peek() == seq[next]) {
                stack.pop();
                next++;
                sb.append("-\n");
            }
            else {
                result = false;
                break;
            }
        }

        if(!result) System.out.println("NO");
        else System.out.println(sb);

    }
}