#include <bits/stdc++.h>
using namespace std;

int solution(vector<int> queue1, vector<int> queue2) {
    long long sum = 0;
    queue<int> q1, q2;
    long long s1 =0, s2 = 0;
    
    for(int i=0; i<queue1.size(); i++){
        sum += queue1[i] + queue2[i];
        
        q1.push(queue1[i]);
        s1 += queue1[i];
        
        q2.push(queue2[i]);
        s2 += queue2[i];
        
    }
    long long half = sum / 2;
    cout<<"s1:" <<s1;
    cout<<'\n';
    cout<<"s2:" <<s2;
    
    

    
    int mx = 900000;
    int cnt = 0;
    while(mx--){
        if(s1 == half) return cnt;
        if(q1.empty() || q2.empty()) break;
        if(s1 > half){
            cout<<q1.front()<<"가 q2으로"<<'\n';
            q2.push(q1.front());
            s2 += q1.front();
            s1 -= q1.front();
            q1.pop();
            
        }
        else{
            cout<<q2.front()<<"가 q1으로"<<'\n';
            q1.push(q2.front());
            s1 += q2.front();
            s2 -= q2.front();
            q2.pop();
        }
        cnt++;
    }
    
    return -1;
}