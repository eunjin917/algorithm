import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// Flatten
public class Solution {
	
	final static int TEST_MAX = 10;
	final static int MAX_WIDTH = 100;
	final static int MIN_WIDTH = 1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int t=1; t<=TEST_MAX; t++) {
			int dump = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] heights = new int[MAX_WIDTH];
			for (int i=0; i<MAX_WIDTH; i++) {
				heights[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(heights);
			int diff = heights[MAX_WIDTH-1] - heights[0];
			for (int d=0; d<dump; d++) {
				if (diff <= 1) {
					break;
				}
				heights[MAX_WIDTH-1]--;
				heights[0]++;
				Arrays.sort(heights);
				diff = heights[MAX_WIDTH-1] - heights[0];
			}
		
			System.out.println("#"+t+" "+diff);
		}
	}

}
