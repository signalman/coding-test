#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second

int v, e, st;
vector<pair<int, int>> adj[20005];
const int INF = 1e9+10;
int d[20005]; //최단거리 테이블

int main(){
    cin>>v>>e>>st;
    fill(d, d+v+1, INF);
    while(e--){
        int u,v,w;
        cin>>u>>v>>w;
        adj[u].push_back({w, v}); //u번 정점에서 v로 갈 때 가중치는 w
    }
    priority_queue<pair<int, int>, 
                    vector<pair<int, int>>, 
                    greater<pair<int, int>>> pq;
    d[st] = 0;
    pq.push({d[st], st}); //거리, 정점
    while(!pq.empty()){
        auto cur = pq.top(); pq.pop();
        if(d[cur.Y] != cur.X) continue;
        for(auto nxt : adj[cur.Y]){ //cur.Y에서 뻗어나가는 간선들 (거리,목적지)
            if(d[nxt.Y] <= d[cur.Y] + nxt.X) continue;
            d[nxt.Y] = d[cur.Y] + nxt.X;
            pq.push({d[nxt.Y], nxt.Y});
        }
    }
    for(int i=1; i<=v; i++){
        if(d[i] == INF) cout<<"INF\n";
        else cout<<d[i] << '\n';
    }

}