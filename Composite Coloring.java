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

		int[] prime = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31 };
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			int[] color = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int usedcolornum = 1;
			for (int pn = 0; pn < prime.length; pn++) {
				boolean isdivided = false;
				for (int i = 0; i < N; i++) {
					if (color[i] == 0 && arr[i] % prime[pn] == 0) {
						isdivided = true;
						color[i] = usedcolornum;
					}
				}

				if (isdivided) {
					usedcolornum += 1;
				}
			}

			bw.write((usedcolornum - 1) + "\n");
			for (int i = 0; i < N; i++) {
				bw.write(color[i] + " ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
