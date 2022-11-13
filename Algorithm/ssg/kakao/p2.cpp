    /**
    작업의 선호도?
    1. 같은 분류 번호
    2. 다른 분류 번호 -> 중요도 순
    3. 분류번호가 낮은 순.
    **/
//요청시각, 걸리는 시간, 분류번호, 중요도
#include <bits/stdc++.h>
using namespace std;

int s;

struct cmp{
    bool operator()(vector<int> a, vector<int> b){
        //top과 같은 분류일때 
        // if(a[2] == s && a[2] != b[2]) return true;
        // else if(b[2] == s && a[2] != b[2]) return false;
        if(a[3] != b[3]) return a[3] > b[3];
        return a[2] < b[2];
    }
};


vector<int> solution(vector<vector<int>> jobs) {
    vector<int> answer;
    // priority_queue<vector<int>, vector<vector<int>>, cmp> pq;
    deque<vector<int>> pq;
    
    int curTime = jobs[0][0];
    int totalTime = 0;
    int taskCnt = 0; //작업의 개수 축적

    while(!pq.empty() || taskCnt < jobs.size()){

        if(taskCnt < jobs.size() && jobs[taskCnt][0] <= curTime){

            if(s == jobs[taskCnt][0]) pq.push_front(jobs[taskCnt++]);
            else pq.push_back(jobs[taskCnt++]);
            continue;
        }

        //수행할 작업 있는경우
        if(!pq.empty()){
            curTime += pq.front()[1];
            if(answer.empty() || answer.back() != pq.front()[2]) answer.push_back(pq.front()[2]);
            s = pq.front()[2];
            pq.pop_front();
        }

        //수행할 작업이 없는 경우
        else{
            curTime = jobs[taskCnt][0];
        }
        
    }

    


    return answer;
}