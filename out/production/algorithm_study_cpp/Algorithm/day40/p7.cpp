#include <bits/stdc++.h>
using namespace std;

int n;
int ans;
const int MX = 0x7f7f7f7f;
bool isPrime[10010];

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
void solve(string a, string b, int idx, int cnt)
{
    if (a == b)
    {
        ans = min(ans, cnt);
        return;
    }
    if (a[0] == '0' || cnt >= 40)
        return;
    a[idx] = (((a[idx] - '0') + 1) % 10) + '0';
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    beforeRun();
    cin >> n;
    for (int tc = 0; tc < n; tc++)
    {
        string a, b;
        cin >> a >> b;
        ans = MX;
        for (int i = 0; i < 4; i++)
        {
            solve(a, b, i, 0);
        }
        ans == MX ? cout << "Impossible" : cout << ans;
    }
}