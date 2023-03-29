#include <bits/stdc++.h>
using namespace std;

int n;
vector<int> v;
int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        int num;
        cin >> num;
        v.push_back(num);
    }
    sort(v.begin(), v.end());
    for (auto i : v)
    {
        cout << i << '\n';
    }
}