import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		int cases = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= cases; t++) {
			int[][] dp = new int[51][1501];
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			for (int i = 0; i < n; i++) {
				String[] input = bf.readLine().split(" ");
				int sum = 0;
				dp[i+1] = Arrays.copyOf(dp[i], dp[0].length);
				for (int j = 0; j < k; j++) {
					sum += Integer.parseInt(input[j]);
					for (int l = 0; l + j + 1 <= p; l++) {
						dp[i+1][l+j+1] = Math.max(dp[i+1][l+j+1], dp[i][l] + sum);
					}
				}
			}
			out.println("Case #" + t + ": " + dp[n][p]);
		}
		out.flush();
    }
}
