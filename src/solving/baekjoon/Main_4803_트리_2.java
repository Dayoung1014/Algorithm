package solving.baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
* 테스트케이스 : https://www.acmicpc.net/board/view/107169
* */

public class Main_4803_트리_2 {
    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/upload.acmicpc.net.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int test_case = 0;
        while(true) {
            test_case++;
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if(n==0 && m==0) break;
            ArrayList<Integer>[] graph = new ArrayList[n+1];
            for (int i = 0; i < graph.length; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                 graph[s].add(e);
                 //graph[e].add(s);
            }

            //사이클이 존재하지 않는가


        }

    }
}
