mport java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
 
public class Main {
 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
 
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			st = new StringTokenizer(br.readLine());
			long n = Long.parseLong(st.nextToken());
			long k = Long.parseLong(st.nextToken());
 
			if (n == 1 && n == k) {
				bw.write("YES\n");
				continue;
			}
 
			if (n % 2 == 1) {
				if (n <= k || k % 2 == 0) {
					bw.write("NO\n");
				} else {
					long r = (long) Math.sqrt(n);
					if (r < k) {
						bw.write("NO\n");
					} else {
						bw.write("YES\n");
					}
				}
			} else {
				if (n <= k || k % 2 == 1) {
					bw.write("NO\n");
				} else {
					long r = (long) Math.sqrt(n);
					if (r < k) {
						bw.write("NO\n");
					} else {
						bw.write("YES\n");
					}
				}
			}
		}
 
		bw.flush();
		bw.close();
		br.close();
	}
 
}
