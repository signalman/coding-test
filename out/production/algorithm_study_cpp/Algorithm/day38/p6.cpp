#include <bits/stdc++.h>
using namespace std;

int main()
{
    int m = min({29, 21, 99});
    int arr[4] = {3, 2, 1, 6};
    int a = *min_element(arr, arr + 3);

    cout << m << ' ' << a;
}