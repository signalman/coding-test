#include <bits/stdc++.h>

using namespace std;

int solution(vector<string> members, vector<vector<string>> commands, string messageID) {
    vector<bool> answer;
    map<string, bool> check;
    set<string> memberSet;

    int allmember = members.size() + 1;

    for(int i=commands.size() -1; i>=0; i--){
        if(commands[i][2] == messageID) {memberSet.insert(commands[i][1]);  break;}
    }


}