import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			int n = sc.nextInt();
			BigInteger f[] = new BigInteger[n+1];
			f[0] = new BigInteger("1");
			if(n>0) f[1] = new BigInteger("1");
			for (int j = 2; j < f.length; j++) {
				BigInteger num1 =f[j-2].multiply(new BigInteger("2"));
				BigInteger num2 =f[j-1];
				f[j] = num1.add(num2);
			}
			System.out.println(f[n]);
		}
	}
}