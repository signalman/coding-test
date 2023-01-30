#include <bits/stdc++.h>
using namespace std;


long long solution(int cap, int n, vector<int> deliveries, vector<int> pickups) {
    long long answer = -1;
    int dsize = deliveries.size();
    
    stack<pair<int, int>> sd; //양, 인덱스
    stack<pair<int, int>> sp;
    
    for(int i=0; i<dsize; i++){
        sd.push(make_pair(deliveries[i], i));
        sp.push(make_pair(pickups[i], i));
    }
    
    while(!(sd.empty()&&sp.empty())){

        int tcap = cap;
        int ddist = 0;
        int pdist = 0;
        if(!sd.empty()){
            ddist = sd.top().second;

            if(tcap < sd.top().first){
                sd.top().first -= tcap;
            }
            else if(tcap > sd.top().first){
                while(!sd.empty() && tcap){
                    tcap -= sd.top().first;
                    sd.pop();
                }
            }
            else{
                sd.pop();
            }
        }
        tcap = cap;
        if(!sp.empty()){
            pdist = sp.top().second;

            if(tcap < sp.top().first){
                sp.top().first -= tcap;
            }
            else if(tcap > sp.top().first){
                while(!sp.empty() && tcap > sp.top().first){
                    tcap -= sp.top().first;
                    sp.pop();
                }
            }
            else{
                sp.pop();
            }
        }
        answer += (max(ddist, pdist)+1) * 2;
        cout<<answer <<'\n';

    }

    
    
    return answer;
}