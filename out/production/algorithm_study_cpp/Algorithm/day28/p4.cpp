#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second

const int INF = 1e9+10;
int v,e,st;
vector<pair<int, int>> adj[20005];
int d[20005];

int main(){
    cin>>v>>e>>st;
    fill(d, d+v+1, INF);
    while(e--){
        int u, v, w;
        cin>>u>>v>>w;
        adj[u].push_back({w, v});
    }
    priority_queue<pair<int, int>, 
                        vector<pair<int, int>>, 
                        greater<pair<int, int>>> pq;


    d[st] = 0;
    pq.push({d[st], st}); //거리, 도착점
    while(!pq.empty()){
        auto cur = pq.top(); pq.pop();
        if(d[cur.Y] != cur.X) continue;
        for(auto nxt : adj[cur.Y]){
            // nxt.Y: cur.Y와 연결되어있는 정점
            // nxt.X: cur.Y와 nxt.Y사이의 거리
            if(d[nxt.Y] <= d[cur.Y] + nxt.X) continue;
            d[nxt.Y] = d[cur.Y] + nxt.X;
            pq.push({d[nxt.Y], nxt.Y});
        }

    }
    

}