#include <bits/stdc++.h>
using namespace std;

map<string, int> termsInfo;
vector<string> split(string str, string del){
    vector<string> ret;
    long long pos = 0;
    string tmp = "";
    while((pos = str.find(del)) != string::npos){
        tmp = str.substr(0, pos);
        ret.push_back(tmp);
        str.erase(0, pos + del.length());
    }
    ret.push_back(str);
    return ret;
}

vector<int> solution(string today, vector<string> terms, vector<string> privacies) {
    vector<int> answer;
    vector<string> t = split(today, "."); //오늘 날짜 t에 저장
    int today_y = stoi(t[0]);
    int today_m = stoi(t[1]);
    int today_d = stoi(t[2]);

    for(string s: terms){ //약관 / 개월수 저장
        vector<string> tms = split(s, " ");
        termsInfo[tms[0]] = stoi(tms[1]);
    }
    int idx = 1;
    for(auto p: privacies){
        vector<string> pri = split(p, " ");
        string ymd = pri[0];
        string tm = pri[1];

        vector<string> sp_ymd = split(ymd, ".");
        int y = stoi(sp_ymd[0]);
        int m = stoi(sp_ymd[1]);
        int d = stoi(sp_ymd[2]);

        m += termsInfo[tm];
        y += (m - 1) / 12;
        m = m % 12;
        if(m == 0) m = 12;

        if(today_y > y || (today_y == y && today_m > m) || (today_y == y && today_m == m &&today_d >= d)){
            answer.push_back(idx);
        } 
        idx++;
    }
    return answer;
}