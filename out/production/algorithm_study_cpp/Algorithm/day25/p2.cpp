#include <bits/stdc++.h>
using namespace std;

vector<string> split(string str, char del) {
    istringstream iss(str);       
    string buffer;                
    vector<string> result;
    while (getline(iss, buffer, del)) {
        result.push_back(buffer);       
    }
    return result;
}

int solution(vector<string> id_list, int k) {
    int answer = 0;
    map<string, int> info;

    for(string s: id_list){
        vector<string> tmp = split(s, ' ');
        for(string name: tmp){
            info[name] += 1;
        }
    }

    map<string, int>:: iterator iter;
    for(auto iter = info.begin(); iter != info.end(); iter++){
        if(iter->second <= k) answer += iter->second;
        else answer += k;
    }


    return answer;
}