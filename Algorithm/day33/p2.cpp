#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool cmp(vector<int> a, vector<int> b)
{
    if (a[1] == b[1]) return a[0] > b[0];
    return a[1] < b[1];
}

int solution(vector<vector<int>> jobs)
{
    sort(jobs.begin(), jobs.end());
    int answer = 0;
    int idx = 0;
    int last = 0;

    while (idx < jobs.size())
    {
        if (idx == 0 || last < jobs[idx][0])
        {
            answer += jobs[idx][1];
            last = jobs[idx][0] + jobs[idx][1];
            idx++;
        }
        else
        {
            int waitStart = idx;
            int i = 0;
            while (idx + i < jobs.size() && last >= jobs[idx + i][0])
            {
            i++;
            }
            int waitEnd = idx + i;

            sort(jobs.begin() + waitStart, jobs.begin() + waitEnd, cmp);
            answer += jobs[idx][1] + (last - jobs[idx][0]);
            last += jobs[idx][1];
            idx += 1;
        }
    }

    return answer / jobs.size();
}