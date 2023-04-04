package solving.baekjoon;

/*
* N개의 컴퓨터로 이루어짐
* 하나 뚫으면 여러개 뚫을 수 있는 컴퓨터를 해킹하려 함
*
* A가 B를 신뢰하는 경우(단방향) B를 해킹시 A도 뚫을 수 있음
*
* 신뢰 관계가 주어졌을 때 한 번에 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터의 번호를 오름차순으로 출력
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1325_효율적인해킹 {
    static int N, M;
    static ArrayList<Integer>[] computers;
    static boolean[] v;
    static int[] result;

    static void dfs(int start, int now){
        v[now] = true;
        for(int next : computers[now]) {
            if(v[next]) continue;
            dfs(start, next);
            result[start]++;
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] v = new boolean[N+1];
        v[start] = true;
        q.add(start);

        while(!q.isEmpty()) {
            int n = q.poll();
            for(int next : computers[n]) {
                if(v[next]) continue;
                v[next] = true;
                q.offer(next);
                result[start]++;
            }
        }
    }

    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 컴퓨터의 개수
        M = Integer.parseInt(st.nextToken()); // 신뢰 관계 개수

        computers = new ArrayList[N+1]; //0번 비우고
        for (int i = 0; i < computers.length; i++) {
            computers[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            computers[end].add(start);
        }

        result = new int[N+1];
        for (int i = 1; i < computers.length; i++) {
            v = new boolean[N+1];
            //dfs(i, i); //시간초과
            bfs(i);
        }

        int max = 0;
        //System.out.println(Arrays.toString(result));
        for(int i=1; i<N+1; i++) {
            max = Math.max(max, result[i]);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<N+1;i++) {
            if(result[i] == max) {
                sb.append(i+" ");
            }
        }
        System.out.println(sb.toString());
    }
}
