import java.util.Scanner; 

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        String line = "*".repeat(a) + "\n";
        String square = line.repeat(b);

        System.out.println(square); 
    }
}