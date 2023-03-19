#include <bits/stdc++.h>
using namespace std;

int n, m, k;
vector<pair<long long, int>> adj[100002];
long long d[100002];
priority_queue<pair<long long, int>, vector<pair<long long, int>>, greater<pair<long long, int>>> pq;
void dijkstra()
{
    while (!pq.empty())
    {
        auto cur = pq.top();
        pq.pop();

        if (d[cur.second] != cur.first)
            continue;
        for (auto nxt : adj[cur.second])
        { // cur과 연결된 cost/v
            if (d[nxt.second] <= d[cur.second] + nxt.first)
                continue;
            d[nxt.second] = d[cur.second] + nxt.first;
            pq.push({d[nxt.second], nxt.second});
        }
    }
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin >> n >> m >> k;
    for (int i = 0; i < m; i++)
    {
        int u, v, c;
        cin >> u >> v >> c;
        adj[v].push_back({c, u});
    }
    fill(d + 1, d + n + 1, 0x7f7f7f7f7f7f);
    for (int i = 0; i < k; i++)
    {
        int r;
        cin >> r;
        d[r] = 0;
        pq.push({d[r], r});
    }

    dijkstra();
    int idx = max_element(d + 1, d + n + 1) - d;
    cout << idx << '\n'
         << d[idx];
}