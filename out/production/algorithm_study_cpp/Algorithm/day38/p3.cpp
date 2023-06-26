#include <bits/stdc++.h>
using namespace std;

int cnt;
int fib(int n)
{
    if (n == 1 || n == 2)
    {
        cnt++;
        return 1;
    }
    else
        return (fib(n - 1) + fib(n - 2));
}
int fibonacci(int n)
{
    if (n == 1 || n == 2)
    {
        cnt++;
        return 1;
    }
    int f[45] = {
        0,
    };
    for (int i = 3; i <= n; i++)
    {
        cnt++;
        f[i] = f[i - 1] + f[i - 2];
    }
    return f[n];
}
int main()
{
    int n;
    cin >> n;
    fib(n);
    cout << cnt << ' ';
    cnt = 0;
    fibonacci(n);
    cout << cnt;
}