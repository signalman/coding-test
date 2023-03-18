#include <bits/stdc++.h>
using namespace std;

struct cmp
{
    bool operator()(int a, int b)
    {
        return a > b;
    }
};
int main()
{
    string str;
    getline(cin, str);
    stringstream ss(str);
    string tmp;
    vector<string> v;
    while (getline(ss, tmp, ' '))
    {
        v.push_back(tmp);
    }
    for (auto i : v)
    {
        cout << i << '\n';
    }
}