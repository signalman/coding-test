#include <bits/stdc++.h>
using namespace std;

int N, S;
int arr[42];
vector<int> l, r;
void dfs1(int idx, int size, int sum)
{
    if (idx == size)
    {
        l.push_back(sum);
        return;
    }
    dfs1(idx + 1, size, sum);
    dfs1(idx + 1, size, sum + arr[idx]);
}
void dfs2(int idx, int size, int sum)
{
    if (idx == size)
    {
        r.push_back(sum);
        return;
    }
    dfs2(idx + 1, size, sum);
    dfs2(idx + 1, size, sum + arr[idx]);
}

int main()
{
    cin >> N >> S;
    for (int i = 0; i < N; i++)
    {
        cin >> arr[i];
    }

    dfs1(0, N / 2, 0);
    dfs2(N / 2, N, 0);

    sort(r.begin(), r.end());
    long long ans = 0;

    for (int i = 0; i < l.size(); i++)
    {
        int target = S - l[i];
        int cnt = upper_bound(r.begin(), r.end(), target) - lower_bound(r.begin(), r.end(), target);
        ans += cnt;
    }
    if (S == 0)
        ans--;
    cout << ans;
}