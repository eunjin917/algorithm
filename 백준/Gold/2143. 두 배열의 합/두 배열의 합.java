import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        int T = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        int M = Integer.parseInt(br.readLine());
        int[] B = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        
        // 누적합 + 해시맵 : 부배열 쌍 합 경우의 수 구하기
        Map<Long, Integer> hashA = new HashMap<>(); // BigInteger -> Long
        for (int i = 0; i < N; i++) {
            long sum = 0; // BigInteger -> long
            for (int j = i; j < N; j++) {
                sum += A[j]; // 누적합 계산
                hashA.put(sum, hashA.getOrDefault(sum, 0) + 1);
            }
        }
        Map<Long, Integer> hashB = new HashMap<>(); // BigInteger -> Long
        for (int i = 0; i < M; i++) {
            long sum = 0; // BigInteger -> long
            for (int j = i; j < M; j++) {
                sum += B[j]; // 누적합 계산
                hashB.put(sum, hashB.getOrDefault(sum, 0) + 1);
            }
        }

        // hashA랑 hashB에서 차례대로 꺼내서 곱하기+더하기
        long count = 0; // int -> long
        for (Map.Entry<Long, Integer> entryA : hashA.entrySet()) { // BigInteger -> Long
            long sumA = entryA.getKey(); // BigInteger -> long
            int countA = entryA.getValue();
            long sumB = T - sumA; // BigInteger -> long
            if (hashB.containsKey(sumB)) {
                count += (long) countA * hashB.get(sumB);
            }
        }

        bw.write(count + "\n");
        bw.close();
    }
}
