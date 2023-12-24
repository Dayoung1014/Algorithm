import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		double[] socres = new double[N];
		double result = 0;
		double maxN = 0;
		for(int i=0; i<N; i++) {
			socres[i] = sc.nextDouble();
			if(maxN < socres[i]) {
				maxN = socres[i];
			}
		}
		for(int i=0; i<N; i++) {
			result += socres[i]/maxN*100;
		}
		System.out.println(result/N);
	}
}