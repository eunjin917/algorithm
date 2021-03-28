// 오큰수
// https://www.acmicpc.net/problem/17298
// 2021.03.28

// Q. 수열의 각 원소에 대해 오큰수 NGE(i) 구하기
// - 오큰수 = 해당 원소보다 오른쪽 + 해당 원소보다 큰 수 중 가장 왼쪽에 있는 수
//		    = 해당되는 수가 없으면 -1



// 1try : 시간 초과

#include <iostream>
#include <string.h>
using namespace std;

int main()
{
	int N;
	cin >> N;	// 수열의 크기 N 입력받기
	int A[1000001];	// 수열 입력받기
	int NGE[1000001] = { 0 };	// 오큰수 NGE를 0으로 초기화 (1 <= 원소값 <= 1000000)

	for (int i = 0; i < N; i++)	// 수열 원소 입력받기
	{
		cin >> A[i];
	}

	for (int i = 0; i < N; i++) // 원소 하나씩 확인
	{
		for (int j = i + 1; j < N; j++) // 다음 원소부터 ~ 끝까지
		{
			if (A[i] < A[j]) // 해당 원소보다 오른쪽 + 해당 원소보다 큰 수 중 가장 왼쪽에 있는 수
			{
				NGE[i] = A[j];
				break;
			}
		}

		if (NGE[i] == 0) // 제일 처음에 모두 0으로 초기화했음 = 여전히 0이라면 위의 if문이 해당 안됐다는 뜻 = 그러한 수가 없는 경우
		{
			NGE[i] = -1;
		}

		cout << NGE[i] << ' ';	// 바로 출력
	}
}