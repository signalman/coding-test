#include <bits/stdc++.h>
using namespace std;

int N;
const int MX = 1e9;
pair<long long, int> d[101][10];
int main()
{
    cin >> N;
    for (int i = 1; i <= 9; i++)
    {
        d[1][i].first = 1;
        d[1][i].second = (1 << i);
    }

    for (int i = 2; i <= N; i++)
    {
        for (int j = 0; j <= 9; j++)
        {

            if (j == 0)
                d[i][j].first = d[i - 1][1].first % MX;
            d[i][j].second = (d[i - 1][1].second | (1 << j));
            else if (j == 9)
                d[i][j]
                    .first = d[i - 1][8].first % MX;
            d[i][j].second = (d[i - 1][8].second | (1 << j));
            else d[i][j].first = (d[i - 1][j - 1].first + d[i - 1][j + 1].first) % MX;
        }
    }
    long long ans = 0;
    // for (int i = 0; i <= 9; i++)
    // {
    //     cout << d[N][i].second << ' ';
    // }
    // cout << ans % MX;
    cout << d[2][1].second << ' ' << d[2][4].second;
}