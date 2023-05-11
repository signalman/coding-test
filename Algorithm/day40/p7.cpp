#include <bits/stdc++.h>
using namespace std;

int n;
bool isPrime[10010];
bool vis[10010];

void beforeRun()
{
    fill(isPrime, isPrime + 10010, true);
    for (int i = 1; i <= 100; i++)
    {
        if (isPrime[i] == true)
        {
            for (int j = 2; j <= 100; j++)
            {
                isPrime[j] = false;
            }
        }
    }
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    beforeRun();
    cin >> n;
    for (int tc = 0; tc < n; tc++)
    {
        string a, b, ans = "Impossible";
        cin >> a >> b;

        queue<pair<string, int>> q;
        fill(vis, vis + 10000, false);
        vis[stoi(a)] = 1;
        q.push({a, 0});

        while (!q.empty())
        {
            auto cur = q.front();
            q.pop();
            if (cur.first == b)
            {
                ans = cur.second;
                break;
            }
            for (int i = 0; i < 4; i++)
            {
                for (int j = 0; j < 10; j++)
                {
                    if (i == 3 && j == 0)
                        continue;
                    string na = a;
                    na[i] = j;
                    if (!vis[stoi(na)] && isPrime[stoi(na)])
                    {
                        q.push({na, cur.second + 1});
                        vis[stoi(na)] = true;
                    }
                }
            }
        }
        cout << ans << '\n';
    }
}