#include <bits/stdc++.h>
using namespace std;

int n;
vector<tuple<int, int, int>> adj;
int p[303];
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
    cin >> n;
    fill(p, p + n + 2, -1);
    for (int i = 1; i <= n; i++)
    {
        int w;
        cin >> w;
        adj.push_back(make_tuple(w, n + 1, i));
    }
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= n; j++)
        {
            int w;
            cin >> w;
            if (w == 0)
                continue;
            adj.push_back(make_tuple(w, i, j));
        }
    }

    sort(adj.begin(), adj.end());

    int ans = 0;
    int cnt = 0;
    for (int i = 0; i < adj.size(); i++)
    {
        int w, u, v;
        tie(w, u, v) = adj[i];
        if (!is_diff_group(u, v))
            continue;
        cnt++;
        ans += w;
        if (cnt == n)
            break;
    }
    cout << ans;
}