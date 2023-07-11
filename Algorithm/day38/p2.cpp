#include <bits/stdc++.h>
using namespace std;

int N, K, cnt;
int d[150000];
int main()
{
    cin >> N >> K;
    if (N == K)
    {
        cout << 0 << '\n'
             << 1;
        return 0;
    }
    fill(d, d + 150000, -1);
    d[N] = 0;
    queue<int> q;
    q.push(N);
    while (!q.empty())
    {
        auto cur = q.front();
        q.pop();

        for (int nx : {cur - 1, cur + 1, cur * 2})
        {
            if (nx < 0 || nx >= 150000)
                continue;
            if (nx == K && d[nx] == d[cur] + 1)
            {
                cnt++;
            }
            if (d[nx] != -1)
                continue;
            d[nx] = d[cur] + 1;
            q.push(nx);
        }
    }
    cout << d[K] << '\n'
         << cnt + 1;
}