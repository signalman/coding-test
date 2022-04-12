#include <bits/stdc++.h>
using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    unordered_multiset<string> ms;
    for(int i=0; i<participant.size(); i++){
        ms.insert(participant[i]);
    }
    for(int i=0; i<completion.size(); i++){
        ms.erase(ms.find(completion[i]));
    }
    
    return *ms.begin();
}