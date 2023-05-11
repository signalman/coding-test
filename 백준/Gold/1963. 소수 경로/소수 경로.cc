#include <bits/stdc++.h>
using namespace std;

int n;
bool prime[10010];
bool vis[10010];

void beforeRun()
{
    for (int i = 2; i * i < 10000; i++)
    {
        for (int j = i * i; j < 10000; j += i)
        {
            prime[j] = false;
        }
    }
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    memset(prime, true, sizeof(prime));
    beforeRun();
    cin >> n;
    for (int tc = 0; tc < n; tc++)
    {
        int a, b;
        string ans = "Impossible";
        cin >> a >> b;

        queue<pair<int, int>> q;
        while (!q.empty())
        {
            q.pop();
        }
        fill(vis, vis + 10000, false);
        vis[a] = 1;
        q.push({a, 0});

        while (!q.empty())
        {
            auto cur = q.front();
            // cout << cur.first << '\n';
            q.pop();
            if (cur.first == b)
            {
                ans = to_string(cur.second);
                break;
            }
            for (int i = 0; i < 4; i++)
            {
                string nxt_a_str = to_string(cur.first);
                for (int j = 0; j < 10; j++)
                {
                    nxt_a_str[i] = j + '0';
                    int next = stoi(nxt_a_str);
                    // cout << next << '\n';
                    if (next >= 1000 && prime[next] && !vis[next])
                    {
                        q.push({next, cur.second + 1});
                        vis[next] = true;
                    }
                }
            }
        }
        cout << ans << '\n';
    }
}