// A+B - 4
// https://www.acmicpc.net/problem/10951
// 2021.03.07

#include <iostream>
using namespace std;

int main()
{
    int A, B;
    while (scanf("%d %d", &A, &B) != EOF)
    {
        cout << A + B << '\n';
    }

    return 0;
}