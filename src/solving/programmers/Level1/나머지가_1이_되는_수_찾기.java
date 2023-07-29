package solving.programmers.Level1;

public class 나머지가_1이_되는_수_찾기 {
    public int solution(int n) {
        int res = 0;
        for(int i=1; i<n; i++) {
            if(n%i==1) {
                res = i;
                break;
            }
        }
        return res;
    }
}
