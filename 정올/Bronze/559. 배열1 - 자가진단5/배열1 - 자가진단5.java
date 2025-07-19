import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 정올 #559 배열1 - 자가진단5
public class Main {

    final static double[] avgScores = {0, 85.6, 79.5, 83.1, 80.0, 78.2, 75.0};	// 1반~6반

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());

        double sumAvg2 = avgScores[num1] + avgScores[num2];
        System.out.println(sumAvg2);
    }
}
