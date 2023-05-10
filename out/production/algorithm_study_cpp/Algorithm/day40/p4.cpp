#include <bits/stdc++.h>
using namespace std;

int n, m, k;
vector<pair<int, int>> adj[10001];
int d[10001];
int before[10001];
int main1()
{
    cin >> n >> m >> k;
    for (int i = 0; i < m; i++)
    {
        int u, v, cost;
        cin >> u >> v >> cost;
        adj[u].push_back({cost, v});
        adj[v].push_back({cost, u});
    }
    fill(before, before + n + 1, -1);
    fill(d, d + n + 1, 987654321);
    int st = 1;
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    d[st] = 0;
    before[st] = st;
    pq.push({d[st], st});
    while (!pq.empty())
    {
        auto cur = pq.top();
        pq.pop();

        if (d[cur.second] != cur.first)
            continue;
        for (auto nxt : adj[cur.second])
        {
            if (d[nxt.second] <= d[cur.second] + nxt.first)
                continue;
            d[nxt.second] = d[cur.second] + nxt.first;
            pq.push({d[nxt.second], nxt.second});
            before[nxt.second] = cur.second;
        }
    }
    vector<int> tmp;
    int cur = n;
    while (before[cur] != cur)
    {
        int bef = before[cur];
        for (auto t : adj[cur])
        {
            if (t.second == bef)
            {
                tmp.push_back(t.first);
                break;
            }
        }
        cur = before[bef];
    }
    sort(tmp.begin(), tmp.end(), greater<int>());
    int length = 0;
    for (int i = 0, j = 0; i < tmp.size() && j < k; i++, j++)
    {
        length += tmp[i];
    }
    cout << d[n] - length;
    cout << d[n];
}
int main()
{

    int arr[4];
    memset(arr, 10, sizeof(arr));
    for (int i = 0; i < 4; i++)
    {
        cout << arr[i] << ' ';
    }
    list<int> l;
    l.insert(l.begin(), 1);
    l.insert(l.begin(), 2);
    l.insert(l.begin(), 3);
    l.insert(next(l.begin(), 2), 5);
    for (auto i : l)
    {
        cout << i << ' ';
    }
}