package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//학점 × 과목평점의 합을 학점의 총합으로 나눈 값
public class BOJ_25206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        float sum = 0;
        int cnt = 0;

        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            float score = Float.parseFloat(st.nextToken());
            String grade = st.nextToken();
            switch (grade) {
                case "A+":
                    sum += score*4.5;
                    cnt+=score;
                    break;
                case "A0":
                    sum += score*4.0;
                    cnt+=score;
                    break;
                case "B+":
                    sum += score*3.5;
                    cnt+=score;
                    break;
                case "B0":
                    sum += score*3.0;
                    cnt+=score;
                    break;
                case "C+":
                    sum += score*2.5;
                    cnt+=score;
                    break;
                case "C0":
                    sum += score*2.0;
                    cnt+=score;
                    break;
                case "D+":
                    sum += score*1.5;
                    cnt+=score;
                    break;
                case "D0":
                    sum += score*1.0;
                    cnt+=score;
                    break;
                case "F":
                    sum += score*0.0;
                    cnt+=score;
                    break;
            }
        }
        System.out.println(sum/cnt);
    }
}
