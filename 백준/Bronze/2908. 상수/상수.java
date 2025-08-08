import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		char[] first = st.nextToken().toCharArray();
		char[] second = st.nextToken().toCharArray();
		
		int firstLength = first.length;
		char[] reverseFirst = new char[firstLength];
		for (int i=0; i<firstLength; i++) {
			reverseFirst[i] = first[firstLength-1-i];
		}
		int firstInt = Integer.parseInt(new String(reverseFirst));
		
		int secondLength = second.length;
		char[] reverseSecond = new char[secondLength];
		for (int i=0; i<secondLength; i++) {
			reverseSecond[i] = second[secondLength-1-i];
		}
		int secondInt = Integer.parseInt(new String(reverseSecond));
		
		
		int answer = firstInt > secondInt ? firstInt : secondInt;
		System.out.println(answer);
	}

}
