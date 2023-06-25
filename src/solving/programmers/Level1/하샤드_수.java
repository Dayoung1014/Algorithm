package solving.programmers.Level1;

public class 하샤드_수 {
    public boolean solution(int x) {
        String[] arr = Integer.toString(x).split("");
        int sum=0;
        for(String s : arr) {
            sum += Integer.parseInt(s);
        }
        return x%sum==0;
    }
}
