#include <bits/stdc++.h>
using namespace std;

bool comp1(pair<int, pair<string, int>> a, pair<int, pair<string, int>> b){
    return a.second.second > b.second.second;
}
bool comp2(pair<string, int> a, pair<string, int> b){
    return a.second > b.second;
}
vector<int> solution(vector<string> genres, vector<int> plays) {
    vector<int> answer;
    vector<pair<int, pair<string, int>>> info;
    unordered_map<string, int> map;
    for(int i=0; i<genres.size(); i++){
        map[genres[i]]+=plays[i];
        pair<string, int> gp;
        gp.first = genres[i];
        gp.second = plays[i];
        pair<int, pair<string, int>> id;
        id.first = i;
        id.second = gp;
        info.push_back(id);
    }
    sort(info.begin(), info.end(), comp1);
    vector<pair<string, int>> v(map.begin(), map.end());
    sort(v.begin(), v.end(), comp2);
    for(int i=0; i<v.size(); i++){
        string st1 = v[i].first;
        int cnt = 0;
        for(int j=0; j<info.size(); j++){
            if(info[j].second.first == st1){
                answer.push_back(info[j].first);
                cnt++;
            }
            if(cnt==2) break;
        }
    }
    return answer;
}