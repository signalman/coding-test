#include <bits/stdc++.h>
using namespace std;

int solution(vector<vector<int>> flowers) {
    int answer = 0;
    bool day[365] ={false, };

    for(auto v: flowers){
        for(int d=v[0]; d<v[1]; d++){
            day[d] = true;
        }
    }

    for(int d=0; d<365; d++){
        if(day[d]) answer++;
    }


    return answer;
}