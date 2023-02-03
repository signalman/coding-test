#include <bits/stdc++.h>
using namespace std;

bool arr[101];

int bfs(vector<int>* adj){
    queue<int> q;
    bool vis[102] = {0, };
    int ret = 0;
    for(auto i: adj[1]){
        vis[i] = true;
        q.push(i);
        ret++;
    }
    
    while(!q.empty()){
        int cur = q.front();
        q.pop();
        
        for(int i: adj[cur]){
            if(vis[i]) continue;
            vis[i] = true;
            q.push(i);
            ret++;
        }
    }
    return ret;
}


int solution(int n, vector<vector<int>> wires) {
    int answer = 200;
    
    for(int i=0; i<wires.size(); i++){
        vector<vector<int>> v(wires);
        v.erase(v.begin() + i);
        vector<int> adj[102];
        
        for(int i=0; i<v.size(); i++){
            adj[v[i][0]].push_back(v[i][1]);
            adj[v[i][1]].push_back(v[i][0]);
        }
        
        int ret = bfs(adj); //연결되어있는 노드 개수반환
        answer = min(answer, abs(n-ret*2));
    }
    
    return answer;
}