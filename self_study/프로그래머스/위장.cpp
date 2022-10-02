#include <bits/stdc++.h>
using namespace std;

int solution(vector<vector<string>> clothes) {
    int answer = 1;
    map<string, int> m;
    for(auto pair: clothes){
        m[pair[1]]++;
    }

    map<string, int>:: iterator iter;
    for(iter = m.begin(); iter!=m.end(); iter++){
        answer *= iter->second + 1;
    }
    answer -= 1;
    return answer;
}