import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Country implements Comparable<Country> {
        int num, a, b, c;
        public Country(int num, int a, int b, int c) {
            this.num = num;
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public int compareTo(Country other) {
            if(this.a!=other.a) return other.a -this.a;
            else if (this.b!=other.b) return other.b - this.b;
            return other.c - this.c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //국가의 수
        int K = Integer.parseInt(st.nextToken()); //등수를 알고 싶은 국가

        Country[] countries = new Country[N];
        for(int n=0; n<N; n++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            Country now = new Country(number, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            countries[n] = now;
        }

        Arrays.sort(countries);

        int rank = 1;
        int same = 1;

        for(int n=0; n<N; n++) {
            if(n>0) {
                if(countries[n].compareTo(countries[n-1])!=0) {
                    rank += same;
                    same = 1;
                }
                else same++;
            }
            if(countries[n].num == K) {
                System.out.println(rank);
                break;
            }
        }
    }
}