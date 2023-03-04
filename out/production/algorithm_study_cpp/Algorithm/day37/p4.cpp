#include <bits/stdc++.h>
using namespace std;

int n, k;
/*
들어올때 물건의 수가 적은 순으로 적은 번호 카운터로
나갈때 1. 계산 끝나는 순 2. 큰 번호 카운터 순
*/
struct Customer{
    int idx, id, out;
    Customer(int idx, int id, int out){
        this -> idx = idx;
        this -> id = id;
        this -> out = out;
    }
    bool operator<(const Customer &c) const {
        if(out == c.out) return idx < c.idx;
        return out > c.out; 
    }
};

vector<pair<int, int>> line;
priority_queue<Customer> pq;//들어온시간, 소요시간(물건), 인덱스, id
stack<int> st;
long long answer;
long long answer_idx = 1;
int main(){
    cin>>n>>k;
    for(int i=0; i<n; i++){
        int id, w;
        cin>>id>>w;
        line.push_back(make_pair(w, id));
    }
    //sort(line.begin(), line.end()); //물건 적은 순으로 정렬

    int time = 0;
    int counterNumber = 0;
    //한명씩 안으로.
    for(int i=0; i<line.size(); i++){

        //i < k
        if(i < k){
            pq.push(Customer(counterNumber++, line[i].second, time + line[i].first));
        }
        else{
            //나가고
            auto cur = pq.top();
            time = cur.out;
            bool flag = false;
            while(cur.out == pq.top().out){
                st.push(pq.top().idx); //계산대 번호
                answer += ((long long)pq.top().id * (long long)answer_idx++);
                pq.pop();
            }
            //나간만큼 들어오고
            while(i < n && !st.empty()){
                pq.push(Customer(st.top(), line[i].second, time + line[i].first));
                i++;
                st.pop();
                flag = true;
            }
            if(flag) i--;
            
        }
    }

    while(!pq.empty()){
        auto cur = pq.top(); pq.pop();
        answer += ((long long)cur.id * (long long)answer_idx++);
    }
    cout<<answer;
}