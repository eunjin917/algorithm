import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N 입력 : 10
        int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        Arrays.sort(A);
        
        // (N번 반복) 투포인터
        int countGood = 0;
        for (int i = 0; i < N; i++) {
            int left = 0;
            int right = N - 1;
            while (left < right) {
                // 같은 경우는 불가
                if (i == left) {
                    left++;
                    continue;
                }
                else if (i == right) {
                    right--;
                    continue;
                }

                int sum = A[left] + A[right];
                if (A[i] == sum) {
                    countGood++;
                    break;
                }
                else if (A[i] > sum) {
                    left++;
                }
                else if (A[i] < sum) {
                    right--;
                }
            }
        }

        bw.write(countGood+"\n");
        bw.close();
    }

}
