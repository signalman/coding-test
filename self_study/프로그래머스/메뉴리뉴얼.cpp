#include <bits/stdc++.h>
using namespace std;

bool cmp(pair<string, int> a, pair<string, int> b){
    return a.second > b.second;
}


vector<string> solution(vector<string> orders, vector<int> course) {
    vector<string> answer;
    
    //주어진 코스를 돌면서
    for(auto num: course){
        //맵 선언 및 초기화
        map<string, int> m;
        m.clear();
        //주어진 orders를 돌기
        for(auto s: orders){
            sort(s.begin(), s.end());
            //주문이 코스보다 적을 때
            if(s.length() < num) continue;
            //주문의 길이가 코스와 같을때
            if(s.length() == num){
                if(m.find(s) != m.end()) m[s]++;
                else{
                    // m[s] = 1;
                    m.insert({s, 1});
                }
                continue;
            }
            vector<int> mask(s.length(), 1);
            for(int i=0; i<num; i++) mask[i] = 0;
            do{
                string new_s= "";
                for(int i=0; i<s.length(); i++){
                    if(mask[i] == 0){
                        new_s += s[i];
                    }
                }
                if(m.find(new_s) != m.end()) m[new_s]++;
                else m.insert({new_s, 1});
            }while(next_permutation(mask.begin(), mask.end()));
        }
        
        vector<pair<string, int>> v(m.begin(), m.end());
        sort(v.begin(), v.end(), cmp);
        if(!v.empty()){
            int menu = v[0].second;
            if(menu >=2){
                for(int i=0; i<v.size(); i++){
                    if(menu == v[i].second){
                        answer.push_back(v[i].first);
                    }
                }
            }
        }
    }
    sort(answer.begin(), answer.end());
    
    return answer;
}