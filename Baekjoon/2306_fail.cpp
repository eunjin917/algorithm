// 유전자
// https://www.acmicpc.net/problem/2306
// 2021.03.28

// Q. 길이가 최대인 KOI 유전자의 길이는?
// - DNA서열 = a, c, g, t로 이루어진 문자열
// - 가장 짧은 KOI = at, gc
// - KOI = a+KOI+t, g+KOI+c
// - KOI = KOI+KOI
// - KOI = 부분 서열 (임의의 문자 삭제 가능)



// 1try : 스택으로 접근, 오답

// ex. acattgagtc
// - a -> atcount++ = 1
// - c -> gccount-- = -1 ~> delcount + 0
// - a -> atcount++ = 2
// - t -> atcount-- = 1
// - t -> atcount-- = 0
// - g -> gccount++ = 1
// - a -> atcount++ = 1
// - g -> gccount++ = 2
// - t -> atcount-- = 0
// - c -> gccount-- = 1 ~> delcount + 0
// - 총길이 10 - delcount 2 = 8 정답
// ex. aattgcat
// - a -> atcount++ = 1
// - a -> atcount++ = 2
// - t -> atcount-- = 1
// - t -> atcount-- = 0
// - g -> gccount++ = 1
// - c -> gccount-- = 0
// - a -> atcount++ = 1
// - t -> atcount-- = 0
// 총길이 8 정답

#include <iostream>
#include <string.h>
using namespace std;

int main()
{
	char DNA[501]; // DNA 최대 길이 500
	cin.getline(DNA, 501);

	int atcount = 0;
	int gccount = 0;
	int delcount = 0;

	// DNA 길이만큼 하나씩 확인
	for (int i = 0; i < strlen(DNA); i++)
	{
		// 해당 문자가 뭔지 확인
		if (DNA[i] == 'a') // 해당 문자가 a이면 atcount++
		{
			atcount++;
		}
		else if (DNA[i] == 't') // 해당 문자가 a이면 atcount--
		{
			atcount--;
		}
		else if (DNA[i] == 'g') // 해당 문자가 g이면 gccount++
		{
			gccount++;
		}
		else if (DNA[i] == 'c') // 해당 문자가 c이면 gccount--
		{
			gccount--;
		}

		// 스택이 성립 안 되는 상황 : 삭제해버리기
		// ㄴ atcount 또는 gccount의 상황(2중1)이니 if - else if
		if (atcount < 0) // atcount가 - 되면 t가 더 많음 -> t 삭제 상황 : delcount++하고 atcount 0으로 만듦
		{
			delcount++;
			atcount = 0;
		}
		else if (gccount < 0) // gccount가 - 되면 c가 더 많음 -> c 삭제 상황 : delcount++하고 gccount 0으로 만듦
		{
			delcount++;
			gccount = 0;
		}
	}

	// for문 종료 후. 스택이 0이 아닌 상황 : 삭제해버리기
	// ㄴ atcount, gccount 둘 다 해당되는 상황이니 if - if
	if (atcount > 0) // atcount가 + 되면 a가 더 많음 -> a 삭제 상황 : delcount를 atcount값만큼 추가
	{
		delcount += atcount;
	}
	if (gccount > 0) // gccount가 + 되면 g가 더 많음 : g 삭제 상황 : delcount를 gccount값만큼 추가
	{
		delcount += gccount;
	}

	cout << strlen(DNA) - delcount;


	return 0;
}



// 2try : 다이나믹 프로그래밍으로 접근