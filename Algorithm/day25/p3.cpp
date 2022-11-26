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

vector<int> sumDate(vector<int> s, vector<int> times){ // 5, 3
    vector<int> ret(6);

    ret[5] = s[5] + times[3];  //초
    ret[4] = s[4] + times[2];  //분
    ret[3] = s[3] + times[1];  //시
    ret[2] = s[2] + times[0];  //일
    ret[1] = s[1]; //월
    ret[0] = s[0]; //연

    if(ret[5] >= 60){
        ret[4]+=1;
        ret[5] -= 60;
    }
    if(ret[4] >= 60){
        ret[3] += 1;
        ret[4] -= 60;
    }
    if(ret[3] >= 24){
        ret[2] += 1;
        ret[3] -= 24;
    }
    if(ret[2] >= 31){
        ret[1] += 1;
        ret[2] -= 30;
    }
    if(ret[1] >= 13){
        ret[0] += 1;
        ret[1] -= 12;
    }

    return ret;
}
vector<int> solution(string s, vector<string> times) {
    vector<int> answer;
    int tSize = times.size();
    vector<string> startString = split(s, ':');
    vector<vector<int>> log; //기록
    vector<int> startInt;
    for(int i=0; i<startString.size(); i++){
        startInt.push_back(stoi(startString[i]));
    }
    int startDate = startInt[2];
    log.push_back(startInt);

    for(int i=0; i<times.size(); i++){
        vector<string> timesString = split(times[i], ':');
        vector<int> timesInt;
        for(auto t: timesString){
            timesInt.push_back(stoi(t));
        }
        startInt = sumDate(startInt, timesInt);
        log.push_back(startInt);
    }

    int dif = ((*log.rbegin())[0] - (*log.begin())[0]) * 12 * 30 + (((*log.rbegin())[1] - (*log.begin())[1])) * 30 + (*log.rbegin())[2] - (*log.begin())[2] + 1;
    bool isSuccess = true;
    for(auto l: log){
        if(l[2] == startDate || l[2] == startDate + 1 || (startDate==30 && l[2] == 1)) {
            startDate = l[2];
            continue;
        }
        isSuccess = false;
        break;
    }
    isSuccess ? answer.push_back(1) : answer.push_back(0);
    answer.push_back(dif);

    return answer;
}
