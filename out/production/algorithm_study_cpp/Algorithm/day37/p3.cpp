#include <bits/stdc++.h>
using namespace std;

int n, m, x;
vector<pair<int, int>> adj[1005];
int d[1005];

int dijkstra(int st, int en){
    fill(d, d + 1005, 0x7f7f7f7f);
    d[st] = 0;
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>>pq;
    pq.push({d[st], st});
    while(!pq.empty()){
        auto cur = pq.top(); pq.pop();
        if(cur.first != d[cur.second]) continue;

        for(auto nxt: adj[cur.second]){
            if(d[nxt.second] <= d[cur.second] + nxt.first) continue;
            d[nxt.second] = d[cur.second] + nxt.first;
            pq.push({d[nxt.second], nxt.second});
        }
    }
    return d[en];
}

int main(){
    cin>>n>>m>>x;
    while(m--){
        int u, v, w;
        cin>>u>>v>>w;
        adj[u].push_back({w, v});
    }
    int ans = 0;
    for(int i=1; i<=n; i++){
        ans = max(ans, dijkstra(x, i) + dijkstra(i, x));
    }
    cout<<ans;
}