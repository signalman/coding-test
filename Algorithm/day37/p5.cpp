#include <bits/stdc++.h>
using namespace std;

const int MX = 1e5+5;
int n, m;
vector<pair<int, int>> adj[MX];
int d[1005];
int p[1005];
int main(){
    cin>>n>>m;
    for(int i=0; i<m; i++){
        int u, v, w;
        cin>>u>>v>>w;
        adj[u].push_back({w, v});
    }
    int st, en;
    cin>>st>>en;

    fill(d, d+1005, 0x7f7f7f7f);
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    d[st] = 0;
    pq.push({d[st], st});
    while(!pq.empty()){
        auto cur = pq.top(); pq.pop();

        if(cur.first != d[cur.second]) continue;
        for(auto nxt: adj[cur.second]){
            if(d[nxt.second] <= d[cur.second] + nxt.first) continue;
            d[nxt.second] = d[cur.second] + nxt.first;
            p[nxt.second] = p[cur.second];
            pq.push({d[nxt.second], nxt.second});
        }
    }
    cout<<d[en]<<'\n';

    while(true){
        cout<<p[en];
        if(p[en] == st) break;
        en = p[en];

    }

}