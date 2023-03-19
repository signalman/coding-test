#include <bits/stdc++.h>
using namespace std;

int n, m;
vector<tuple<int, int, int>> edge;
vector<int> p(1002, -1);

bool rev(tuple<int, int, int> a, tuple<int, int, int> b)
{
    return get<0>(a) > get<0>(b);
}

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
    if (u > v)
        swap(u, v);
    p[u] += p[v];
    p[v] = u;
    return true;
}

int mst()
{
    int ret = 0;
    int cnt = 0;
    for (int i = 0; i < edge.size(); i++)
    {
        int c, a, b;
        tie(c, a, b) = edge[i];
        if (!is_diff_group(a, b))
            continue;
        cnt++;
        if (c == 1)
            ret++;
        if (cnt == n)
            break;
    }
    return ret;
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin >> n >> m;
    for (int i = 0; i < m + 1; i++)
    {
        int a, b, c;
        cin >> a >> b >> c;
        c = c == 0 ? 1 : 0;
        edge.push_back(make_tuple(c, a, b));
    }
    int ans1, ans2;
    // 최적의 경로
    sort(edge.begin(), edge.end());
    ans1 = mst();

    // 최악의 경로
    fill(p.begin(), p.begin() + n + 1, -1);
    sort(edge.begin(), edge.end(), rev);
    ans2 = mst();

    cout << ans2 * ans2 - ans1 * ans1;
}