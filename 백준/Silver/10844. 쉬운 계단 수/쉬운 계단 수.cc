#include <bits/stdc++.h>
using namespace std;

int N;
const int MX = 1e9;
long long d[101][10];
int main()
{
    cin >> N;

    if (N == 1)
    {
        cout << 9;
        return 0;
    }
    for (int i = 0; i <= 9; i++)
    {
        if (i == 0 || i == 1 || i == 9)
            d[2][i] = 1;
        else
            d[2][i] = 2;
    }
    for (int i = 3; i <= N; i++)
    {
        for (int j = 0; j <= 9; j++)
        {
            if (j == 0)
                d[i][j] += d[i - 1][1] % MX;
            else if (j == 9)
                d[i][j] += d[i - 1][8] % MX;
            else
                d[i][j] += (d[i - 1][j - 1] + d[i - 1][j + 1]) % MX;
        }
    }
    long long ans = 0;
    for (int i = 0; i <= 9; i++)
    {
        ans += (d[N][i] % MX);
    }
    cout << ans % MX;
}