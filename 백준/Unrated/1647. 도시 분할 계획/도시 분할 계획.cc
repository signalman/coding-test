#include <bits/stdc++.h>
using namespace std;

int n, m;
vector<int> p(100002, -1);
vector<tuple<int, int, int>> adj;

int find(int x)
{
    if (p[x] < 0)
        return x;
    return p[x] = find(p[x]);
}

bool is_diff_group(int u, int v)
{
    u = find(u);
    v = find(v);
    if (u == v)
        return false;
    if (p[u] > p[v])
        swap(u, v);
    p[u] += p[v];
    p[v] = u;
    return true;
}

int main()
{
    cin >> n >> m;
    int mx_cost = 0;
    for (int i = 0; i < m; i++)
    {
        int a, b, c;
        cin >> a >> b >> c;
        adj.push_back(make_tuple(c, a, b));
    }

    sort(adj.begin(), adj.end());

    int cnt = 0;
    int ans = 0;
    for (int i = 0; i < adj.size(); i++)
    {
        int u, v, w;
        tie(w, u, v) = adj[i];
        if (!is_diff_group(u, v))
            continue;
        cnt++;
        ans += w;
        mx_cost = max(mx_cost, w);
        if (cnt == n - 1)
            break;
    }
    cout << ans - mx_cost;
}