import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
 
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); // 왼쪽
			int b = Integer.parseInt(st.nextToken()); // 오른쪽
			int c = Integer.parseInt(st.nextToken()); // 아래
			int d = Integer.parseInt(st.nextToken()); // 위
 
			if (a == 0 && b == 0 && c == 0 && d == 0) {
				bw.write("YES\n");
				continue;
			}
 
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
 
			if (x == x1 && x == x2) {
				if (!(a == 0 && b == 0)) {
					bw.write("NO\n");
					continue;
				}
			}
 
			if (y == y1 && y == y2) {
				if (!(c == 0 && d == 0)) {
					bw.write("NO\n");
					continue;
				}
			}
 
			int dif_row = 0;
			int dif_col = 0;
 
			if (a > b) { // 왼쪽이 오른쪽보다 더 많이 가야하는 경우
				dif_col = a - b;
 
				if (x - dif_col < x1) {
					bw.write("NO\n");
					continue;
				}
			} else { // 오른쪽이 왼쪽보다 더 많이 가야하는 경우
				dif_col = b - a;
 
				if (x + dif_col > x2) {
					bw.write("NO\n");
					continue;
				}
			}
 
			if (c > d) { // 아래로 위보다 더 많이 가야하는 경우
				dif_row = c - d;
 
				if (y - dif_row < y1) {
					bw.write("NO\n");
					continue;
				}
			} else {
				dif_row = d - c;
 
				if (y + dif_row > y2) {
					bw.write("NO\n");
					continue;
				}
			}
 
			bw.write("YES\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
 
}
