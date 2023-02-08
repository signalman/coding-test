#include <bits/stdc++.h>
using namespace std;

string alp[6] = {"A", "E", "I", "O", "U"};
vector<string> ret;

void dfs(int idx, string str){
    if(idx >= 5){
        ret.push_back(str);
        return;
    }
    
    for(int i=0; i<5; i++){
        dfs(idx+1, str + alp[i]);
    }
    dfs(idx+1, str);
}

int solution(string word) {
    int answer = 0;
    dfs(0, "");
    sort(ret.begin(), ret.end());
    ret.erase(unique(ret.begin(), ret.end()), ret.end());
    int idx = find(ret.begin(), ret.end(), word) - ret.begin();
    return idx;
}