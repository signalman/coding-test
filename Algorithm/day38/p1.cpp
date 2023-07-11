#include <bits/stdc++.h>
using namespace std;

// d[i]: i일까지 최대 이익
// m[i]: i번째 일의 이익
// t[i]: i번째 일이 걸리는 시간
// d[i]: max(d[i-1], d[i-t[i]] - m[i])
// d[i+t[i]]: max(d[i], d[i] + m[i])
int N;
int m[16];
int t[16];
int d[16];
int main()
{
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        cin >> t[i] >> m[i];
    }

    for (int i = N - 1; i >= 0; i--)
    {
        if (i + t[i] > N)
            d[i] = d[i + 1];
        else
            d[i] = max(d[i + 1], d[i + t[i]] + m[i]);
    }
    cout << d[0];
}