import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			String x = br.readLine();

			// 값의 대소관계는 상관 없음. 아래는 임의로 정한 것.
			String a = ""; // 작은 값
			String b = ""; // 큰 값

			boolean isOne = false;
			for (int i = 0; i < x.length(); i++) {
				if (x.charAt(i) == '0') { // 0 일때는 무조건 a, b 둘다 0이 온다.
					a += "0";
					b += "0";
				} else if (x.charAt(i) == '1') {
					if (!isOne) { // 1이 처음 나왔다면,
						isOne = true;
						a += "1"; // 작은 값에 1을 넣어 주고
						b += "0"; // 큰 값에 0을 넣어준다.
					} else { // 1이 여러 번 나왔다면,
						a += "0"; // 작은 값에 0을 넣어주고
						b += "1"; // 큰 값에 1을 넣어준다.
					}
				} else {
					if (!isOne) { // 1이 나온 적 없다면, a와 b 각각 1을 넣어준다.
						a += "1";
						b += "1";
					} else { // 1이 여러 번 나왔다면,
						a += "0"; // 작은 값에 0을 넣어주고
						b += "2"; // 큰 값에 1을 넣어준다.
					}
				}
			}

			bw.write(a + "\n");
			bw.write(b + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
