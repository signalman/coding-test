#include <bits/stdc++.h>
using namespace std;

priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>> pq;
int solution(vector<vector<int>> jobs) { //요청시각, 작업 시간
    int answer = 0;
    sort(jobs.begin(), jobs.end()); //요청시각 순으로 정렬
    
    int st = 0; //현재 디스크가 가리키는 idx
    int cur_time = 0; //현재 시간
    
    while(st < jobs.size()){
        if(st < jobs.size() && cur_time < jobs[st][0] && pq.empty()){
            cur_time = jobs[st][0];
        }
        while(st < jobs.size() && cur_time >= jobs[st][0]){
            vector<int> tmp;
            tmp.push_back(jobs[st][1]);
            tmp.push_back(jobs[st][0]);
            pq.push(tmp); //작업시간, 요청시각
            st += 1;
        }
        if(!pq.empty()){
            auto top = pq.top();
            pq.pop();
            cur_time += top[0];
            answer += cur_time - top[1];
        }
    }
    while(!pq.empty()){
        auto top = pq.top();
        pq.pop();
        cur_time += top[0];
        answer +=  cur_time - top[1];
    }
    return answer / jobs.size();
}
