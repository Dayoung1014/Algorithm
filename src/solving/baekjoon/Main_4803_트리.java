package solving.baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
* 테스트케이스 : https://www.acmicpc.net/board/view/107169
* */

public class Main_4803_트리 {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/upload.acmicpc.net.txt"));
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

            boolean[] v = new boolean[n+1];
            int tree = 0;
            out:
            for (int i = 1; i < graph.length; i++) {
                boolean circle = false;
                if(v[i]) {
                    //System.out.println(i+" 이미 방문함");
                    continue ;
                }
                if(graph[i].size()==0) {
                    //System.out.println("혼자 존재함");
                    tree++;
                    continue ;
                }

                Queue<Integer> q = new LinkedList<>();

                v[i] = true;
                q.add(i);

                ArrayList<Integer> tmp = new ArrayList<>();
                while(!q.isEmpty()) {
                    int now = q.poll();
                    //System.out.println(now + " "+tree);
                    for(int next : graph[now]) {
                        //System.out.println(now + "의 연결된 것들 방문" + next);
                        if(v[next]) {
                            //System.out.println("사이클 생성");
                            circle = true;
                        }
                        else {
                            v[next] = true;
                            q.add(next);
                        }
                    }

/*                    if(!circle) {
                        tree++;
                        for(int next : graph[now]) {
                            v[next] = true;
                            q.add(next);
                        }
                    }
                    else {
                        for(int next : graph[now]) {
                            v[next] = true;
                        }
                    }*/
                }

                if(!circle) tree++;

            }


            System.out.print("Case "+test_case+": ");
            if(tree > 1) System.out.println("A forest of " + tree + " trees.");
            else if(tree == 1) System.out.println("There is one tree.");
            else System.out.println("No trees.");

        }

    }
}
