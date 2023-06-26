#include <bits/stdc++.h>
using namespace std;

map<string, pair<string, string>> parkingInfo; //<차번호, [입차시간, 출차시간]>
map<string, int> parkingHours; //차번호 / 누적시간
vector<int> parkingFees;

vector<string> split(string str, string d){
    vector<string> res;
    long long pos = 0;
    string token = "";
    while((pos = str.find(d) != string::npos)){
        token = str.substr(0, pos);
        res.push_back(token);
        str.erase(0, pos + d.length());
    }
    res.push_back(str);
    return res;
}


void calculateTime(string carNumber){
    string inTime = parkingInfo[carNumber].first;
    string outTime = parkingInfo[carNumber].second;

    vector<string> time1 = split(inTime, ":");
    int inTimeHour = stoi(time1[0]);
    int inTimeMinute = stoi(time1[1]);

    vector<string> time2 = split(outTime, ":");
    int outTimeHour = stoi(time2[0]);
    int outTimeMinute = stoi(time2[1]);

    if(outTimeMinute < inTimeMinute){
        outTimeMinute += 60;
        outTimeHour -= 1;
    }
    int spentTime = (outTimeHour-inTimeHour)*60 + outTimeMinute-inTimeMinute;
    parkingHours[carNumber] += spentTime;
}

vector<int> solution(vector<int> fees, vector<string> records) {
    vector<int> answer;
    parkingFees = fees;

    for(auto r: records){
        vector<string> ret = split(r, " ");
        string time = ret[0];
        string carNumber = ret[1];
        string dir = ret[2];

        if(dir == "IN"){
            parkingInfo.insert(make_pair(carNumber, make_pair(time, "")));
        }
        else{
            
            parkingInfo[carNumber].second = time;
            //시간 계산로직
            calculateTime(carNumber);
            parkingInfo.erase(carNumber);
        }
    }

    for(auto i = parkingInfo.begin();  i != parkingInfo.end(); ++i){
        if((*i).second.second == "") (*i).second.second="23:59";
    }

    int cost;
    //누적시간에 따른 요금 계산
    for(auto i = parkingHours.begin(); i != parkingHours.end(); ++i){ //차번호, 누적시간
        if((*i).second < fees[0]){
            answer.push_back(fees[1]);
        }
        else{
            cost = fees[1] + ((*i).second - fees[0])/fees[2]*fees[3];
            answer.push_back(cost);
        }
    }
    
    
    return answer;
}