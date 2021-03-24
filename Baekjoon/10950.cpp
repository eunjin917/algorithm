// A+B - 3
// https://www.acmicpc.net/problem/10950
// 2021.03.07

#include <iostream>
using namespace std;

int main()
{
    int T, A, B;
    cin >> T;
    for (int i = 0; i < T; i++)
    {
        cin >> A >> B;
        cout << A + B << '\n';
    }
}