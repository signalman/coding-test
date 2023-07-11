#include <bits/stdc++.h>
using namespace std;

int n, m;
vector<pair<int, int>> adj[1005];
int d[1005];

int dijkstra(int st, int en){
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    fill(d, d+1005, 0x3f3f3f3f);
    d[st] = 0;
    pq.push({d[st], st});

    while(!pq.empty()){
        auto cur = pq.top(); pq.pop();
        if(d[cur.second] != cur.first) continue;
        for(auto nxt: adj[cur.second]){
            if(d[nxt.second] <= d[cur.second] + nxt.first) continue;
            d[nxt.second] = d[cur.second] + nxt.first;
            pq.push({d[nxt.second], nxt.second});
        }
    }
    return d[en];
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin>>n>>m;
    for(int i=0; i<m; i++){
        int u, v, w;
        cin>>u>>v>>w;
        adj[u].push_back({w, v});
    }
    int st, en;
    cin>>st>>en;
    cout<<dijkstra(st, en);
}