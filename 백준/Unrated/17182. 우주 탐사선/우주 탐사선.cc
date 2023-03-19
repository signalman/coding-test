#include <bits/stdc++.h>
using namespace std;

int n, k;
int adj[12][12];
vector<int> comb;
int main()
{
    cin >> n >> k;
    for (int i = 0; i < n; i++)
    {
        if (i != k)
            comb.push_back(i);
    }
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            cin >> adj[i][j];
        }
    }

    for (int k = 0; k < n; k++)
    {
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                adj[i][j] = min(adj[i][k] + adj[k][j], adj[i][j]);
            }
        }
    }

    int ans = 0x7f7f7f7f;
    do
    {
        int dist = adj[k][comb[0]];
        for (int i = 1; i < n - 1; i++)
        {
            dist += adj[comb[i - 1]][comb[i]];
        }
        ans = min(ans, dist);
    } while (next_permutation(comb.begin(), comb.end()));

    cout << ans;
}