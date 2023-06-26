#include <bits/stdc++.h>
using namespace std;

int n;
struct Ball
{
    int idx, color, size;
};

bool cmp(Ball &a, Ball &b)
{
    return a.size < b.size;
}
Ball ball[200005];
int color[200005], ret[200005];

// 1,2
// 1,3
// 1,4
// 1,4
// 6,7
// 6,9

int main()
{
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        cin >> ball[i].color >> ball[i].size;
        ball[i].idx = i;
    }
    sort(ball, ball + n, cmp);
    int sum_ball = 0;
    for (int i = 0, j = 0; i < n; i++)
    {
        for (; ball[i].size > ball[j].size; j++)
        {
            sum_ball += ball[j].size;
            color[ball[j].color] += ball[j].size;
        }
        ret[ball[i].idx] = sum_ball - color[ball[i].color];
    }
    for (int i = 0; i < n; i++)
    {
        cout << ret[i] << '\n';
    }
}