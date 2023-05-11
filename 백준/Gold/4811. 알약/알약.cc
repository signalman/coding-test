#include <bits/stdc++.h>
using namespace std;

int N;
long long dp[31][31];
int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    for (int j = 0; j <= 30; j++)
    {
        dp[0][j] = 1;
    }
    for (int i = 1; i <= 30; i++)
    {
        for (int j = 0; j <= 30; j++)
        {
            if (j == 0)
            {
                dp[i][j] = dp[i - 1][j + 1];
            }
            else
            {
                dp[i][j] = dp[i - 1][j + 1] + dp[i][j - 1];
            }
        }
    }
    while (cin >> N)
    {
        if (N == 0)
            break;
        cout << dp[N][0] << '\n';
    }
}