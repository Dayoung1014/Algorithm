package solving.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution_3289_서로소집합 
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int arr[];
    static int N, M;

    public static void main(String args[]) throws Exception
    {

        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            arr = new int[N+1];

            // make
            for(int i=1; i<N+1; i++) {
                arr[i] = i;
            }

            System.out.print("#"+test_case+" ");
            for(int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int oper = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());


                if(oper == 1) { // 합집합이 아니라면
                    if(equal(find_set(a), find_set(b))) System.out.print(1);
                    else System.out.print(0);
                }
                else { // 합집합이라면
                    union_set(a, b);
                }
            }
            System.out.println();
        }
    }

    // find_set
    public static int find_set(int a) {
        if (arr[a] == a)
            return a;

        return arr[a] = find_set(arr[a]);
    }

    // union_set
    public static boolean union_set(int a, int b) {
        int aRoot = find_set(a);
        int bRoot = find_set(b);

        if (aRoot == bRoot)
            return false;

        arr[bRoot] = aRoot;
        return true;
    }

    //같은지
    public static boolean equal(int a, int b) {
        if(a==b) return true;
        else return false;
    }
}
