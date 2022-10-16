#include <bits/stdc++.h>
using namespace std;

vector<int> solution(int n, vector<vector<int>> paths, vector<int> gates, vector<int> summits) {
    vector<int> answer;
    vector<pair<int, int>> ret;
    vector<pair<int, int>> adj[n+1];
    bool vis[50001];
    for(auto arr: paths){
        adj[arr[0]].push_back({arr[2], arr[1]}); //현재노드 -> 부분거리, 다음노드
    }

    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    for(int i=0; i<gates.size(); i++){
        fill(vis, vis+n+1, false);
        pq.push({0, gates[i]});
        bool flag = false;
        vis[gates[i]] = true;

        while(!pq.empty()){
            auto cur = pq.top(); pq.pop();  //현재 노드까지의 intensity, 현재 노드
            for(auto s: summits){
                if(s == cur.second) {ret.push_back({s, cur.first}); flag = true;}
            }
            if(flag) break;
            for(auto nxt: adj[cur.second]){
                if(vis[nxt.second] == true) continue;
                vis[nxt.second] = true;
                pq.push({nxt.second, max(nxt.first, cur.first)});
            }
        }
    }

    for(auto s: ret){
        cout<< s.first<<"  "<<s.second<<'\n';
    }
    
    
    return answer;
}