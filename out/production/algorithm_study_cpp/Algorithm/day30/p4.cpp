#include <bits/stdc++.h>
using namespace std;
#define MX 1002

vector<pair<int, int>> adj[MX];
int n, m;
int d[MX];

int dist(int st, int en){
    fill(d, d+n+1, -1);
    d[st] = 0;
    queue<int> q;
    q.push(st);
    while(!q.empty()){
        int cur = q.front();
        q.pop();
        if(cur == en) return d[en];
        for(auto nxt: adj[cur]){
            if(d[nxt.second] != -1) continue;
            d[nxt.second] = d[cur] + nxt.first;
            q.push(nxt.second);
        }
    }
    return d[en];
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin>>n>>m;
    for(int i=0; i<n-1; i++){
        int u, v, d;
        cin>>u>>v>>d;
        adj[u].push_back({d, v});
        adj[v].push_back({d, u});
    }
    for(int i=0; i<m; i++){
        int u, v;
        cin>>u>>v;
        cout<<dist(u, v)<<'\n';
    }

}