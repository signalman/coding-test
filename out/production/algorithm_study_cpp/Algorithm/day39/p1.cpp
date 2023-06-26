#include <bits/stdc++.h>
using namespace std;

int n;
struct flower
{
    int sm, sd;
    int em, ed;

    flower() {}
    flower(int sm, int sd, int em, int ed)
    {
        this->sm = sm;
        this->sd = sd;
        this->em = em;
        this->ed = ed;
    }
    bool operator<(const flower &f) const
    {
        if (this->sm != f.sm)
            return this->sm < f.sm;
        if (this->sd != f.sd)
            return this->sd < f.sd;
        if (this->em != f.em)
            return this->em < f.em;
        return this->ed < f.ed;
    }
};
struct cmp
{
    bool operator()(flower &f1, flower &f2)
    {
        if (f1.em != f2.em)
            return f1.em < f2.em;
        return f1.ed < f2.ed;
    }
};

int main()
{
    cin >> n;
    flower f[n];
    for (int i = 0; i < n; i++)
    {
        int sm, sd, em, ed;
        cin >> sm >> sd >> em >> ed;
        f[i] = flower(sm, sd, em, ed);
    }
    sort(f, f + n);
    int em = 3;
    int ed = 1;
    int ans = 0;
    priority_queue<flower, vector<flower>, cmp> pq;
    for (int i = 0; i < n; i++)
    {
        if (em == 12)
            break;
        // 날짜가 작거나 같을 경우에만 pq에 들어감
        if (f[i].sm < em || (f[i].sm == em && f[i].sd <= ed))
        {
            pq.push(flower(f[i].sm, f[i].sd, f[i].em, f[i].ed));
        }

        else
        {
            if (!pq.empty())
            {
                auto cur = pq.top();
                pq.pop();
                em = cur.em;
                ed = cur.ed;
                i--;
                ans++;
            }
        }
    }
    if (em == 12)
        cout << ans;
    else if (!pq.empty() && pq.top().em == 12)
    {
        cout << ans + 1;
    }
    else
        cout << 0;
}