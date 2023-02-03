#include <bits/stdc++.h>
using namespace std;

string alp[5] = {"A", "E", "I", "O", "U"};
vector<string> ret;

void dfs(int idx, string str){
    if(idx >= 5){
        ret.push_back(str);
        return;
    }
    
    for(int i=0; i<=5; i++){
        if(i == 5) {
            dfs(idx+1, str); 
            continue;
        }
        dfs(idx+1, str + alp[i]);
    }
}

int solution(string word) {
    int answer = 0;
    dfs(0, "");
    sort(ret.begin(), ret.end());
    ret.erase(unique(ret.begin(), ret.end()), ret.end());
    // for(int i=0; i<30; i++){
    //     cout<<ret[i]<< ' ';
    // }
    
    int idx = find(ret.begin(), ret.end(), word) - ret.begin();
    return idx;
}