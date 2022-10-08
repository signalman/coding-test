#include <bits/stdc++.h>

using namespace std;
vector<string> ret;
int mx_cnt = 0;
void solve(vector<vector<string>> tickets, vector<bool> vis, int state, string contry, vector<string> answer){
    answer.push_back(contry);
    if(mx_cnt<state){
        mx_cnt = state;
        ret = answer;
    }
    for(int i=0; i<tickets.size(); i++){
        if(tickets[i][0] == contry && !vis[i]){
            vis[i] = true;
            solve(tickets, vis, state + 1, tickets[i][1], answer);
            vis[i] = false;
        }
    }
    answer.pop_back();
    return;
}

vector<string> solution(vector<vector<string>> tickets) {
    vector<string> answer;
    vector<bool> vis(tickets.size(), 0);
    sort(tickets.begin(), tickets.end());
    solve(tickets, vis, 1, "ICN", answer);
    return ret;
}