import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			long N = Long.parseLong(st.nextToken());
			long K = Long.parseLong(st.nextToken());

			if (N == 2) {
				bw.write("bb\n");
				continue;
			} else if (N == 3) {
				if (K == 1) {
					bw.write("abb\n");
				} else if (K == 2) {
					bw.write("bab\n");
				} else {
					bw.write("bba\n");
				}
				continue;
			} else {
				if (K == 1) {
					String str = "";
					for (int i = 0; i < N - 2; i++) {
						str += "a";
					}
					str += "bb";
					bw.write(str + "\n");
				} else if (K == N * (N - 1) / 2) {
					String str = "bb";
					for (int i = 0; i < N - 2; i++) {
						str += "a";
					}
					bw.write(str + "\n");
				} else {
					long total = (N - 2) * (N - 1) / 2; // a로 시작하는 개수.
					if (K <= total) { // a가 앞에 오는 경우
						long cnt = 1;
						String str = "";
						while (total >= K) {
							total = (N - 2 - cnt) * (N - 1 - cnt) / 2; // 3
							str += "a";
							cnt++; // a.....왼쪽b까지의 개수
						}
						str += "b";
						long rightB = K - total - 1; // 오른쪽b(맨 마지막 인덱스 기준)
						for (int i = 0; i < N - cnt - (rightB + 1); i++) {
							str += "a";
						}
						str += "b";

						for (int i = 0; i < rightB; i++) {
							str += "a";
						}

						bw.write(str + "\n");
					} else { // b가 앞에 오는 경우
						String str = "b";
						for (int i = 0; i < N - 2 - (K - total - 1); i++) {
							str += "a";
						}
						str += "b";
						for (int i = 0; i < K - total - 1; i++) {
							str += "a";
						}
						bw.write(str + "\n");
					}
				}
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
